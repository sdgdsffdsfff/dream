angular.module("console").controller("ChargeLotteryCtrl", ["$scope", "DialogService", function ($scope, DialogService) {
	
	$scope.ok = function(){
		var params = {};
		DialogService.accept("lottery.chargeLotteryDialog", params);
	};
	    
	$scope.cancel = function () {
		DialogService.dismiss("lottery.chargeLotteryDialog");
	};

	$scope.close = function () {
	    DialogService.dismiss("lottery.chargeLotteryDialog");
	};
	
}]);