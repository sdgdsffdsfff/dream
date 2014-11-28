angular.module("sn.controls", []);

angular.module("sn.controls").service("DialogService", ["$http", "$document", "$rootScope", "$compile", function ($http, $document, $rootScope, $compile) {
	var zIndex = 1050;
	var dialogCounter = 0;

	var dialogMap = {};
	return {
		modal: function (param, data) {
			$http.get(param.url).then(function (result) {
				dialogCounter += 2;

				var mask = angular.element('<div class="modal-backdrop fade in"></div>');
				$document.find("body").append(mask);
				mask.css("z-index", zIndex + dialogCounter);

				var dialog = angular.element(result.data);
				var newScope = $rootScope.$new();
				if (data) {
					angular.extend(newScope, data);
				}
				var element = $compile(dialog)(newScope);

				$document.find("body").append(element);
				element.css("display", "block");
				element.css("z-index", zIndex + dialogCounter + 1);

				dialogMap[param.key] = param;
				dialogMap[param.key].dialog = element;
				dialogMap[param.key].mask = mask;
			});
		},

		accept: function (key, result) {
			this.dismiss(key);

			if (dialogMap[key].accept) {
				dialogMap[key].accept(result);
			}
		},

		refuse: function (key, reason) {
			this.dismiss(key);

			if (dialogMap[key].refuse) {
				dialogMap[key].refuse(reason);
			}
		},

		dismiss: function (key) {
			dialogMap[key].mask.remove();
			dialogMap[key].dialog.remove();
		},

		postMessage: function (key, type, message) {
			if (dialogMap[key].messageHandler) {
				if (dialogMap[key].messageHandler[type]) {
					dialogMap[key].messageHandler[type](message);
				}
			}
		}
	};
}]);

angular.module("sn.controls").service("AlertService", ["$http", "$document", "$q", "$rootScope", "$compile", function ($http, $document, $q, $rootScope, $compile) {
	var zIndex = 1200;
	var dialogCounter = 0;

	var mask = angular.element('<div class="modal-backdrop fade in"></div>');
	mask.css("z-index", zIndex);

	function getTemplate() {
		var dialogTpl;
		var defer = $q.defer();
		if (dialogTpl) {
			defer.resolve(dialogTpl);
		}
		else {
			$http.get("templates/alert/alert.html").then(function (result) {
				dialogTpl = result.data;
				defer.resolve(dialogTpl);
			});
		}
		return defer.promise;
	}

	var service = {
		alert: function (param) {
			var defer = $q.defer();

			getTemplate().then(function (dialogTpl) {
				var dialog;
				dialogCounter++;

				if (dialogCounter == 1) {
					$document.find("body").append(mask);
				}

				var data = $rootScope.$new();
				angular.extend(data, param);

				data.ok = function () {
					service.dismiss(dialog);
					defer.resolve("ok");
				};
				data.close = function () {
					service.dismiss(dialog);
					defer.resolve("ok");
				};

				dialog = $compile(angular.element(dialogTpl))(data);

				$document.find("body").append(dialog);
				dialog.css("display", "block");
				dialog.css("z-index", zIndex + dialogCounter);
			});

			return defer.promise;
		},
		confirm: function (param) {
			var defer = $q.defer();

			getTemplate().then(function (dialogTpl) {
				var dialog;
				dialogCounter++;

				if (dialogCounter == 1) {
					$document.find("body").append(mask);
				}

				var data = $rootScope.$new();
				angular.extend(data, param);

				data.ok = function () {
					service.dismiss(dialog);
					defer.resolve("ok");
				};
				data.cancel = function () {
					service.dismiss(dialog);
					defer.reject("cancel");
				};
				data.close = function () {
					service.dismiss(dialog);
					defer.reject("cancel");
				};

				dialog = $compile(dialogTpl)(data);

				$document.find("body").append(dialog);
				dialog.css("display", "block");
				dialog.css("z-index", zIndex + dialogCounter);
			});

			return defer.promise;
		},
		dismiss: function (dialog) {
			dialogCounter--;
			dialog.remove();

			if (dialogCounter == 0) {
				mask.remove();
			}
		}
	};

	return service;
}]);

angular.module("sn.controls").service("HintService", ["$http", "$compile", "$rootScope", function ($http, $compile, $rootScope) {
	var container = angular.element(document.getElementById("hintContainer"));

	return {
		hint: function (param, url, duration) {
			$http.get(url || "templates/hint/hint.html").then(function (result) {
				var hint = angular.element(result.data);

				hint.css("display", "block");

				var scope = angular.extend($rootScope.$new(), param);

				$compile(hint)(scope);
				container.prepend(hint);

				setTimeout(function () {
					hint.addClass("in");
				}, 10);

				setTimeout(function () {
					hint.removeClass("in");

					setTimeout(function () {
						hint.remove();
					}, 500);
				}, duration || 5000);
			});
		}
	};
}]);

angular.module("sn.controls").service("UIHelper", function () {
	return {
		getOffset: function (element) {
			var x = 0;
			var y = 0;

			while (element.offsetParent) {
				x += element.offsetLeft;
				y += element.offsetTop;

				element = element.offsetParent;
			}

			return {x: x, y: y};
		}
	};
});

angular.module("sn.controls").directive("snDropdown", ["$document", function ($document) {
	return {
		restrict: "A",
		link: function (scope, element, attrs) {
			element.find("button").on("click", function (evt) {
				element.toggleClass("open");

				evt.preventDefault();
				evt.stopPropagation();
			});

			$document.on("click", function () {
				element.removeClass("open");
			});
		}
	};
}]);

angular.module("sn.controls").directive("snContextmenu", ["$document", "$http", "UIHelper", function ($document, $http, UIHelper) {
	return {
		restrict: "A",
		link: function (scope, element, attrs) {
			var menu = angular.element('<ul class="dropdown-menu"></ul>');

			var menuArr = scope.$eval(attrs.snContextmenu);

			for (var i = 0; i < menuArr.length; i++) {
				if (menuArr[i].action) {
					var menuItem = angular.element('<li><a>' + menuArr[i].title + '</a></li>');
					menuItem.on("click", (function (index) {
						return function () {
							menu.css("display", "none");
							menuArr[index].action();
						};
					})(i));
					menu.append(menuItem);
				}
				else {
					menu.append('<li class="divider"></li>');
				}
			}

			element.on("contextmenu", function (evt) {
				var mouseX = evt.clientX;
				var mouseY = evt.clientY;

				if ($document.find("body")[0].contains(menu[0])) {
					menu.css("display", "block");
				}
				else {
					$document.find("body").append(menu);
				}

				menu.css("display", "block");
				menu.css("left", mouseX + "px");
				menu.css("top", mouseY + "px");

				evt.stopPropagation();
				evt.preventDefault();

				if ($document.currentMenu && $document.currentMenu != menu) {
					$document.currentMenu.css("display", "none");
				}

				$document.currentMenu = menu;
			});

			$document.on("click", function (evt) {
				menu.css("display", "none");
			});
		}
	};
}]);

angular.module("sn.controls").directive("snTooltip", ["$document", "$http", "UIHelper", function ($document, $http, UIHelper) {
	return {
		restrict: "A",
		link: function (scope, element, attrs) {
			var url = attrs.snTooltip;
			var popover;

			$http.get(url).then(function (result) {
				popover = angular.element(result.data);

				element.on("mouseenter", function () {
					var position = UIHelper.getOffset(element[0]);

					popover.css("display", "block");
					popover.css("left", position.x + "px");
					popover.css("top", position.y + element[0].offsetHeight + "px");

					$document.find("body").append(popover);
				});

				element.on("mouseleave", function () {
					popover.remove();
				});
			});
		}
	};
}]);

angular.module("sn.controls").directive('snPager', function () {
	return {
		restrict: 'E',
		scope: {},
		controller: function ($scope, pagerConfig) {
			$scope.pages = [];

			$scope.currentPage = 0;
			$scope.totalPages = 1;
			$scope.totalItems = 0;
			$scope.pageOffset = 0;

			var initialized = false;

			$scope.$watch("totalItems", function () {
				if ($scope.totalItems % $scope.itemsPerPage == 0) {
					$scope.totalPages = $scope.totalItems / $scope.itemsPerPage;
				} else {
					$scope.totalPages = Math.ceil($scope.totalItems / $scope.itemsPerPage);
				}

				if ($scope.totalPages == 0) {
					$scope.totalPages = 1;
				}

				if (initialized) {
					if (($scope.pageOffset > $scope.totalPages)) {
						$scope.pageOffset = 0;

						if (($scope.currentPage < $scope.pageOffset)
							|| ($scope.currentPage >= $scope.pageOffset + $scope.pages.length)) {
							$scope.currentPage = 0;
						}
					}
				}
				resetPageList();

				initialized = true;

				if ($scope.pages[$scope.currentPage - $scope.pageOffset]) {
					$scope.pages[$scope.currentPage - $scope.pageOffset].active = true;
				}
			});

			function getOffset(page) {
				var offset = Math.min(page, $scope.totalPages - $scope.listSize);
				if (offset < 0) {
					offset = 0;
				}

				return offset;
			}

			function resetPageList() {
				$scope.pages = [];

				var last = Math.min($scope.pageOffset + $scope.listSize, $scope.totalPages);
				for (var i = $scope.pageOffset; i < last; i++) {
					$scope.pages.push({
						text: i,
						pageIndex: i,
						active: false
					});
				}
			};

			$scope.getText = function (key) {
				return pagerConfig.text[key];
			};

			$scope.isFirst = function () {
				return $scope.currentPage <= 0;
			};

			$scope.isLast = function () {
				return $scope.currentPage >= $scope.totalPages - 1;
			};

			$scope.selectPage = function (value) {
				if ((value >= $scope.totalPages) || (value < 0)) {
					return;
				}

				if ($scope.pages[$scope.currentPage - $scope.pageOffset]) {
					$scope.pages[$scope.currentPage - $scope.pageOffset].active = false;
				}

				if ((value < $scope.pageOffset) || (value >= $scope.pageOffset + $scope.pages.length)) {
					var offset = getOffset(value);
					if (offset != $scope.pageOffset) {
						$scope.pageOffset = offset;
						resetPageList();
					}
				}

				$scope.currentPage = value;

				$scope.pages[$scope.currentPage - $scope.pageOffset].active = true;

				$scope.$emit("sn.controls.pager:pageIndexChanged", $scope.pages[$scope.currentPage - $scope.pageOffset]);
			};

			$scope.first = function () {
				if (this.isFirst()) {
					return;
				}
				this.selectPage(0);
			};

			$scope.last = function () {
				if (this.isLast()) {
					return;
				}
				this.selectPage(this.totalPages - 1);
			};

			$scope.previous = function () {
				if (this.isFirst()) {
					return;
				}
				this.selectPage(this.currentPage - 1);
			};

			$scope.next = function () {
				if (this.isLast()) {
					return;
				}
				this.selectPage(this.currentPage + 1);
			};
		},
		link: function (scope, element, attrs) {
			scope.itemsPerPage = (attrs.itemsperpage - 0) || 10;
			scope.listSize = (attrs.listsize - 0) || 10;

			attrs.$observe("totalitems", function (value) {
				scope.totalItems = value;
			});
		},
		templateUrl: 'templates/pager/pager.html'
	};
}).constant('pagerConfig', {
	itemsPerPage: 10,
	text: {
		first: '首页',
		previous: '上一页',
		next: '下一页',
		last: '末页'
	}
});

angular.module("sn.controls").directive("snCalendar", [function () {
	return {
		restrict: "E",
		scope: {},
		controller: function ($scope) {
			$scope.viewMode = 0;

			$scope.years = [];
			$scope.months = ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"];

			$scope.calendar = [];
			$scope.weekdays = ["日", "一", "二", "三", "四", "五", "六"];

			function init() {
				var now = new Date();
				$scope.currentYear = $scope.currentYear || now.getFullYear();
				$scope.currentMonth = $scope.currentMonth || now.getMonth();
				$scope.currentDate = $scope.currentDate || now.getDate();
			}

			init();

			$scope.$watch("currentYear", function (newYear, oldYear) {
				if (newYear != oldYear) {
					$scope.$emit("sn.controls.calendar:yearChanged", newYear);
				}

				generateYears(newYear);
				generateCalendar(newYear, $scope.currentMonth);
			});

			$scope.$watch("currentMonth", function (newMonth, oldMonth) {
				if (newMonth != oldMonth) {
					$scope.$emit("sn.controls.calendar:monthChanged", newMonth);
				}

				generateCalendar($scope.currentYear, newMonth);
			});

			$scope.$watch("currentDate", function (newDate, oldDate) {
				if (newDate != oldDate) {
					$scope.$emit("sn.controls.calendar:dateChanged", newDate);
				}
			});

			function generateCalendar(year, month) {
				$scope.calendar = [
					[]
				];

				var offset = new Date(new Date(year, month, 1)).getDay();
				var lastDay = new Date(new Date(year, month + 1, 1) - 1);

				for (var day = offset; day < lastDay.getDate() + offset; day++) {
					if (!$scope.calendar[Math.floor(day / 7)]) {
						$scope.calendar[Math.floor(day / 7)] = [];
					}
					$scope.calendar[Math.floor(day / 7)][day % 7] = day - offset + 1;
				}
			}

			function generateYears(newYear) {
				$scope.years = [];
				var startIndex = Math.floor(newYear / 10) * 10 + 1;

				for (var year = 0; year < 10; year++) {
					$scope.years.push(startIndex + year);
				}
			}

			$scope.dateClass = function (date) {
				if ($scope.currentDate == date) {
					return "active today";
				}
				else {
					return "day";
				}
			};

			$scope.monthClass = function (month) {
				if ($scope.currentMonth == month) {
					return "active month";
				}
				else {
					return "month";
				}
			};

			$scope.yearClass = function (year) {
				if ($scope.currentYear == year) {
					return "active year";
				}
				else {
					return "year";
				}
			};

			$scope.selectDate = function (date) {
				if (date) {
					if (date == $scope.currentDate) {
						$scope.$emit("sn.controls.calendar:dateChanged", date);
					}
					else {
						$scope.currentDate = date;
					}
				}
			};

			$scope.selectMonth = function (month) {
				$scope.currentMonth = month;
				$scope.switchView(0);
			};

			$scope.selectYear = function (year) {
				$scope.currentYear = year;
				$scope.switchView(1);
			};

			$scope.currentMonthStr = function () {
				return $scope.currentYear + "年 " + $scope.months[$scope.currentMonth];
			};

			$scope.currentAgeStr = function () {
				var startIndex = Math.floor($scope.currentYear / 10) * 10 + 1;
				return startIndex + " - " + (startIndex + 9);
			};

			$scope.previousMonth = function () {
				$scope.currentMonth--;
				resetDate();
			};

			$scope.nextMonth = function () {
				$scope.currentMonth++;
				resetDate();
			};

			$scope.previousYear = function () {
				$scope.currentYear--;
				resetDate();
			};

			$scope.nextYear = function () {
				$scope.currentYear++;
				resetDate();
			};

			$scope.previousAge = function () {
				$scope.currentYear -= 10;
			};

			$scope.nextAge = function () {
				$scope.currentYear += 10;
			};

			function resetDate() {
				var current = new Date($scope.currentYear, $scope.currentMonth, $scope.currentDate);

				$scope.currentYear = current.getFullYear();
				$scope.currentMonth = current.getMonth();
				$scope.currentDate = current.getDate();
			}

			$scope.switchView = function (view) {
				//0：日期；1：月；2：年
				$scope.viewMode = view;
			};
		},
		link: function (scope, element, attrs) {
			if (attrs["initYear"]) {
				scope.currentYear = scope.$parent.$eval(attrs["initYear"]);
			}

			if (attrs["initMonth"]) {
				scope.currentMonth = scope.$parent.$eval(attrs["initMonth"]);
			}

			if (attrs["initDate"]) {
				scope.currentDate = scope.$parent.$eval(attrs["initDate"]);
			}
		},
		templateUrl: "templates/calendar/calendar.html"
	}
}]);

angular.module("sn.controls").directive("snTimepicker", [function () {
	return {
		restrict: "E",
		scope: {},
		controller: function ($scope) {
			$scope.viewMode = 3;

			$scope.hours = [];
			$scope.minutes = [];
			$scope.seconds = [];

			for (var i = 0; i < 24; i++) {
				$scope.hours.push(i);
			}

			for (var j = 0; j < 60; j++) {
				$scope.minutes.push(j);
			}

			for (var k = 0; k < 60; k++) {
				$scope.seconds.push(k);
			}

			function init() {
				var now = new Date();
				$scope.currentHour = $scope.currentHour || now.getHours();
				$scope.currentMinute = $scope.currentMinute || now.getMinutes();
				$scope.currentSecond = $scope.currentSecond || now.getSeconds();
			}

			init();

			$scope.$watch("currentHour", function (newHour, oldHour) {
				if (newHour != oldHour) {
					$scope.$emit("sn.controls.timePicker:hourChanged", newHour);
				}
			});

			$scope.$watch("currentMinute", function (newMinute, oldMinute) {
				if (newMinute != oldMinute) {
					$scope.$emit("sn.controls.timePicker:minuteChanged", newMinute);
				}
			});

			$scope.$watch("currentSecond", function (newSecond, oldSecond) {
				if (newSecond != oldSecond) {
					$scope.$emit("sn.controls.timePicker:secondChanged", newSecond);
				}
			});

			$scope.hourClass = function (hour) {
				if ($scope.currentHour == hour) {
					return "active hour";
				}
				else {
					return "hour";
				}
			};

			$scope.minuteClass = function (minute) {
				if ($scope.currentMinute == minute) {
					return "active minute";
				}
				else {
					return "minute";
				}
			};

			$scope.secondClass = function (second) {
				if ($scope.currentSecond == second) {
					return "active second";
				}
				else {
					return "second";
				}
			};

			$scope.selectHour = function (hour) {
				$scope.currentHour = hour;
				$scope.switchView(3);
			};

			$scope.selectMinute = function (minute) {
				$scope.currentMinute = minute;
				$scope.switchView(3);
			};

			$scope.selectSecond = function (second) {
				$scope.currentSecond = second;
				$scope.switchView(3);
			};

			$scope.increaseHour = function () {
				$scope.currentHour = ($scope.currentHour + 1) % 24;
			};

			$scope.decreaseHour = function () {
				$scope.currentHour = ($scope.currentHour + 23) % 24;
			};

			$scope.increaseMinute = function () {
				$scope.currentMinute = ($scope.currentMinute + 1) % 60;
			};

			$scope.decreaseMinute = function () {
				$scope.currentMinute = ($scope.currentMinute + 59) % 60;
			};

			$scope.increaseSecond = function () {
				$scope.currentSecond = ($scope.currentSecond + 1) % 60;
			};

			$scope.decreaseSecond = function () {
				$scope.currentSecond = ($scope.currentSecond + 59) % 60;
			};

			$scope.switchView = function (view) {
				//0：整体视图；1：时；2：分；3：秒
				$scope.viewMode = view;
			};
		},
		link: function (scope, element, attrs) {
			if (attrs["initHour"]) {
				scope.currentHour = scope.$parent.$eval(attrs["initHour"]);
			}

			if (attrs["initMinute"]) {
				scope.currentMinute = scope.$parent.$eval(attrs["initMinute"]);
			}

			if (attrs["initSecond"]) {
				scope.currentSecond = scope.$parent.$eval(attrs["initSecond"]);
			}
		},
		templateUrl: "templates/timepicker/timepicker.html"
	}
}]);

angular.module("sn.controls").directive("snDatetimepicker", ["$document", "$filter", function ($document, $filter) {
	return {
		restrict: "E",
		scope: {
			currentDate: "=ngModel"
		},
		link: function (scope, element, attrs) {
			scope.placeholder = attrs["placeholder"] || "请选择日期";

			element.find("input").attr("placeholder", scope.placeholder);

			$document.on("click", function (evt) {
				var src = evt.srcElement ? evt.srcElement : evt.target;
				if ((scope.pop) && (!element[0].contains(src))) {
					scope.pop = false;
				}
			});
		},
		controller: function ($scope) {
			$scope.$watch("currentDate", function(newDate) {
				$scope.currentDateStr = $filter('date')(newDate, "yyyy-MM-dd");
			});

			var date = $scope.currentDate || (new Date());
			$scope.initYear = date.getFullYear();
			$scope.initMonth = date.getMonth();
			$scope.initDate = date.getDate();
			$scope.initHour = date.getHours();
			$scope.initMinute = date.getMinutes();
			$scope.initSecond = date.getSeconds();

			$scope.datetimepickerClass = function () {
				if ($scope.pop) {
					return "input-group date open";
				}
				else {
					return "input-group date";
				}
			};

			var initialized = false;
			$scope.showPop = function() {
				if (!initialized) {
					if (!$scope.currentDate) {
						buildDate();
					}
				}
				$scope.pop = true;
				initialized = true;
			};

			function buildDate() {
				var now = new Date();
				$scope.year = $scope.year || now.getFullYear();
				$scope.month = $scope.month || now.getMonth();
				$scope.date = $scope.date || now.getDate();
				$scope.hour = $scope.hour || now.getHours();
				$scope.minute = $scope.minute || now.getMinutes();
				$scope.second = $scope.second || now.getSeconds();

				$scope.currentDate = new Date(
					$scope.year,
					$scope.month,
					$scope.date,
					$scope.hour,
					$scope.minute,
					$scope.second
				);
				$scope.currentDateStr = $filter('date')($scope.currentDate, "yyyy-MM-dd");

				if ($scope.$modelKey) {
					$scope.$parent[$scope.$modelKey] = $scope.currentDate;
				}
			}

			$scope.$on("sn.controls.calendar:yearChanged", function (evt, year) {
				$scope.year = year;
				buildDate();
				evt.stopPropagation();
			});

			$scope.$on("sn.controls.calendar:monthChanged", function (evt, month) {
				$scope.month = month;
				buildDate();
				evt.stopPropagation();
			});

			$scope.$on("sn.controls.calendar:dateChanged", function (evt, date) {
				$scope.date = date;
				buildDate();
				evt.stopPropagation();
			});

			$scope.$on("sn.controls.timePicker:hourChanged", function (evt, hour) {
				$scope.hour = hour;
				buildDate();
				evt.stopPropagation();
			});

			$scope.$on("sn.controls.timePicker:minuteChanged", function (evt, minute) {
				$scope.minute = minute;
				buildDate();
				evt.stopPropagation();
			});

			$scope.$on("sn.controls.timePicker:secondChanged", function (evt, second) {
				$scope.second = second;
				buildDate();
				evt.stopPropagation();
			});
		},
		templateUrl: "templates/datetimepicker/datetimepicker.html"
	};
}]);

angular.module("sn.controls").directive("snStepper", ["$document", "UIHelper", function ($document, UIHelper) {
	return {
		restrict: "E",
		scope: {},
		controller: function ($scope) {
			$scope.currentStep = 0;
			$scope.maxStep = 10;

			$scope.stepperStyle = function () {
				return {width: ($scope.currentStep * 100 / $scope.maxStep) + "%"};
			};

			$scope.increase = function () {
				$scope.changeValue($scope.currentStep + 1);
			};

			$scope.decrease = function () {
				$scope.changeValue($scope.currentStep - 1);
			};

			$scope.changeValue = function (value) {
				if ((value >= 0) && (value <= $scope.maxStep) && (value != $scope.currentStep)) {
					$scope.currentStep = value;
					$scope.$emit("sn.controls.stepper:stepperValueChanged", $scope.currentStep);
				}
			};
		},
		link: function (scope, element, attrs) {
			scope.maxStep = (attrs["maxstep"] - 0) || 10;

			attrs.$observe("maxstep", function (value) {
				var maxStep = (value - 0) || 0;
				if (maxStep != scope.maxStep) {
					scope.maxStep = maxStep;

					if (scope.currentStep > scope.maxStep) {
						setTimeout(function () {
							scope.changeValue(0);
						}, 0);
					}
				}
			});

			attrs.$observe("currentstep", function (value) {
				var step = (value - 0) || 0;
				if (step != scope.currentStep) {
					setTimeout(function () {
						scope.changeValue(step);
					}, 0);
				}
			});

			element.on("click", function (evt) {
				var src = evt.srcElement ? evt.srcElement : evt.target;

				if (src.tagName != "DIV") {
					return;
				}

				var allWidth = element.children()[0].offsetWidth;
				var currentWidth = evt.offsetX;

				scope.changeValue(Math.round(scope.maxStep * currentWidth / allWidth));
			});

			$document.on("keypress", function (evt) {
				if (evt.keyCode == "45") {
					scope.decrease();
					scope.$digest();
				}
				else if (evt.keyCode == "61") {
					scope.increase();
					scope.$digest();
				}
			});

			var dragging = false;
			var value = scope.currentValue;
			var stepperEle = angular.element(element.find("div")[1]);
			element.find("button").on("mousedown", function () {
				dragging = true;
			});

			element.on("mousemove", function (evt) {
				if (dragging) {
					var allWidth = element.children()[0].offsetWidth;
					var currentWidth = evt.clientX - UIHelper.getOffset(element.find("div")[1]).x;

					var temp = Math.round(scope.maxStep * currentWidth / allWidth);
					if ((temp >= 0) && (temp <= scope.maxStep)) {
						value = temp;

						stepperEle.css("width", (currentWidth - 1) + "px");
					}
				}
			});

			$document.on("mouseup", function () {
				if (dragging) {
					stepperEle.css("width", (value * 100 / scope.maxStep) + "%");

					scope.changeValue(value);
					scope.$digest();
					dragging = false;
				}
			});
		},
		templateUrl: "templates/stepper/stepper.html"
	};
}]);

angular.module("sn.controls").service("LazyLoader", ["$q", function ($q) {
	var createdScripts = {};    //是否已创建script标签
	var pendingScripts = {};    //哪些处于加载过程中

	return {
		load: function (url) {
			var deferred = $q.defer();

			if (!createdScripts[url]) {
				var script = document.createElement('script');
				script.src = encodeURI(url);

				script.onload = function () {
					if (pendingScripts[url]) {
						for (var i = 0; i < pendingScripts[url].length; i++) {
							pendingScripts[url][i].deferred && pendingScripts[url][i].deferred.resolve();
							pendingScripts[url][i].callback && pendingScripts[url][i].callback();
						}
						delete pendingScripts[url];
					}
				};

				createdScripts[url] = script;
				document.body.appendChild(script);

				if (!pendingScripts[url]) {
					pendingScripts[url] = [];
				}
				pendingScripts[url].push({
					deferred: deferred
				});
			}
			else if (pendingScripts[url]) {
				pendingScripts[url].push({
					deferred: deferred
				});
			}
			else {
				deferred.resolve();
			}

			return deferred.promise;
		},
		loadArr: function (arr) {
			var deferred = $q.defer();
			var counter = 0;

			function checkAll() {
				if (counter == arr.length) {
					deferred.resolve();
				}
			}

			for (var j = 0; j < arr.length; j++) {
				var url = arr[j];
				if (!createdScripts[url]) {
					var script = document.createElement('script');
					script.src = encodeURI(url);

					script.onload = function () {
						//这段是唯一需要关注pendingScripts的，因为你是顺带帮别人加载了代码，对你自己并无本质帮助
						if (pendingScripts[url]) {
							for (var i = 0; i < pendingScripts[url].length; i++) {
								pendingScripts[url][i].deferred && pendingScripts[url][i].deferred.resolve();
								pendingScripts[url][i].callback && pendingScripts[url][i].callback();
							}
							delete pendingScripts[url];
						}

						counter++;
						checkAll();
					};

					createdScripts[url] = script;
					document.body.appendChild(script);

					if (!pendingScripts[url]) {
						pendingScripts[url] = [];
					}
					pendingScripts[url].push({
						callback: checkAll
					});
				}
				else if (pendingScripts[url]) {
					//这里很麻烦啊，要是你想加载的js被别人顺带加载了，怎么办？
					pendingScripts[url].push({
						callback: checkAll
					});
				}
				else {
					checkAll();
				}
			}

			return deferred.promise;
		}
	};
}]);

angular.module("sn.controls").directive("chart", ["LazyLoader", function (LazyLoader) {
	return {
		restrict: "A",
		link: function (scope, element, attrs) {
			LazyLoader.load("libs/echarts/echarts-plain.js")
				.then(function () {
					var myChart = echarts.init(element[0]);
					window.onresize = myChart.resize;

					try {
						myChart.setOption(JSON.parse(attrs["chart"]), true);
					} catch (ex) {
						console.log(ex);
					}

					attrs.$observe("chart", function (option) {
						try {
							myChart.setOption(JSON.parse(option), true);
						} catch (ex) {
							console.log(ex);
						}

					}, true);
				});
		}
	};
}]);

angular.module("sn.controls").directive("uploader", ["LazyLoader", function (LazyLoader) {
	return {
		restrict: "A",
		link: function (scope, element, attrs) {
			LazyLoader.loadArr([
				"libs/jquery.min.js", "libs/webuploader/webuploader.js", "libs/webuploader/cloudupload.js"])
				.then(function () {

				});
		}
	};
}]);

angular.module("sn.controls").directive("placeholder", ["$document",
	function ($document) {
		var needsShimByNodeName = {};

		// Determine if we need to perform the visual shimming
		angular.forEach([ 'INPUT', 'TEXTAREA' ], function (val) {
			needsShimByNodeName[val] = $document[0].createElement(val)["placeholder"] === undefined;
		});

		/**
		 * Determine if a given type (string) is a password field
		 *
		 * @param {string} type
		 * @return {boolean}
		 */
		function isPasswordType(type) {
			return type && type.toLowerCase() === "password";
		}

		return {
			require: "ngModel",
			restrict: "A",
			link: function ($scope, $element, $attributes, $controller) {
				var currentValue, text;

				text = $attributes["placeholder"];

				// This does the class toggling depending on if there
				// is a value or not.
				$scope.$watch($attributes.ngModel, function (newVal) {
					currentValue = newVal || "";

					if (!currentValue) {
						$element.addClass("placeholder");
					} else {
						$element.removeClass("placeholder");
					}
				});

				if (needsShimByNodeName[$element[0].nodeName]) {
					// These bound events handle user interaction
					$element.bind("focus", function () {
						if (currentValue === "") {
							// Remove placeholder text
							$element.val("");
						}
					});
					$element.bind("blur", function () {
						if ($element.val() === "") {
							// Add placeholder text
							$element.val(text);
						}
					});

					// This determines if we show placeholder text or not
					// when there was a change detected on scope.
					$controller.$formatters.unshift(function (val) {
						/* Do nothing on password fields, as they would
						 * be filled with asterisks.  Issue #2.
						 */
						if (isPasswordType($element.prop("type"))) {
							return val;
						}

						// Show placeholder text instead of empty value
						return val || text;
					});
				}
			}
		};
	}
]);