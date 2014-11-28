angular.module("console").controller("PubAccountCtrl", ["$scope", "DialogService", function ($scope, DialogService) {
	
	$scope.addPubAccount = function(){
		DialogService.modal({
			key: "pubAccount.addPubAccountDialog",
			url: "partials/weixin/addPubAccountDialog.html",
			//点击确定按钮的响应事件
			accept: function (params) {
			}
		});
	};
	
}]);