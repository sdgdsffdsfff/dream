angular.module("console").controller("LotteryStatisticCtrl", ["$scope", "DialogService", function ($scope, DialogService) {
	
	$scope.charge = function(){
		DialogService.modal({
			key: "lottery.chargeLotteryDialog",
			url: "partials/weixin/chargeLotteryDialog.html",
			//点击确定按钮的响应事件
			accept: function (params) {
			}
		});
	};
	
}]);