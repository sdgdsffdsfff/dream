angular.module("console").controller("AddPubAccountCtrl", ["$scope", "DialogService", function ($scope, DialogService) {
	
	$scope.authorityList = [
	    {
	    	id : '0',
	    	label : '未认证'
	    },
	    {
	    	id : '1',
	    	label : '已认证'
	    }
	];
	
	$scope.ok = function(){
		var params = {};
		DialogService.accept("pubAccount.addPubAccountDialog", params);
	};
	    
	$scope.cancel = function () {
		DialogService.dismiss("pubAccount.addPubAccountDialog");
	};

	$scope.close = function () {
	    DialogService.dismiss("pubAccount.addPubAccountDialog");
	};
	
}]);