<!DOCTYPE html>
<html>
<head>
    <#include "hiworld/admin/easy/common/head.ftl">
    <script type="text/javascript" src="${resRoot}/hiworld/admin/easyui/cust/msgList.js"></script>
	<script type="text/javascript" >
	var base = '${base}';
	var listUrl = base + "/admin/getMsgs";
	var delUrl = base + "/admin/delMsg";
	var objectUrl = base + "/admin/getMsg";
	var saveUrl = base + "/admin/saveMsg";
	var postData = new Object();
	postData.pageNumber = 1;
	postData.pageSize = 10;
	</script>
</head>
<body>
    <div id="p" class="easyui-panel" title="维护信息上墙" 
        style="width:100%;height:80px;padding:10px;background:#fafafa;"
        data-options="" >
        
    </div>

	<table id="dg" title="公众信息列表" style="width:100%;height:370px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10,
				toolbar:toolbar">
		<thead>
			<tr>
				<th field="msgId" width="100">msgId</th>
				<th field="openId" width="100">openId</th>
				<th field="actId" width="100">活动Id</th>
				<th field="msgContext" width="300">消息内容</th>
				<th field="checkFlag" width="60" align="center">审核标志</th>
				<th field="showFlag" width="60" align="center">上墙标识</th>
				<th field="createDttm" width="130">发布时间</th>
			</tr>
		</thead>
	</table>
	
	<#-- 弹出框 -->
	<div id="dd" class="easyui-dialog" title="" 
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed: true">
        
        <form id="ff" method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>msgId</td>
	    			<td><input class="easyui-textbox" type="text" name="msgId" data-options=""></input></td>
	    		</tr>
	    		<tr>
	    			<td>openId</td>
	    			<td><input class="easyui-textbox" type="text" name="openId" data-options=""></input></td>
	    		</tr>
	    		<tr>
	    			<td>活动id</td>
	    			<td><input class="easyui-textbox" type="text" name="actId" data-options=""></input></td>
	    		</tr>
	    		<tr>
	    			<td>消息内容</td>
	    			<td><input class="easyui-textbox" type="text" name="msgContext" data-options="multiline:true" style="height:120px" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>审核标识</td>
	    			<td>
	    				<select class="easyui-combobox" name="checkFlag">
	    				<option value="1">通过审核</option>
	    				<option value="0">未通过审核</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>是否上墙</td>
	    			<td>
	    				<select class="easyui-combobox" name="checkFlag">
	    				<option value="1">已上墙</option>
	    				<option value="0">待上墙</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>发布时间</td>
	    			<td><input class="easyui-textbox" type="text" name="createDttm" data-options="showSeconds:false" style="width:150px"></input></td>
	    		</tr>
	    	</table>
	    </form>
        
    </div>

</body>
</html>