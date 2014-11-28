<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
	<title>mash</title>
	<link rel="stylesheet" href="${resRoot}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${resRoot}/bootstrap/css/jumbotron-narrow.css">
	<script src="${resRoot}/lib/jquery.min.js"></script>
	<script src="${resRoot}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
      <#include "/mash/header.ftl">
      
      <div class="row marketing" id="mashBox" >
        <div class="col-lg-6 col-xs-6">
         <h4>排名榜</h4>
         <#list sortlist as mash>
          <p>${mash.userName}</p>
          <img src="${mash.mashContent}" alt="${mash.userName}" mashId="${mash.mashId}" class="img-thumbnail mashimg">
         </#list>
        </div>
        <div class="col-lg-6 col-xs-6">
         <h4>最佳新人榜</h4>
         <#list newSortlist as mash>
          <p>${mash.userName}</p>
          <img src="${mash.mashContent}" alt="${mash.userName}" mashId="${mash.mashId}" class="img-thumbnail mashimg">
         </#list>
        </div>
      </div>
      
      <#include "/mash/footer.ftl">      
      <script>
          var base = '${base}';
          $("#homePage").attr("class","");
          $("#sortPage").attr("class","active");
      </script>
</div>
</body>
</html>