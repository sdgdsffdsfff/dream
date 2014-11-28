<#include "/nj518/macro/nextPage.ftl">
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>nj518-公共首页</title>
    <link rel="stylesheet" type="text/css" href="${resRoot}/nj518/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${resRoot}/lib/theme/default/style.css"/>
    <script type="text/javascript" src="${resRoot}/lib/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${resRoot}/lib/jquery.iDialog.min.js"></script>
    <script type="text/javascript" src="${resRoot}/nj518/js/main.js"></script>
    <script type="text/javascript" src="${resRoot}/nj518/js/infos.js"></script>
    <script type="text/javascript">
        var base = "${base}";
        var infosUrl = "/info/";
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
        <div class="rightPartBox carList">
                <div class="rightPartBox_t">
                      <#list categoryList as category >
                          <#if category.categoryCode == categoryCode >
                             <h2>${category.categoryName}</h2>
                          </#if>
                      </#list>
                </div>
                <div class="workList">
                    <table class="uiTable">
                        <thead>
                        <tr>
                            <th width="70">类型</th>
                            <th>标题</th>
                            <th width="180">日期</th>
                            <th width="130">查看</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list queryInfo.datas as queryInfo >
                        <tr>
                            <td><p>${queryInfo.typeName}</p></td>
                            <td><p><a class="showInfoDetails" infoId="${queryInfo.infoId}" href="javascript:void(0)">${queryInfo.infoTitle}</a></p></td>
                            <td><p>${queryInfo.createDttm?string('yyyy-MM-dd')}</p></td>
                            <td><p><a class="showInfoDetails" infoId="${queryInfo.infoId}" href="javascript:void(0)">查看</a></p></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="snPageWrap">
                    <div class="snPages">
                        <#if queryInfo.pageNumber==1  >
                        <span class="prev"><b></b>上一页</span>
                        <#else>
                        <a class="prev" href="${base}/infos/${categoryCode}/${queryInfo.pageNumber-1}"><b></b>上一页</a>
                        </#if>
                        <@snPagesPre pSize=queryInfo.pageNumber />
                        <a href="#" class="current" >${queryInfo.pageNumber}</a>
                        <@snPagesF pSize=queryInfo.pageNumber />
                        <#if queryInfo.isLastPage >
                        <span class="next" href="#"><b></b> 下一页</span>
                        <#else>
                        <a class="next" href="${base}/infos/${categoryCode}/${queryInfo.pageNumber+1}"><b></b> 下一页</a>
                        </#if>
                    </div>
                </div>
            </div>
    <#-- 友情链接 -->
    </div>
            <#-- 页面根 -->
            <#include "/nj518/footer.ftl">
</div>
</body>
</html>