var toolbar = [{
	text:'发布',
	iconCls:'icon-add',
	handler:function(){
		
	}
},{
	text:'删除',
	iconCls:'icon-remove',
	handler:function(){
		var rowData = $('#dg').datagrid("getSelected");
		if(rowData){
			delData(rowData.msgId);
			reloadData(postData);
		}
	}
}
,{
	text:'详情',
	iconCls:'icon-save',
	handler:function(){
		var rowData = $('#dg').datagrid("getSelected");
		if(rowData){
			//清理弹窗表单
			$('#ff').form('clear');
			//将详情和弹窗进行组合
			$('#ff').form('load', objectUrl+'?msgId='+rowData.msgId);
			myDialog("公众信息详情","修改");
		}
	}
}
,{
	text:'审核',
	iconCls:'icon-ok',
	handler:function(){
		var rowData = $('#dg').datagrid("getSelected");
		if(rowData){
			var locPostData = new Object();
			locPostData.msgId = rowData.msgId;
			locPostData.checkFlag = rowData.checkFlag;
			
		    $('#dd').dialog({
		        title: '审核公众消息',
		        iconCls:'icon-ok',
		        width: 250,
		        height: 120,
		        closed: false,
		        cache: false,
		        modal: true,
		        content:'<div style="margin-top: 10px;margin-left: 10px;">该消息是否通过审核?</div>',
		        buttons:[{
					text:'通过',
					handler:function(){
						locPostData.checkFlag = 1;
						console.log(locPostData);
						updateData(locPostData);
						reloadData(postData);
						$('#dd').dialog({closed: true});
					}
				},{
					text:'不通过',
					handler:function(){
						locPostData.checkFlag = 0;
						console.log(locPostData);
						updateData(locPostData);
						reloadData(postData);
						$('#dd').dialog({closed: true});
					}
				}]
		    });
		    
		}
	}
}
,{
	text:'上墙',
	iconCls:'icon-edit',
	handler:function(){
		var rowData = $('#dg').datagrid("getSelected");
		if(rowData){
			var locPostData = new Object();
			locPostData.msgId = rowData.msgId;
			locPostData.showFlag = rowData.showFlag;
			
		    $('#dd').dialog({
		        title: '审核公众消息',
		        iconCls:'icon-ok',
		        width: 250,
		        height: 120,
		        closed: false,
		        cache: false,
		        modal: true,
		        content:'<div style="margin-top: 10px;margin-left: 10px;">将该消息上墙展示?</div>',
		        buttons:[{
					text:'上墙',
					handler:function(){
						locPostData.showFlag = 0;
						console.log(locPostData);
						updateData(locPostData);
						reloadData(postData);
						$('#dd').dialog({closed: true});
					}
				},{
					text:'暂不上墙',
					handler:function(){
						locPostData.showFlag = 1;
						console.log(locPostData);
						updateData(locPostData);
						reloadData(postData);
						$('#dd').dialog({closed: true});
					}
				}]
		    });
			
		}
	}
}];

$(function(){
	
	/*
	 * 点击查询按钮
	 */
	$("#queryBtn").click(function(){
		var actId = $("#actIdInputId").textbox('getValue');
		var checkFlag = $("#checkFlagOptionId").textbox('getValue');
		var showFlag = $("#showFlagOptionId").textbox('getValue');
		postData.actId = actId;
		postData.checkFlag = checkFlag;
		postData.showFlag = showFlag;
		reloadData(postData);
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
            var locPostData = new Object();
            locPostData.pageNumber = pageNumber;
            locPostData.pageSize = pageSize;
            postData.pageNumber = pageNumber;
            postData.pageSize = pageSize;
            getData(locPostData);
        }
    });
    getData(postData);
    
});

var reloadData = function(postData){
//	postData.pageNumber = 1;
//	postData.pageSize = 10;
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

function delData(msgId){
	var postData = new Object();
	postData.msgId = msgId;
    $.ajax({
        type: "post",
        url: delUrl,
        data:postData,
        cache : "false",
        dataType:"json",
        success:function(data){
        	console.log(data);
        }
    });
}

function updateData(postData){
    $.ajax({
        type: "post",
        url: saveUrl,
        data:postData,
        cache : "false",
        dataType:"json",
        success:function(data){
        	console.log(data);
        }
    });
}

/*
 * 定制弹出窗
 */
function myDialog(title,actionText){
    /**
     * 弹出框
     */
    $('#dd').dialog({
        title: title,
        width: 300,
        height: 380,
        closed: false,
        cache: false,
        modal: true
    });
}

