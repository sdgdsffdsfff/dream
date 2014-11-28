var toolbar = [{
	text:'新增',
	iconCls:'icon-add',
	handler:function(){
		window.location.href = detailUrl;
	}
},{
	text:'删除',
	iconCls:'icon-remove',
	handler:function(){
		var rowData = $('#dg').datagrid("getSelected");
		if(rowData){
			console.log(rowData);
			delData(rowData.actId);
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
			window.location.href = detailUrl+"?actId="+rowData.actId;
		}
	}
}];

$(function(){
	
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

function delData(actId){
	var postData = new Object();
	postData.actId = actId;
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
        height: 320,
        closed: false,
        cache: false,
        modal: true,
        buttons:[{
			text:actionText,
			handler:function(){
				$('#ff').form('submit', {
				    url:saveAccountUrl,
				    onSubmit: function(param){
						var isValid = $(this).form('validate');
						if (!isValid){
							$.messager.progress('close');
						}
						return isValid;
				    },
				    success: function(){
						$.messager.progress('close');
						//关闭弹窗
						$('#dd').dialog({closed: true});
						//重新加载数据
						reloadData(postData);
					}
				});
			}
		},{
			text:'取消',
			handler:function(){
				$('#dd').dialog({closed: true});
				//清理弹窗表单
				$('#ff').form('clear');
			}
		}]
    });
}

