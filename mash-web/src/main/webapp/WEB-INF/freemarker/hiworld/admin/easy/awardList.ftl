<!DOCTYPE html>
<html>
<head>
    <#include "hiworld/admin/easy/common/head.ftl">
    <script type="text/javascript" src="${resRoot}/hiworld/admin/easyui/cust/awardList.js"></script>
	<script type="text/javascript" >
	var base = '${base}';
	var listUrl = base + "/admin/getAwards";
	var delUrl = base + "/admin/delAward";
	var objectUrl = base + "/admin/getAward";
	var saveUrl = base + "/admin/saveAward";
	var postData = new Object();
	postData.pageNumber = 1;
	postData.pageSize = 10;
	</script>
</head>
<body>

	<table id="dg" title="中奖规则（奖品）列表" style="width:100%;height:370px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10,
				toolbar:toolbar">
		<thead>
			<tr>
				<th field="awardId" width="90">awardId</th>
				<th field="actId" width="90">活动Id</th>
				<th field="awardName" width="120">奖品名称</th>
				<th field="awardLevel" width="80" align="center">奖品等级</th>
				<th field="awardNum" width="90" align="center">奖品数量</th>
				<th field="awardCont" width="330" >奖品描述</th>
			</tr>
		</thead>
	</table>
	
	<#-- 弹出框 -->
	<div id="dd" class="easyui-dialog" title="" 
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed: true">
        
        <form id="ff" method="post">
	    	<table cellpadding="5">
	    	    <tr style="display:none" >
	    			<td>awardId</td>
	    			<td><input class="easyui-textbox" type="text" name="awardId" data-options=""></input></td>
	    		</tr>
	    		<tr>
	    			<td>活动Id</td>
	    			<td><input class="easyui-textbox" type="text" name="actId" data-options="required:true,missingMessage:'必填'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>奖品名称</td>
	    			<td><input class="easyui-textbox" type="text" name="awardName" data-options="required:true,missingMessage:'必填'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>奖品等级</td>
	    			<td><input class="easyui-textbox" type="text" name="awardLevel" data-options="required:true,missingMessage:'必填'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>奖品数量</td>
	    			<td><input class="easyui-textbox" type="text" name="awardNum" data-options="required:true,missingMessage:'必填'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>奖品描述</td>
	    			<td><input class="easyui-textbox" type="text" name="awardCont" data-options="multiline:true,required:true,missingMessage:'必填'" style="height:60px"></input></td>
	    		</tr>
	    	</table>
	    </form>
        
    </div>

</body>
</html>