angular.module("console", ["ngRoute", "sn.controls"]);

angular.module("console").config(["$locationProvider", "$routeProvider",
	function ($locationProvider, $routeProvider) {
		$routeProvider.when("/", {
			templateUrl: "partials/weixin/pubAccount.html",
			controller: "PubAccountCtrl"
		}).when("/pubAccount", {
			templateUrl: "partials/weixin/pubAccount.html",
			controller: "PubAccountCtrl"
		}).when("/activity", {
			templateUrl: "partials/weixin/activityMaintain.html",
			controller: "ActivityIndexCtrl"
		}).when("/activity/:id", {
			templateUrl: "partials/weixin/activityMaintain.html",
			controller: "ActivityDetailCtrl"
		}).when("/wallInfo", {
			templateUrl: "partials/weixin/wallInfo.html",
			controller: "WallInfoCtrl"
		}).when("/lotteryRule", {
			templateUrl: "partials/weixin/lotteryRuleMaintain.html",
			controller: "LotteryRuleIndexCtrl"
		}).when("/addLotteryRule", {
			templateUrl: "partials/weixin/addLotteryRule.html",
			controller: "AddLotteryRuleCtrl"
		}).when("/lotteryInfo", {
			templateUrl: "partials/weixin/lotteryInfoStatistic.html",
			controller: "LotteryStatisticCtrl"
		}).when("/password", {
		}).otherwise({
			redirectTo: "/pubAccount"
		});
	}]).run(["$rootScope", "$location", function ($rootScope, $location) {
		$rootScope.$on("$routeChangeSuccess", function () {
	});
}]);

angular.module("console").config(['$httpProvider', "$routeProvider", function ($httpProvider, $routeProvider) {
	$httpProvider.interceptors.push(function ($q) {
		return {
			request: function (config) {
				//console.log(config);
				return config;
			},
			response: function (response) {
				//console.log(response);
				return response;
				//return $q.reject(response);
			}
		};
	});
}]);
