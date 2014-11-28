<!DOCTYPE html>
<html>
<head>
    <#include "hiworld/admin/easy/common/head.ftl">
    <script type="text/javascript" src="${resRoot}/hiworld/admin/easyui/cust/winningList.js"></script>
	<script type="text/javascript" >
	var base = '${base}';
	var listUrl = base + "/admin/getWinnings";
	var delUrl = base + "/admin/delWinning";
	var objectUrl = base + "/admin/getWinning";
	var objectAwardUrl = base + "/admin/getAward";
	var saveUrl = base + "/admin/saveWinning";
	var bingoUrl = base + "/admin/bingo";
	var postData = new Object();
	postData.pageNumber = 1;
	postData.pageSize = 10;
	</script>
</head>
<body>
    <div id="p" class="easyui-panel" title="中奖统计" 
        style="width:100%;height:80px;padding:10px;background:#fafafa;"
        data-options="" >
                        活动id：<input id="actIdInputId" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:100px">
        <a id="queryBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
        <a id="bingoBtn" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-tip'">摇奖</a>
    </div>

	<table id="dg" title="中奖用户列表" style="width:100%;height:370px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10,
				toolbar:toolbar">
		<thead>
			<tr>
				<th field="winId" width="80">中奖Id</th>
				<th field="openId" width="150">openId</th>
				<th field="awardId" width="80" align="center">奖品Id</th>
				<th field="actId" width="80" align="center">活动Id</th>
				<th field="bingoFlag" width="80" align="center">领奖标志</th>
				<th field="bingoName" width="100" align="center">领奖人姓名</th>
				<th field="bingoTel" width="130" align="center">领奖人电话</th>
			</tr>
		</thead>
	</table>
	
	<#-- 弹出框 -->
	<div id="dd" class="easyui-dialog" title="" 
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed: true">
        <form id="ff" method="post">
	    	<table cellpadding="5">
	    	    <tr style="" >
	    			<td>中奖Id</td>
	    			<td><input class="easyui-textbox" type="text" name="winId" data-options="readonly:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>openId</td>
	    			<td><input class="easyui-textbox" type="text" name="openId" data-options="readonly:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>奖品Id</td>
	    			<td><input class="easyui-textbox" type="text" name="awardId" data-options="readonly:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>奖品名称</td>
	    			<td><input class="easyui-textbox" type="text" name="awardName" data-options="readonly:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>奖品描述</td>
	    			<td><input class="easyui-textbox" type="text" name="awardCont" data-options="multiline:true,readonly:true" style="height:60px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>活动Id</td>
	    			<td><input class="easyui-textbox" type="text" name="actId" data-options="readonly:true"></input></td>
	    		</tr>
	    		<tr style="" >
	    			<td>领奖标志</td>
	    			<td><input class="easyui-textbox" type="text" name="bingoFlagText" data-options="readonly:true"></input></td>
	    		</tr>
	    		<tr id="bingoFlagId" style="display:none" >
	    			<td>领奖标志</td>
	    			<td>
	    				<select class="easyui-combobox" name="bingoFlag">
	    				<option value="0">未领奖</option>
	    				<option value="1">已领奖</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>领奖人姓名</td>
	    			<td><input id="bingoNameId" class="easyui-textbox" type="text" name="bingoName" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>领奖人电话</td>
	    			<td><input id="bingoTelId" class="easyui-textbox" type="text" name="bingoTel" ></input></td>
	    		</tr>
	    	</table>
	    </form>
    </div>
    
    <#-- 领奖弹出框 -->
    <div id="ddGetWin" class="easyui-dialog" title="" 
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed: true">
        <form id="ffGetWin" method="post">
            <table cellpadding="5">
	    	    <tr style="" >
	    			<td>兑奖码</td>
	    			<td><input id="inputBingoCode" class="easyui-textbox" type="text" name="winId" data-options="required:true,missingMessage:'必填'" ></input></td>
	    		</tr>
	    	</table>
        </form>
    </div>
    
    <#-- 弹出框 -->
    <div id="ddtips" class="easyui-dialog" title="" 
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed: true">
    </div>

</body>
</html>