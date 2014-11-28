angular.module('console').filter('shortName', function() {
    return function(input) {
        return (input&&input.length>10 )? (input.slice(0,10)+'...') : input;
    };
});

angular.module('console').filter('noNameFilter', function() {
    return function(input) {
        return input ? input: '无';
    };
});

angular.module('console').filter('trueORfalse', function() {
    return function(flag) {
    	switch(flag) {
	        case 'true':
	            return "成功";
	        case "false":
	            return "失败";
	        default:
	            return "未知";
	    }
    };
 });

angular.module('console').filter('phoneFilter', function() {
    return function(phone) {
    	if(phone != null && phone.length > 0){
    		return phone.substring(0,3) + "****" + phone.substring(7,4);
    	}else{
    		return phone;
    	}
    };
 });

angular.module('console').filter('amount',["$filter",function($filter) {
    return function(number,format) {
        if(number==0){
            return 0;
        }
        else{
            return $filter('number')(number,format);
        }
    };
}]);

angular.module('console').filter('partial', function(){
	return function(number){
		if(isNaN(number)){
			return '0%';
		}else{
			var num = new Number(number * 100);
			var result = num.toFixed(2);
			return result + '%';
		}
	};
});
