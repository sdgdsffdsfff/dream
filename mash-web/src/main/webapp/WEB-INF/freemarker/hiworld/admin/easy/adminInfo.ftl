<!DOCTYPE html>
<html>
<head>
    <#include "hiworld/admin/easy/common/head.ftl">
    <script type="text/javascript" src="${resRoot}/hiworld/admin/easyui/third/uploads/ajaxupload.3.5.js"></script>
	<script type="text/javascript" >
	var base = '${base}';
	var accountListUrl = base + "/admin/getAccounts";
	var delAccountUrl = base + "/admin/delAccount";
	var accountObjectUrl = base + "/admin/getAccount";
	
	var postData = new Object();
	postData.pageNumber = 1;
	postData.pageSize = 10;
	
	var uploadUrl = base + "/admin/imgUpload";
	
	$(function(){
		var btnUpload=$('#upload');
		var status=$('#status');
		new AjaxUpload(btnUpload, {
			action: ''+uploadUrl,
			name: 'uploadfile',
			onSubmit: function(file, ext){
				 if (! (ext && /^(jpg|png|jpeg|gif)$/.test(ext))){ 
                    // extension is not allowed 
					status.text('只允许提交JPG, PNG 或 GIF 文件');
					return false;
				}
				status.text('Uploading...');
			},
			onComplete: function(file, response){
				//On completion clear the status
				status.text('');
				//Add uploaded file to list
				if(response==="success"){
					$('<li></li>').appendTo('#files').html('<img src="./uploads/'+file+'" alt="" /><br />'+file).addClass('success');
				} else{
					$('<li></li>').appendTo('#files').text(file).addClass('error');
				}
			}
		});
		
	});
	
	
	</script>
</head>
<body>
    <div id="p" class="easyui-panel" title="维护公共账号" 
        style="width:100%;height:800px;padding:10px;background:#fafafa;"
        data-options="" >
        
        <a id="upload" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
        
        <span id="status" ></span>
		<ul id="files" ></ul>
        
    </div>

	<table id="dg" title="公共账号列表" style="width:100%;height:370px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10,
				toolbar:toolbar">
		<thead>
			<tr>
				<th field="mpId" width="50">mpId</th>
				<th field="token" width="100">Token</th>
				<th field="wechatCode" width="80">微信号</th>
				<th field="accessToken" width="80" align="right">AccessToken</th>
				<th field="appId" width="80" align="right">AppId</th>
				<th field="appSecret" width="100" align="right">AppSecret</th>
				<th field="failTime" width="130">AccessToken失效时间</th>
				<th field="accessFlag" width="60">认证标识</th>
			</tr>
		</thead>
	</table>
	
	<#-- 弹出框 -->
	<div id="dd" class="easyui-dialog" title="" 
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed: true">
        
        <form id="ff" method="post">
	    	<table cellpadding="5">
	    	    <tr style="display:none" >
	    			<td>mpId</td>
	    			<td><input class="easyui-textbox" type="text" name="mpId" data-options=""></input></td>
	    		</tr>
	    		<tr>
	    			<td>TOKEN</td>
	    			<td><input class="easyui-textbox" type="text" name="token" data-options="required:true,missingMessage:'必填'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>微信号</td>
	    			<td><input class="easyui-textbox" type="text" name="wechatCode" data-options="required:true,missingMessage:'必填'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>AccessToken</td>
	    			<td><input class="easyui-textbox" type="text" name="accessToken" data-options=""></input></td>
	    		</tr>
	    		<tr>
	    			<td>AppId</td>
	    			<td><input class="easyui-textbox" type="text" name="appId" data-options=""></input></td>
	    		</tr>
	    		<tr>
	    			<td>AppSecret</td>
	    			<td><input class="easyui-textbox" type="text" name="appSecret" data-options=""></input></td>
	    		</tr>
	    		<tr>
	    			<td>AToken失效时间</td>
	    			<td><input class="easyui-datetimebox" name="failTime" data-options="required:true,showSeconds:false" style="width:150px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>认证标识</td>
	    			<td>
	    				<select class="easyui-combobox" name="accessFlag">
	    				<option value="0">未认证</option>
	    				<option value="1">已认证</option>
	    				</select>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
        
    </div>

</body>
</html>