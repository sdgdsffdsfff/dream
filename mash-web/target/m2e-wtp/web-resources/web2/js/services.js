angular.module("console").service("UIDService", [function () {
	return {
		uuid: function () {
			return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
				var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
				return v.toString(16);
			});
		}
	};
}]);

angular.module("console").service("AreaService", [function () {
	var provinces = ["安徽", "北京", "福建", "甘肃", "广东", "广西", "贵州", "海南", "河北", "河南", "黑龙江", "湖北", "湖南", "吉林", "江苏", "江西", "辽宁", "内蒙古", "宁夏", "青海", "山东", "山西", "陕西", "上海", "四川", "天津", "西藏", "新疆", "云南", "浙江", "重庆"];

	var cities = [
		["安庆", "蚌埠", "巢湖", "池州", "滁州", "阜阳", "合肥", "淮北", "淮南", "黄山", "六安", "马鞍山", "宿州", "铜陵", "芜湖", "宣城", "亳州"],
		["北京"],
		["福州", "龙岩", "南平", "宁德", "莆田", "泉州", "三明", "厦门", "漳州"],
		["白银", "定西", "甘南藏族自治州", "嘉峪关", "金昌", "酒泉", "兰州", "临夏回族自治州", "陇南", "平凉", "庆阳", "天水", "武威", "张掖"],
		["潮州", "东莞", "佛山", "广州", "河源", "惠州", "江门", "揭阳", "茂名", "梅州", "清远", "汕头", "汕尾", "韶关", "深圳", "阳江", "云浮", "湛江", "肇庆", "中山", "珠海"],
		["百色", "北海", "崇左", "防城港", "桂林", "贵港", "河池", "贺州", "来宾", "柳州", "南宁", "钦州", "梧州", "玉林"],
		["安顺", "毕节", "贵阳", "六盘水", "黔东南苗族侗族自治州", "黔南布依族苗族自治州", "黔西南布依族苗族自治州", "铜仁", "遵义"],
		["白沙黎族自治县", "保亭黎族苗族自治县", "昌江黎族自治县", "澄迈县", "定安县", "东方", "海口", "乐东黎族自治县", "临高县", "陵水黎族自治县", "琼海", "琼中黎族苗族自治县", "三亚", "屯昌县", "万宁", "文昌", "五指山", "儋州"],
		["保定", "沧州", "承德", "邯郸", "衡水", "廊坊", "秦皇岛", "石家庄", "唐山", "邢台", "张家口"],
		["安阳", "鹤壁", "济源", "焦作", "开封", "洛阳", "南阳", "平顶山", "三门峡", "商丘", "新乡", "信阳", "许昌", "郑州", "周口", "驻马店", "漯河", "濮阳"],
		["大庆", "大兴安岭", "哈尔滨", "鹤岗", "黑河", "鸡西", "佳木斯", "牡丹江", "七台河", "齐齐哈尔", "双鸭山", "绥化", "伊春"],
		["鄂州", "恩施土家族苗族自治州", "黄冈", "黄石", "荆门", "荆州", "潜江", "神农架林区", "十堰", "随州", "天门", "武汉", "仙桃", "咸宁", "襄樊", "孝感", "宜昌"],
		["常德", "长沙", "郴州", "衡阳", "怀化", "娄底", "邵阳", "湘潭", "湘西土家族苗族自治州", "益阳", "永州", "岳阳", "张家界", "株洲"],
		["白城", "白山", "长春", "吉林", "辽源", "四平", "松原", "通化", "延边朝鲜族自治州"],
		["常州", "淮安", "连云港", "南京", "南通", "苏州", "宿迁", "泰州", "无锡", "徐州", "盐城", "扬州", "镇江"],
		["抚州", "赣州", "吉安", "景德镇", "九江", "南昌", "萍乡", "上饶", "新余", "宜春", "鹰潭"],
		["鞍山", "本溪", "朝阳", "大连", "丹东", "抚顺", "阜新", "葫芦岛", "锦州", "辽阳", "盘锦", "沈阳", "铁岭", "营口"],
		["阿拉善盟", "巴彦淖尔盟", "包头", "赤峰", "鄂尔多斯", "呼和浩特", "呼伦贝尔", "通辽", "乌海", "乌兰察布盟", "锡林郭勒盟", "兴安盟"],
		["固原", "石嘴山", "吴忠", "银川"],
		["果洛藏族自治州", "海北藏族自治州", "海东", "海南藏族自治州", "海西蒙古族藏族自治州", "黄南藏族自治州", "西宁", "玉树藏族自治州"],
		["滨州", "德州", "东营", "菏泽", "济南", "济宁", "莱芜", "聊城", "临沂", "青岛", "日照", "泰安", "威海", "潍坊", "烟台", "枣庄", "淄博"],
		["长治", "大同", "晋城", "晋中", "临汾", "吕梁", "朔州", "太原", "忻州", "阳泉", "运城"],
		["安康", "宝鸡", "汉中", "商洛", "铜川", "渭南", "西安", "咸阳", "延安", "榆林"],
		["上海"],
		["阿坝藏族羌族自治州", "巴中", "成都", "达州", "德阳", "甘孜藏族自治州", "广安", "广元", "乐山", "凉山彝族自治州", "眉山", "绵阳", "南充", "内江", "攀枝花", "遂宁", "雅安", "宜宾", "资阳", "自贡", "泸州"],
		["天津"],
		["阿里", "昌都", "拉萨", "林芝", "那曲", "日喀则", "山南"],
		["阿克苏", "阿拉尔", "巴音郭楞蒙古自治州", "博尔塔拉蒙古自治州", "昌吉回族自治州", "哈密", "和田", "喀什", "克拉玛依", "克孜勒苏柯尔克孜自治州", "石河子", "图木舒克", "吐鲁番", "乌鲁木齐", "五家渠", "伊犁哈萨克自治州"],
		["保山", "楚雄彝族自治州", "大理白族自治州", "德宏傣族景颇族自治州", "迪庆藏族自治州", "红河哈尼族彝族自治州", "昆明", "丽江", "临沧", "怒江傈傈族自治州", "曲靖", "思茅", "文山壮族苗族自治州", "西双版纳傣族自治州", "玉溪", "昭通"],
		["杭州", "湖州", "嘉兴", "金华", "丽水", "宁波", "绍兴", "台州", "温州", "舟山", "衢州"],
		["重庆"]
	];

	function combineArea() {
		var areas = [];

		for (var i = 0; i < provinces.length; i++) {
			var children = [];
			for (var j = 0; j < cities[i].length; j++) {
				children.push({
					name: cities[i][j]
				});
			}

			var province = {
				name: provinces[i],
				children: children
			};

			areas.push(province);
		}
		return areas;
	}

	return {
		area: combineArea()
	}
}]);

angular.module("console").service("HttpService", ["$http", "$q", "$document", "$location", "AlertService", function ($http, $q, $document, $location, AlertService) {
	var zIndex = 1300;
	var mask = angular.element('<div class="modal-backdrop fade in"></div>');

	mask.css("z-index", zIndex);

	var counter = 0;

	function showLoading(text) {
		if (counter == 0) {
			$document.find("body").append(mask);
		}
		counter++;

		var loading = angular.element(
				'<div class="modal fade in" style="display:block">' +
				'<div class="modal-dialog">' +
				'<div class="modal-content">' +
				'<div class="modal-header">' +
					(text || '正在请求数据...') +
				'</div>' +
				'<div class="modal-body">' +
				'<div class="progress">' +
				'<div class="progress-bar progress-bar-striped active" role="progressbar" style="width: 100%">' +
				'<span class="sr-only">loading</span>' +
				'</div></div></div></div></div></div>');
		$document.find("body").append(loading);
		loading.css("z-index", zIndex + counter + 1);

		return loading;
	}

	function hideLoading(loading) {
		counter--;
		if (counter == 0) {
			mask.remove();
		}
		loading.remove();
	}

	return {
		"get": function (url, param, options) {
			var opt = options || {};
			var defer = $q.defer();

			var loading;
			if (!opt.noMask) {
				loading = showLoading(opt.hint);
			}

			$http.get(url, {"params": param}).success(function (result) {
				if (!opt.noMask) {
					hideLoading(loading);
				}

				defer.resolve(result);
			}).error(function (reason, status) {
				if (!opt.noMask) {
					hideLoading(loading);
				}

				if (status == "911") {
					AlertService.alert({title: "会话失效", content: "请重新登录！"})
						.then(function() {
							window.location = "/cloud-web-in/index.htm";
						});
				}
				else {
					AlertService.alert({title: "服务端异常", content: reason});
				}
				//defer.reject(reason);
			});

			return defer.promise;
		},
		"post": function (url, param, options) {
			var opt = options || {};
			var defer = $q.defer();

			var loading;
			if (!opt.noMask) {
				loading = showLoading(opt.hint);
			}

			$http.post(url, {"params": param}).success(function (result) {
				if (!opt.noMask) {
					hideLoading(loading);
				}

				defer.resolve(result);
			}).error(function (reason, status) {
				if (!opt.noMask) {
					hideLoading(loading);
				}

				if (status == "911") {
					AlertService.alert({title: "会话失效", content: "请重新登录！"})
						.then(function() {
							window.location = "index.htm";
						});
				}
				else {
					AlertService.alert({title: "服务端异常", content: reason});
				}
				//defer.reject(reason);
			});

			return defer.promise;
		}
	};
}]);

angular.module("console").service("EventBus", [function () {
	var eventMap = {};

	return {
		on: function (eventType, handler) {
			//multiple event listener
			if (!eventMap[eventType]) {
				eventMap[eventType] = [];
			}
			eventMap[eventType].push(handler);
		},

		off: function (eventType, handler) {
			for (var i = 0; i < eventMap[eventType].length; i++) {
				if (eventMap[eventType][i] === handler) {
					eventMap[eventType].splice(i, 1);
					break;
				}
			}
		},

		fire: function (event) {
			var eventType = event.type;
			if (eventMap[eventType]) {
				for (var i = 0; i < eventMap[eventType].length; i++) {
					eventMap[eventType][i](event);
				}
			}
		}
	};
}]);

angular.module("console").service("MessageService", [function () {
	return {
		register: function () {

		}
	};
}]);

angular.module("console").service("StorageService", ["$window", "UIDService", function ($window, UIDService) {
	var ls = $window.localStorage;

	return {
		create: function (collectionName) {
			ls.setItem(collectionName, JSON.stringify([]));
		},
		insert: function (collectionName, obj) {
			var cache = JSON.parse(ls.getItem(collectionName)) || [];
			obj.$id = UIDService.uuid();
			cache.push(obj);
			ls.setItem(collectionName, JSON.stringify(cache));
		},
		update: function (collectionName, obj) {

		},
		remove: function (collectionName, obj) {
			if (!obj) {
				ls.removeItem(collectionName);
			}
			else {
				var cache = JSON.parse(ls.getItem(collectionName)) || [];
				for (var i = 0; i < cache.length; i++) {
					if (cache[i].$id == obj.$id) {
						cache.splice(i, 1);
						break;
					}
				}
				ls.setItem(collectionName, JSON.stringify(cache));
			}
		},
		find: function () {

		}
	};
}]);