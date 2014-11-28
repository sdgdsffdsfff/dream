<ul style="height: auto;" >
    <#list infoList as info >
    <li class="clearfix"><span class="l">·</span><a class="l personInfo" href="javascript:void(0)" infoId="${info.infoId}" >[${info.typeName}]${info.infoTitle}</a><span class="r"><a href="javascript:void(0)" ></a>${info.createDttm?string('yyyy-MM-dd')}</span></li>
    </#list>
</ul>