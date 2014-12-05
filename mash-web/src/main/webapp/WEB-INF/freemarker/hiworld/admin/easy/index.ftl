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
    <div data-options="region:'north'" style="height:100px;background: url('${resRoot}/hiworld/admin/easyui/img/banner.png');">
        <div style="width: 150;float: right;margin-top: 60px;margin-right: 20px;" >
            <span data-options="iconCls:'icon-search'" >您好！${userName}</span><a href="${base}/j_spring_security_logout" class="easyui-linkbutton" data-options="">退出</a>
        </div>
    </div>
    <div data-options="region:'west',title:'导航',split:true" style="width:180px;">
    <#include "hiworld/admin/easy/common/menu.ftl">
    </div>
    <div data-options="region:'center',split:true" style="padding:0px;">
    <div id="tapsId" class="easyui-tabs tabs-container" style="height:100%;width:100%;">
    <div title="Welcome" data-options="" style="padding:10px;" >
          <div class="easyui-panel" style="width:100%;height:700px;padding:10px;background: url('${resRoot}/hiworld/admin/easyui/img/back.png');"></div>
	</div>
    </div>
    
    </div>
</body>
</html>