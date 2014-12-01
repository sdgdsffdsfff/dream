var toolbar = [
{
	text:'领奖',
	iconCls:'icon-ok',
	handler:function(){
	    $('#ddGetWin').dialog({
	        title: '输入领奖码',
	        width: 280,
	        height: 110,
	        closed: false,
	        cache: false,
	        modal: true,
	        buttons:[{
				text:'确定',
				handler:function(){
					var bingoCode = $("#inputBingoCode").textbox('getValue');
					var locData = new Object();
					if(bingoCode){
						locData.bingoCode=bingoCode;
					}else{
						locData.bingoCode='-1';
					}
				    $.ajax({
				        type: "post",
				        url: objectUrl,
				        data:locData,
				        cache : "false",
				        dataType:"json",
				        success:function(data){
	        				//清理弹窗表单
	        				$('#ff').form('clear');
				        	if(data && 0==data.bingoFlag){
		        				//向表单里添加数据
		        				formDataExt(data);
		        				$("#bingoFlagId").attr("style","");
				        		//暂未领奖-展示领奖等信息-准备领奖
				        		var buttons=[{
				        			text:'确定领奖',
				        			handler:function(){
				        				$('#ff').form('submit', {
				        				    url:saveUrl,
				        				    success: function(){
				        						$.messager.progress('close');
				        						//还原
				        						$("#bingoFlagId").attr("style","display:none");
				        						//关闭弹窗
				        						$('#dd').dialog({closed: true});
				        						//重新加载数据
				        						reloadData(postData);
				        					}
				        				});
				        				//关闭弹窗
				        				$('#dd').dialog({closed: true});
				        				//清理弹窗表单
				        				$('#ff').form('clear');
				        			}
				        		},{
				        			text:'取消',
				        			handler:function(){
				        				//关闭弹窗
				        				$('#dd').dialog({closed: true});
				        				//清理弹窗表单
				        				$('#ff').form('clear');
				        			}
				        		}];
				        		myDialog("领奖",buttons,620);
				        	}else if(data && 1==data.bingoFlag){
				        		//已经领奖-提示不能再领奖-展示出领奖人及领奖人电话
				    		    $('#ddtips').dialog({
				    		        title: '已领奖',
				    		        iconCls:'icon-ok',
				    		        width: 250,
				    		        height: 140,
				    		        closed: false,
				    		        cache: false,
				    		        modal: true,
				    		        content:'<div style="margin-top: 10px;margin-left: 10px;">该领奖码已领奖<br>'+
				    		        '领奖人姓名:<span style="color:red">'+data.bingoName+'</span><br>'+
				    		        '领奖人联系方式:<span style="color:red">'+data.bingoTel+'</span>'
				    		        +'</div>',
				    		        buttons:[{
				    					text:'确定',
				    					handler:function(){
				    						$('#ddtips').dialog({closed: true});
				    					}
				    				}]
				    		    });
				        	}else if(data && 2==data.bingoFlag){
				        		//领奖码已经过期，请下次及时领奖
				    		    $('#ddtips').dialog({
				    		        title: '领奖码已过期',
				    		        iconCls:'icon-ok',
				    		        width: 250,
				    		        height: 120,
				    		        closed: false,
				    		        cache: false,
				    		        modal: true,
				    		        content:'<div style="margin-top: 10px;margin-left: 10px;">该领奖码('+bingoCode+')已过期，请下次及时领取奖品！<br></div>',
				    		        buttons:[{
				    					text:'确定',
				    					handler:function(){
				    						$('#ddtips').dialog({closed: true});
				    					}
				    				}]
				    		    });
				        	}else {
				    		    $('#ddtips').dialog({
				    		        title: '领奖码无效',
				    		        iconCls:'icon-ok',
				    		        width: 250,
				    		        height: 120,
				    		        closed: false,
				    		        cache: false,
				    		        modal: true,
				    		        content:'<div style="margin-top: 10px;margin-left: 10px;">该领奖码('+bingoCode+')无效<br></div>',
				    		        buttons:[{
				    					text:'确定',
				    					handler:function(){
				    						$('#ddtips').dialog({closed: true});
				    					}
				    				}]
				    		    });
				        	}
				        }
				    });
				}
			},{
				text:'取消',
				handler:function(){
					$('#ddGetWin').dialog({closed: true});
					//清理弹窗表单
					$('#ffGetWin').form('clear');
				}
			}]
	    });
	}
},{
	text:'领奖详情',
	iconCls:'icon-save',
	handler:function(){
		var rowData = $('#dg').datagrid("getSelected");
		if(rowData){
			//清理弹窗表单
			$('#ff').form('clear');
			//填充表格
		    $.ajax({
		        type: "post",
		        url: objectUrl+"?winId="+rowData.winId,
		        cache : "false",
		        dataType:"json",
		        success:function(data){
		        	formDataExt(data,null);
		        }
		    });
		}
	}
},{
	text:'删除',
	iconCls:'icon-cancel',
	handler:function(){
		var rowData = $('#dg').datagrid("getSelected");
		if(rowData){
			delData(rowData.winId);
			reloadData(postData);
		}
	}
}
,{
	text:'置为过期',
	iconCls:'icon-clear',
	handler:function(){
		var rowData = $('#dg').datagrid("getSelected");
		if(rowData){
			var locData = new Object();
			locData.winId = rowData.winId;
			if(0==rowData.bingoFlag){
				locData.bingoFlag=2;//过期
			}
			updateData(locData);
			reloadData(postData);
		}
	}
}];

$(function(){
	
	/*
	 * 点击查询按钮
	 */
	$("#queryBtn").click(function(){
		var actId = $("#actIdInputId").textbox('getValue');
		postData.actId = actId;
		reloadData(postData);
	});
	
	/*
	 * 点击摇奖按钮-开始摇奖
	 */
	$("#bingoBtn").click(function(){
		var actId = $("#actIdInputId").textbox('getValue');
		if(actId){
		    $.ajax({
		        type: "post",
		        url: bingoUrl+"?actId="+actId,
		        cache : "false",
		        dataType:"json",
		        success:function(data){
		        	reloadData(postData);
		        }
		    });
		}
	});
	
	$('#dg').datagrid({
        pageNumber: 1,
        pagination: true, 
        rownumbers: true,
        pageSize: 10,
        pageList: [10, 15] 
   });
	var p = $('#dg').datagrid('getPager');
	p.pagination({
        beforePageText: '第',//页数文本框前显示的汉字  
        afterPageText: '页    共 {pages} 页', 
        displayMsg: '',
    });
    p.pagination({
        onSelectPage: function (pageNumber, pageSize) {
            var postData = new Object();
            postData.pageNumber = pageNumber;
            postData.pageSize = pageSize;
            getData(postData);
        }
    });
    getData(postData);
    
});

var reloadData = function(postData){
	postData.pageNumber = 1;
	postData.pageSize = 10;
	getData(postData);
};

/*
 * 获得公共账号列表信息
 */
function getData(postData){
	var postData = postData;
    $.ajax({
        type: "post",
        url: listUrl,
        data:postData,
        cache : "false",
        dataType:"json",
        success:function(data){
			data = {
					total: data.totalDataCount,
					rows: data.datas
			}
        	$('#dg').datagrid('loadData', data);
        }
    });
}

function delData(winId){
	var postData = new Object();
	postData.winId = winId;
    $.ajax({
        type: "post",
        url: delUrl,
        data:postData,
        cache : "false",
        dataType:"json",
        success:function(data){
        }
    });
}

function updateData(updateData){
    $.ajax({
        type: "post",
        url: saveUrl,
        data:updateData,
        cache : "false",
        dataType:"json",
        success:function(data){
        }
    });
}

/*
 * 定制弹出窗
 */
function myDialog(title,buttons,height){
    /**
     * 弹出框
     */
    $('#dd').dialog({
        title: title,
        width: 300,
        height: 440,
        closed: false,
        cache: false,
        modal: true,
        buttons: buttons
    });
}

function formDataExt(data,buttons){
	if(data){
		if(0 == data.bingoFlag){
			//未领奖
			data.bingoFlagText = "未领奖";
			myDialog("详情",buttons);
		}else if(1 == data.bingoFlag){
			//领奖
			data.bingoFlagText = "已领奖";
		}else if(2 == data.bingoFlag){
			//过期
			data.bingoFlagText = "已过期";
		}
	}
    $.ajax({
        type: "post",
        url: objectAwardUrl+"?awardId="+data.awardId,
        cache : "false",
        dataType:"json",
        success:function(awardData){
        	data.awardName=awardData.awardName;
        	data.awardCont=data.awardCont;
        	$('#ff').form('load',data);
        	myDialog("详情",buttons);
        }
    });
}
