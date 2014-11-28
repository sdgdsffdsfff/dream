angular.module("console").controller("PortalCtrl", ["$scope", "$rootScope", "$sce", "$route", function ($scope, $rootScope, $sce, $route) {

	$scope.menuGroups = [
		{
			name: "微信上墙",
			menus: [
			    {title: "公共账号维护", url: "#/pubAccount"},
			    {title: "活动维护", url: "#/activity"},
			    {title: "上墙信息管理", url: "#/wallInfo"},
			    {title: "中奖规则维护", url: "#/lotteryRule"},
			    {title: "中奖统计", url: "#/lotteryInfo"}
			]
		},   
		{
			name: "系统管理",
			menus: [
			    {title: "密码修改", url: "#/password"},
			]
		}
	];
	
	$scope.selectedGroup = $scope.menuGroups[0];
	
	$scope.selectedMenu = null;

	$scope.selectGroup = function (group) {
		$scope.selectedGroup = group;
		if (group.menus.length > 0) {
			$scope.selectMenu(group.menus[0]);
		}
	};

	$scope.groupClass = function (group) {
		if (group == $scope.selectedGroup) {
			return "accordion-item-heading active";
		}
		else {
			return "accordion-item-heading";
		}
	};

	$scope.selectMenu = function (menuItem) {
		$scope.selectedMenu = menuItem;
	};

	$scope.menuClass = function (menuItem) {
		if (menuItem == $scope.selectedMenu) {
			return "active";
		}
		else {
			return "";
		}
	};

	$scope.menuIconClass = function (menuItem) {
		if (menuItem == $scope.selectedMenu) {
			return "icon";
		}
		else {
			return "";
		}
	};

	$scope.trust = function (iconText) {
		return $sce.trustAsHtml(iconText);
	};
	$rootScope.$on("$routeChangeSuccess", function (evt, route) {
		if (!route.$$route) {
			return;
		}
		var path = route.$$route.originalPath;
		for (var i = 0; i < $scope.menuGroups.length; i++) {
			for (var j = 0; j < $scope.menuGroups[i].menus.length; j++) {
				var menu = $scope.menuGroups[i].menus[j];
				if (menu.url && path.indexOf(menu.url.slice(1, menu.url.length)) == 0) {
					$scope.selectedGroup = $scope.menuGroups[i];
					$scope.selectedMenu = menu;
					return;
				}
			}
		}
	});
}]);