<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${actInfo.actName}-墙</title>
    <link rel="stylesheet" type="text/css" href="${resRoot}/hiworld/summer/css/main.css"/>
    <#if actInfo.actBacImg??>
    <style type="text/css">
        .ss-page2 {
             background: #030037 url(${actInfo.actBacImg}) no-repeat 50% 0;
        }
    </style>
    </#if>
    <script type="text/javascript" src="${resRoot}/lib/jquery.min.js"></script>
    <script type="text/javascript" src="${resRoot}/hiworld/summer/js/main.js"></script>
    <script type="text/javascript" >
       var base = "${base}";
       var msgsUrl = "/showTheWorld/${actInfo.actId}/msgsJson";
       var initShowUrl = "/showTheWorld/${actInfo.actId}/initShow";
       var actExtUrl = "/showTheWorld/${actInfo.actId}/actExt";
       var logoImg = <#if actInfo.mpQrImg??>"${actInfo.mpQrImg}"<#else>null</#if>;
       var searchMsg = new Object();
       searchMsg.pageIndex=1;
       searchMsg.pageSize=1;
    </script>
</head>
<body class="ss-page2">
    <div class="ss-wrap">
        <div class="ss-top">
            <a class="ss-logo" href="#" title="营销"></a>
            <span class="top-stat r">消息总数：<strong>*</strong></span>
            <span class="top-stat r pr50">参与人数：<strong>*</strong></span>
        </div>
        <div class="ss-main">
            <div class="weibo-list weibo-blue" id="weiboList">
                <ul>
                    <li class="clearfix">
                        <img src="${resRoot}/hiworld/summer/temp/img110X110.jpg" alt="头像"/>
                        <div class="info">
                            <strong>${actInfo.actName}</strong>
                            <p class="time">${actInfo.actStartTime?string('yyyy-MM-dd hh:mm')}</p>
                            <p class="con">${actInfo.actLogo}</p>
                        </div>
                    </li>
                    <li class="clearfix">
                        <img src="${resRoot}/hiworld/summer/temp/img110X110.jpg" alt="头像"/>
                        <div class="info">
                            <strong>${actInfo.actName}</strong>
                            <p class="time">${actInfo.actStartTime?string('yyyy-MM-dd hh:mm')}</p>
                            <p class="con">${actInfo.actLogo}</p>
                        </div>
                    </li>
                    <li class="clearfix">
                        <img src="${resRoot}/hiworld/summer/temp/img110X110.jpg" alt="头像"/>
                        <div class="info">
                            <strong>${actInfo.actName}</strong>
                            <p class="time">${actInfo.actStartTime?string('yyyy-MM-dd hh:mm')}</p>
                            <p class="con">${actInfo.actLogo}</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>