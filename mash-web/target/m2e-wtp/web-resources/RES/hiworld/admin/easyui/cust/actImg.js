$(function(){
	
	uploadImg($("#uploadBackImg"),$("#backImgId"),$("#actBacImgInput"));
	uploadImg($("#uploadLogoImg"),$("#logoImgId"),$("#mpQrImgInput"));
	
	/*
	 * 页面初始化-当存在活动id的时候为该页面初始化
	 */
	if(actId){
	    $.ajax({
	        type: "post",
	        url: objectUrl+"?actId="+actId,
	        data:postData,
	        cache : "false",
	        dataType:"json",
	        success:function(data){
	        	$("#backImgId").attr("src",data.actBacImg);
	        	$("#logoImgId").attr("src",data.mpQrImg);
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
				showAlert("保存成功","活动相关图片保存成功!");
			}
		});
	});
	
	/*
	 * 取消按钮
	 */
	$("#cancelBtn").click(function(){
		window.location.href = detailUrl+"?actId="+actId;
	});
	
	/*
	 * 返回按钮
	 */
	$("#backBtn").click(function(){
		window.location.href = detailUrl+"?actId="+actId;
	});
	
});

function uploadImg(btnUpload,domId,inputId){
	new AjaxUpload(btnUpload, {
		action: ''+imgUploadUrl,
		name: 'img',
		onSubmit: function(file, ext){
			 if (! (ext && /^(jpg|png|jpeg|gif)$/.test(ext))){
                // 提示只允许提交如下图片格式 JPG, PNG 或 GIF
				 showAlert("图片格式错误","上传文件只支持 JPG, PNG , jpeg或 GIF");
				return false;
			}
			 showAlert("图片上传中...","图片正在上传");
		},
		onComplete: function(file, response){
			//关闭上传窗口
			$('#dd').dialog({
		        closed: true
		    });
			var obj = jQuery.parseJSON(response);
			//将上传图片结果返回
			if(obj.succFlag){
				//替换页面
				domId.attr("src",obj.imgUrl);
				//修改inputBox-Value
				console.log(inputId.textbox("getValue"));
				inputId.textbox("setValue",obj.imgUrl);
				showAlert("图片上传成功",'图片上传成功！')
			}else{
				showAlert("图片上传失败",''+obj.msg)
			}
		}
	});
}

function showAlert(title,content){
    $('#dd').dialog({
        title: ''+title,
        iconCls:'icon-ok',
        width: 250,
        height: 140,
        closed: false,
        cache: false,
        modal: true,
        content:''+content,
        buttons:[{
			text:'确定',
			handler:function(){
				$('#dd').dialog({closed: true});
			}
		}]
    });
}
