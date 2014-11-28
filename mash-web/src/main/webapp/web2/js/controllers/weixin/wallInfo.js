angular.module("console").controller("WallInfoCtrl", ["$scope", function ($scope) {
	
	$scope.wallStatus = [{
		id : '0',
		label : '未上墙'
	}, {
		id : '1',
		label : '已上墙'
	}];
	
	
}]);