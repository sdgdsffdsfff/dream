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
        <#list list as mash>
        <div class="col-lg-6 col-xs-6">
          <h4>${mash.userName}</h4>
          <p></p>
          <img src="${mash.mashContent}" alt="${mash.userName}" mashId="${mash.mashId}" class="img-thumbnail mashimg">
        </div>
        </#list>
      </div>
      <div class="row marketing">
      
      </div>
      <#include "/mash/footer.ftl">
      
      <script src="${resRoot}/mash/js/mash.js${resUrlSuffix}"></script>
      <script>
          var base = '${base}';
          var mash = new Object();
          mash.mashAid="${list[0].mashId}";
          mash.mashBid="${list[1].mashId}";
      </script>
</div>
</body>
</html>