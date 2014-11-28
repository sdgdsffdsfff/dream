$(function(){

	init();
	
	/*
	 * 初始化init
	 */
	function init(){
		$(".img-thumbnail.mashimg").bind("click", function(){
			//首先,将评分传到后台，然后再重新替换一组进行评分
			mash.winId = $(this).attr("mashId");
			console.log(mash);
			score(mash);
		});
	}
	
	/*
	 * 将评分传到后台
	 */
	function score(mash){
		$.ajax({
			type: "post",
			url: base + "/mash/saveScore.htm",
			data: mash,
			cache: false,
			beforeSend: function(){
				//添加浮层
				
			},
			success: function(data){
				//重新加载一组数据
				nextMash();
			},
			error:function(){
				//取消浮层
			}
		});
	}
	
	/*
	 * 重新换一组数据进行评价
	 */
	function nextMash(){
		$.ajax({
			type: "get",
			url: base + "/mash/mashList.htm",
			cache: false,
			success: function(data){
				//重新将数据替换到页面中
				$("#mashBox").html(data);
				init();
				//取消浮层
				
			},
			error:function(){
				//取消浮层
				
			}
		});
	}
	
});