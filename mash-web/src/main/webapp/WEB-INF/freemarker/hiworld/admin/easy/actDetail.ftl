<!DOCTYPE html>
<html>
<head>
    <#include "hiworld/admin/easy/common/head.ftl">
    <script type="text/javascript" src="${resRoot}/hiworld/admin/easyui/cust/actDetail.js"></script>
	<script type="text/javascript" >
	var base = '${base}';
	var listUrl = base + "/admin/getActs";
	var listPageUrl = base + "/admin/actList";
	var detailUrl = base + "/admin/actDetail";
	var delUrl = base + "/admin/delAct";
	var objectUrl = base + "/admin/getAct";
	var saveUrl = base + "/admin/saveAct";
	var accountListUrl = base + "/admin/getAccounts";
	var accountUrl = base + "/admin/getAccount";
	var actImgUrl = base + "/admin/actImg";
	var postData = new Object();
	postData.pageNumber = 1;
	postData.pageSize = 10;
	var actId = '${actId}';
	</script>
</head>
<body>
    <div id="p" class="easyui-panel" title="活动详情" 
        style="width:100%;height:100%;padding:10px;background:#fafafa;"
        data-options="" >
        <a id="backBtn" href="javascript:void(0);" class="easyui-linkbutton backBtn" data-options="iconCls:'icon-back'">返回列表页</a>
        <#if actId??>
        <a id="imgBtn" href="javascript:void(0);" class="easyui-linkbutton backBtn" data-options="iconCls:'icon-add'">维护活动图片</a>
        </#if>
        <form id="ff" method="post">
	    	<table cellpadding="5">
	    		<tr style="display:none" >
	    			<td>活动id</td>
	    			<td><input class="easyui-textbox" type="text" name="actId" data-options=""></input></td>
	    		</tr>
	    		<tr>
	    			<td>mpId</td>
	    			<td>
	    				<input id="mpIdcc" class="easyui-combobox" name="mpId" data-options="required:true,missingMessage:'必选'" >
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>微信号</td>
	    			<td><input class="easyui-textbox" type="text" name="wechatCode" data-options="required:true,missingMessage:'必填'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>TOKEN</td>
	    			<td><input class="easyui-textbox" type="text" name="token" data-options="required:true,missingMessage:'必填'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>活动名称</td>
	    			<td><input class="easyui-textbox" type="text" name="actName" data-options="required:true,missingMessage:'必填'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>主题关键词</td>
	    			<td><input class="easyui-textbox" type="text" name="topKeys" data-options="required:true,missingMessage:'必填'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>活动描述</td>
	    			<td><input class="easyui-textbox" name="actLogo" data-options="multiline:true,required:true,missingMessage:'必填'" style="height:60px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>审核设置:</td>
	    			<td>
	    				<select class="easyui-combobox" name="checkFlag">
	    				<option value="1">无需审核上墙</option>
	    				<option value="0">需审核上墙</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>上线设置:</td>
	    			<td>
	    				<select class="easyui-combobox" name="actOnFlag">
	    				<option value="1">活动上线</option>
	    				<option value="0">活动待上线</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>活动开始时间</td>
	    			<td><input class="easyui-datetimebox" name="actStartTime" data-options="required:true,showSeconds:false,missingMessage:'必选'" style="width:150px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>活动结束时间</td>
	    			<td><input class="easyui-datetimebox" name="actEndTime" data-options="required:true,showSeconds:false,missingMessage:'必选'" style="width:150px"></input></td>
	    		</tr>
	    	</table>
	    </form>
        <a id="saveBtn" href="javascript:void(0);" class="easyui-linkbutton backBtn" data-options="iconCls:'icon-ok'" style="margin-top:2px;margin-left:40px;padding-right:10px" >保存</a>
        <a id="cancelBtn" href="javascript:void(0);" class="easyui-linkbutton backBtn" data-options="iconCls:'icon-cancel'" style="margin: 2px 20px;padding-right:10px" >取消</a>
    </div>

	<#-- 弹出框 -->
	<div id="dd" class="easyui-dialog" title="" 
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed: true">
    </div>

</body>
</html>