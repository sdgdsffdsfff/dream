<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>nj518-公共首页</title>
    <link rel="stylesheet" type="text/css" href="${resRoot}/nj518/css/main.css"/>
    <script type="text/javascript" src="${resRoot}/lib/jquery.min.js"></script>
    <script type="text/javascript" src="${resRoot}/nj518/js/main.js"></script>
    <script type="text/javascript" >
        //判断是IE浏览器，去除时间
        $(function(){
             var navigatorName = "Microsoft Internet Explorer";
             if( navigator.appName == navigatorName ){
                $('.r.ieHideTime').hide();
             }
        }); 
    </script>
</head>
<body>
<div class="topBar">
    <div class="topBarMain w990">
        <p class="l loginInfo">
            <span>2012年11月11日，</span>
            <a href="#">[姜菲菲] 你好</a>
            <span>欢迎您！</span>
        </p>
        <p class="r topBarNav">
            <a href="#">帮助</a>
            <a class="logout" href="#">注销</a>
        </p>
    </div>
</div>
<div class="top">
    <div class="topMain w990">
        <a class="logo" href="#" title="返回首页"></a>
    </div>
</div>
<div class="wrap index_public">
    <div class="nav w990">
        <a class="nav1" href="${base}/index">首页</a>
        <#list categoryList as category >
        <a class="nav2" <#if category.categoryUrl?? >href='${category.categoryUrl}'<#else>href='${base}/infos/${category.categoryCode}/1'</#if> >${category.categoryName}</a>
        </#list>
    </div>
    <div class="main">
            <div class="rightPartBox">
                <div class="rightPartBox_t">
                      <h2>全城通告</h2>
                      <a href="#">更多&nbsp;></a>
                </div>
                <div class="rightPartBox_c">
                    <div class="noticeImg">
                        <#list indexAdList as indexAd>
                        <img src="${resRoot}/${indexAd.imgUrl}" width="306" height="165" alt="${indexAd.targetUrl}"/>
                        </#list>
                    </div>
                    <ul class="noticeList">
                        <#list indexInfoList as indexInfo>
                        <li class="clearfix"><span class="l">·</span><a class="l" href="#">${indexInfo.infoTitle}</a><span class="r">${indexInfo.createDttm?string('yyyy-MM-dd')}</span></li>
                        </#list>
                    </ul>
                </div>
            </div>
            <div class="rightPartBox rightB_p">
                <div class="rightB_pC">
                    <ul>
                        <#list categoryList as category >
                        <li>
                            <div class="rightBImgBlog">
                                <#list adMap?keys as itemKey>
                                     <#if category.categoryCode==itemKey >
                                     <#list adMap[itemKey] as ad>
                                     <#-- 发布的消息列表 -->
                                     <p>
                                      <img src="${resRoot}/${ad.imgUrl}" width="200" height="162" alt=""/>
                                     </p>
                                     </#list>
                                     </#if>
                                 </#list>
                            </div>
                            <div class="rightB_infoBlog">
                                <b><a style="color:#444;" <#if category.categoryUrl?? >href='${category.categoryUrl}'<#else>href='${base}/infos/${category.categoryCode}/1'</#if> >${category.categoryName}</a></b>
                                <#list infoMap?keys as itemKey>
                                     <#if category.categoryCode==itemKey >
                                     <#list infoMap[itemKey] as info>
                                     <#-- 发布的消息列表 -->
                                     <p>
                                      [${info.typeName}]<a href="#" title="${info.infoTitle}" ><#if (info.infoTitle?length < 10) >${info.infoTitle}<#else>${info.infoTitle?substring(0,10)}.. </#if></a><span class="r ieHideTime" >${info.createDttm?string('yyyy-MM-dd')}</span>
                                     </p>
                                     </#list>
                                     </#if>
                                 </#list>
                            </div>
                        </li>
                        </#list>
                    </ul>
                </div>
            </div>
            <#-- 友情链接 -->
            <#include "/nj518/link_dynamic.ftl">
        </div>
            <#-- 页面根 -->
            <#include "/nj518/footer.ftl">
</div>
</body>
</html>