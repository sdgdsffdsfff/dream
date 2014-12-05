<!DOCTYPE html>
<html>
<head>
    <#include "hiworld/admin/easy/common/head.ftl">
    <script type="text/javascript" src="${resRoot}/hiworld/admin/easyui/third/uploads/ajaxupload.3.5.js"></script>
    <script type="text/javascript" src="${resRoot}/hiworld/admin/easyui/cust/actImg.js"></script>
	<script type="text/javascript" >
	var base = '${base}';
	var listUrl = base + "/admin/getActs";
	var listPageUrl = base + "/admin/actList";
	var objectUrl = base + "/admin/getAct";
	var detailUrl = base + "/admin/actDetail";
	var saveUrl = base + "/admin/saveAct";
	var imgUploadUrl = base + "/admin/imgUpload";
	var postData = new Object();
	postData.pageNumber = 1;
	postData.pageSize = 10;
	var actId = '${actId}';
	</script>
</head>
<body>
    <div id="p" class="easyui-panel" title="维护活动图片" 
        style="width:100%;height:100%;padding:10px;background:#fafafa;"
        data-options="" >
        <a id="backBtn" href="javascript:void(0);" class="easyui-linkbutton backBtn" data-options="iconCls:'icon-back'">返回活动详情</a>
        <form id="ff" method="post">
	    	<table cellpadding="5">
	    		<tr style="display:none" >
	    			<td>活动id</td>
	    			<td><input class="easyui-textbox" type="text" name="actId" data-options="" value="${actId}" ></input></td>
	    		</tr>
	    		<tr >
	    			<td><a id="uploadBackImg" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add'">上传活动背景图片</a></td>
	    			<td></td>
	    		</tr>
	    		<tr>
	    			<td>活动背景图片:</td>
	    			<td>
	    				<div>
	    				<img id="backImgId" style="height:200px" src="" ></img>
	    				<span style="display:none" >
	    				<input id="actBacImgInput" style="display:none" type="text" name="actBacImg" class="easyui-textbox" ></input>
	    				</span>
	    				</div>
	    			</td>
	    		</tr>
	    		<tr >
	    			<td><a id="uploadLogoImg" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add'">上传活动LOGO图片</a></td>
	    			<td></td>
	    		</tr>
	    		<tr>
	    			<td>活动LOGO图片:</td>
	    			<td>
	    				<div>
	    				<img id="logoImgId" style="height:100px" src="" ></img>
	    				<span style="display:none" >
	    				<input id="mpQrImgInput" type="text" name="mpQrImg" class="easyui-textbox" ></input>
	    				</span>
	    				</div>
	    			</td>
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