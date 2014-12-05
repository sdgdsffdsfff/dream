$(function(){
	
	var myChart = echarts.init(document.getElementById('main'));
    var option = {
    		tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['用户发送信息量']
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: false},
                    dataView : {show: false, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    splitArea : {show : true}
                }
            ],
            series : [
                {
                    name:'用户发送信息量',
                    type:'line',
                    data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
                }
            ]
    }
    myChart.setOption(option);
	
	if(actId){
	    $.ajax({
	        type: "post",
	        url: mgsStatUrl+"?actId="+actId,
	        data:postData,
	        cache : "false",
	        dataType:"json",
	        success:function(data){
	        	
	        }
	    });
	}
	
	/*
	 * 返回按钮
	 */
	$("#backBtn").click(function(){
		
	});
	
});
