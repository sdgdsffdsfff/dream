var tempMpId = '';
$(function(){
	
	/*
	 * 页面初始化-当存在活动id的时候则为该活动的详情页面
	 */
	if(actId){
	    $.ajax({
	        type: "post",
	        url: objectUrl+"?actId="+actId,
	        data:postData,
	        cache : "false",
	        dataType:"json",
	        success:function(data){
	        	tempMpId = ''+data.mpId;
	        	$('#ff').form('load',data);
	        }
	    });
	}
	
	/*
	 * 保存按钮
	 */
	$("#saveBtn").click(function(){
		$('#ff').form('submit', {
		    url:saveUrl,
		    onSubmit: function(param){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');
				}
				return isValid;
		    },
		    success: function(){
				$.messager.progress('close');
				window.location.href = listPageUrl;
			}
		});
	});
	
	/*
	 * 取消按钮
	 */
	$("#cancelBtn").click(function(){
		window.location.href = listPageUrl;
	});
	
	/*
	 * 返回按钮
	 */
	$("#backBtn").click(function(){
		window.location.href = listPageUrl;
	});
	
	/*
	 * 跳转到活动图片维护页面
	 */
	$("#imgBtn").click(function(){
		window.location.href = actImgUrl+"?actId="+actId;
	});
	
	/*
	 * 获取公众账号列表信息
	 */
    $.ajax({
        type: "post",
        url: accountListUrl+"?pageSize=9999",
        data:postData,
        cache : "false",
        dataType:"json",
        success:function(data){
        	var values=new Array();
        	for(var i=0;i<data.datas.length;i++){
        		var object = new Object();
        		object.mpId = data.datas[i].mpId;
        		object.value = "微信号:" + data.datas[i].wechatCode;
        		if(object.mpId == tempMpId){
        			object.selected = true;
        		}
        		values[i] = object;
        	}
        	/*
        	 * 公共账号mpId下拉框
        	 */
        	$('#mpIdcc').combobox({
        		valueField: 'mpId',
        		textField: 'value',
        		data: values,
        		onSelect: function(rec){
        		    $.ajax({
        		        type: "post",
        		        url: accountUrl+"?mpId="+rec.mpId,
        		        data:postData,
        		        cache : "false",
        		        dataType:"json",
        		        success:function(data){
        		        	var accountObject = new Object();
        		        	accountObject.token=data.token;
        		        	accountObject.wechatCode=data.wechatCode;
        					$('#ff').form('load',accountObject);
        		        }
        		    });
                }
        	});
        }
    });
	
});

function delData(mpId){
	var postData = new Object();
	postData.mpId = mpId;
    $.ajax({
        type: "post",
        url: delAccountUrl,
        data:postData,
        cache : "false",
        dataType:"json",
        success:function(data){
        	console.log(data);
        }
    });
}
