<!DOCTYPE html>
<html>
<head>
    <#include "hiworld/admin/easy/common/head.ftl">
    <script type="text/javascript" src="${resRoot}/hiworld/admin/easyui/third/uploads/ajaxupload.3.5.js"></script>
	<script type="text/javascript" >
	var base = '${base}';
	var mgsStatUrl = base + "/admin/getActs";
	var postData = new Object();
	var actId = '${actId}';
	</script>
</head>
<body>
    <div id="p" class="easyui-panel" title="公众信息统计" 
        style="width:100%;height:100%;padding:10px;background:#fafafa;"
        data-options="" >
        <a id="backBtn" href="javascript:void(0);" class="easyui-linkbutton backBtn" data-options="iconCls:'icon-back'">返回活动详情</a>
        <div id="main" style="height:400px" ></div>
    </div>
    
    <script type="text/javascript" src="${resRoot}/lib/echarts-all.js"></script>
    <script type="text/javascript" src="${resRoot}/hiworld/admin/easyui/cust/msgSta.js"></script>
</body>
</html>