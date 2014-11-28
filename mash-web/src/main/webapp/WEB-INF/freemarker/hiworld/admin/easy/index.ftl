<!DOCTYPE html>
<html>
<head>
    <#include "hiworld/admin/easy/common/head.ftl">
	<script type="text/javascript" >
	var base = '${base}';
	var accountUrl = base + '/admin/accountList';
	var actUrl = base + '/admin/actList';
	var awardUrl = base + '/admin/awardList';
	var msgUrl = base + '/admin/msgList';
	var winningUrl = base + '/admin/winningList';
	</script>
</head>
<body class="easyui-layout layout panel-noscroll">
    <div data-options="region:'north'" style="height:100px;"></div>
    <div data-options="region:'west',title:'导航',split:true" style="width:180px;">
    <#include "hiworld/admin/easy/common/menu.ftl">
    </div>
    <div data-options="region:'center',split:true" style="padding:0px;">
    <div id="tapsId" class="easyui-tabs tabs-container" style="width:100%;width:100%;">
    <div title="Welcome" data-options="closable:true" style="padding:10px">
		
	</div>
    </div>
    
    </div>
</body>
</html>