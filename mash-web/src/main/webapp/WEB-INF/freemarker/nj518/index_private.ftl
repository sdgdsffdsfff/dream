<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>nj518-个人首页</title>
    <link rel="stylesheet" type="text/css" href="${resRoot}/nj518/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${resRoot}/lib/theme/default/style.css"/>
    <script type="text/javascript" src="${resRoot}/lib/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${resRoot}/lib/jquery.iDialog.min.js"></script>
        <script type="text/javascript" src="${resRoot}/nj518/js/main.js"></script>
    <script type="text/javascript" src="${resRoot}/nj518/js/myInfo.js"></script>
    <script type="text/javascript" >
        var base = "${base}";
        var myInfosUrl = "/myInfo/myInfos";
        var searchInfoList = new Object();
    </script>
</head>
<body>
<div class="topBar">
    <div class="topBarMain w990">
        <p class="l loginInfo">
            <span>2012年11月11日，</span>
            <a href="#">[姜菲菲]</a>
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
<div class="wrap">
    <div class="nav w990">
        <a class="nav1" href="${base}/index">首页</a>
        <#list categoryList as category >
        <a class="nav2" <#if category.categoryUrl?? >href='${category.categoryUrl}'<#else>href='${base}/infos/${category.categoryCode}/1'</#if> >${category.categoryName}</a>
        </#list>
    </div>
    <div class="main">
        <div class="leftPart">
            <div class="menu">
                <ul class="menuList clearfix">
                    <li>
                        <a class="menuBtn menuBtn1" href="#">信息发布管理</a>
                        <div class="subMenu">
                            <ul class="subMenuList clearfix">
                                <li>
                                    <a class="subMenuBtn" href="${base}/myInfo/index">我的消息</a>
                                </li>
                                <li>
                                    <a class="subMenuBtn" href="#">发布消息</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="menu_fgx"></li>
                    <li>
                        <a class="menuBtn menuBtn9" href="#">个人信息管理</a>
                        <div class="subMenu">
                            <ul class="subMenuList clearfix">
                                <li>
                                    <a class="subMenuBtn" href="#">个人信息</a>
                                </li>
                                <li>
                                    <a class="subMenuBtn" href="#">修改密码</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="link">
                <h2>友情链接</h2>
                <div class="linkListWrap">
                    <ul class="linkList linkScroll">
                        <li>
                            <a href="#" title="中华人民共和国工业和信息化部" target="_blank"><img src="images/linkImg01.jpg" width="170" height="60" alt="中华人民共和国工业和信息化部"/></a>
                            <p class="linkInfoBg"></p>
                            <p class="linkInfo"><a href="#" target="_blank">中华人民共和国工业和信息化部</a></p>
                        </li>
                        <li>
                            <a href="#" title="中华人民共和国公安部" target="_blank"><img src="images/linkImg02.jpg" width="170" height="60" alt="中华人民共和国公安部"/></a>
                            <p class="linkInfoBg"></p>
                            <p class="linkInfo"><a href="#" target="_blank">中华人民共和国公安部</a></p>
                        </li>
                        <li>
                            <a href="#" title="中华人民共和国交通运输部" target="_blank"><img src="images/linkImg03.jpg" width="170" height="60" alt="中华人民共和国交通运输部"/></a>
                            <p class="linkInfoBg"></p>
                            <p class="linkInfo"><a href="#" target="_blank">中华人民共和国交通运输部</a></p>
                        </li>
                        <li>
                            <a href="#" title="中国交通" target="_blank"><img src="images/linkImg04.jpg" width="170" height="60" alt="中国交通"/></a>
                            <p class="linkInfoBg"></p>
                            <p class="linkInfo"><a href="#" target="_blank">中国交通</a></p>
                        </li>
                        <li>
                            <a href="#" title="中国汽车召回网" target="_blank"><img src="images/linkImg05.jpg" width="170" height="60" alt="中国汽车召回网"/></a>
                            <p class="linkInfoBg"></p>
                            <p class="linkInfo"><a href="#" target="_blank">中国汽车召回网</a></p>
                        </li>
                        <li>
                            <a href="#" title="今日油价查询" target="_blank"><img src="images/linkImg06.jpg" width="170" height="60" alt="今日油价查询"/></a>
                            <p class="linkInfoBg"></p>
                            <p class="linkInfo"><a href="#" target="_blank">今日油价查询</a></p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="rightPart">
            <div class="rightPartBox">
                <div class="rightPartBox_t">
                    <h2>我的消息</h2>
                    <a href="#"></a>
                </div>
                <div class="rightPartBox_c myInfos">
                
                </div>
                
            </div>
                 <div class="snPageWrap">
                 
                </div>
                <div id="dialog-modal" >
                </div>
        </div>
    </div>
            <#-- 页面根 -->
            <#include "/nj518/footer.ftl">
</div>
</body>
</html>