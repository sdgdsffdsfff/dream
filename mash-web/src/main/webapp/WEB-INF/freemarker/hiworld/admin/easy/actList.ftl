<!DOCTYPE html>
<html>
<head>
    <#include "hiworld/admin/easy/common/head.ftl">
    <script type="text/javascript" src="${resRoot}/hiworld/admin/easyui/cust/actList.js"></script>
	<script type="text/javascript" >
	var base = '${base}';
	var listUrl = base + "/admin/getActs";
	var detailUrl = base + "/admin/actDetail";
	var delUrl = base + "/admin/delAct";
	var objectUrl = base + "/admin/getAct";
	var saveUrl = base + "/admin/saveAct";
	var serviceUrl = base + "/showTheWorld/";
	var postData = new Object();
	postData.pageNumber = 1;
	postData.pageSize = 10;
	</script>
</head>
<body>
	<table id="dg" title="活动信息列表" style="width:100%;height:370px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10,
				toolbar:toolbar">
		<thead>
			<tr>
			    <th field="actId" width="50">活动id</th>
				<th field="mpId" width="50">mpId</th>
				<th field="wechatCode" width="80">微信号</th>
				<th field="token" width="80">Token</th>
				<th field="actName" width="100" >活动名称</th>
				<th field="actLogo" width="80" >活动描述</th>
				<th field="actBacImg" width="60" >活动背景</th>
				<th field="mpQrImg" width="60" >二维码</th>
				<th field="topKeys" width="80" >关键词</th>
				<th field="checkFlag" width="60" >审核设置</th>
				<th field="actOnFlag" width="60" >上线标识</th>
				<th field="actStartTime" width="100">活动开始时间</th>
				<th field="actEndTime" width="100">活动结束时间</th>
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

    <#-- 提示弹出框 -->
    <div id="ddtips" class="easyui-dialog" title="" 
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed: true">
    </div>

</body>
</html>