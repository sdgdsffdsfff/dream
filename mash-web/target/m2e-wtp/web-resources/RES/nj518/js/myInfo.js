$(function(){
	
	myInfoList();
	
	/*
	 * 请求信息列表
	 */
	function myInfoList(){
	    $.ajax({
	        type: "POST",
	        url: base + myInfosUrl,
	        cache : "false",
	        dataType : "json",
	        data:searchInfoList,
	        success: function(data){
	     	   $(".rightPartBox_c.myInfos").html(data.infoList);
	     	   $(".snPageWrap").html(data.nextPage);
	        },
	        complete: function(){
	        	nextPageEvent();
	        	showMyInfo();
	        }
	 	});
	}
	
	/*
	 * 翻页事件添加
	 */
	function nextPageEvent(){
		$(".nextEvent").click(function(){
			var pageNum = $(this).attr("pageNum");
			if(pageNum){
				searchInfoList.pageNumber = pageNum;
			}else{
				var currentPageNum = $(".nextEvent.current").attr("pageNum");
				var type = $(this).attr("type");
				if(type == "next"){
					searchInfoList.pageNumber = parseInt(currentPageNum) + 1;
				}else{
					searchInfoList.pageNumber = parseInt(currentPageNum) - 1;					
				}
			}
			myInfoList();
		});
	}
	
	/*
	 * 展示信息的详细信息-事件添加
	 */
	function showMyInfo(){
		$(".personInfo").click(function(){
			var infoId = $(this).attr("infoId");
			console.log(infoId);
		});
	}
	
	myDialog("ss");
	
	/*
	 * 弹出框
	 */
    function myDialog(content){
    	$.dialog({
    		title:'信息详情',
    		width:300,
            fixed:true,
            lock:true,
            btn:{
                ok: {                     //按钮的key值，下次可用个btn方法从新设置
                    val: '修改',           //按钮显示的文本
                    type: 'red',         //样式可选参数green, blue, red, yellow .默认白色。
                    //disabled: true,       //是否可操作
                    click: function(btn) {
                      return false;         //阻止默认的关闭行为
                    }
                  },
                del: {                     //按钮的key值，下次可用个btn方法从新设置
                      val: '删除',           //按钮显示的文本
                      type: 'red',         //样式可选参数green, blue, red, yellow .默认白色。
                      //disabled: true,       //是否可操作
                      click: function(btn) {
                        return false;         //阻止默认的关闭行为
                      }
                 },
    	        cancel:{
    	        	val: '取消',
    	        	type: '',
                    click: function(btn) {
                        return true;         //阻止默认的关闭行为
                     }
    	        },
            },
            content:''+content
        });
    }
	
});