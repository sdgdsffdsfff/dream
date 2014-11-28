<#macro snPagesPre pSize>
<#list ["${pSize-5}","${pSize-4}","${pSize-3}","${pSize-2}","${pSize-1}"] as ppSize >
<#if !(ppSize?contains("-") || ppSize?contains("0")) >
<a class="nextEvent" href="javascript:void(0)" pageNum="${ppSize}" >${ppSize}</a>
</#if>
</#list>
</#macro>
<#macro snPagesF pSize>
<#list ["${pSize+1}","${pSize+2}","${pSize+3}","${pSize+4}","${pSize+5}"] as ppSize >
<#if (ppSize?number <= queryInfo.pageCount) >
<a class="nextEvent" href="javascript:void(0)" pageNum="${ppSize}" >${ppSize}</a>
</#if>
</#list>
</#macro>
<div class="snPages">
     <#if queryInfo.pageNumber==1  >
     <span class="prev"><b></b>上一页</span>
     <#else>
     <a class="nextEvent prev" href="javascript:void(0)" type="prev" ><b></b>上一页</a>
     </#if>
     <@snPagesPre pSize=queryInfo.pageNumber />
     <a href="javascript:void(0)" class="nextEvent current" pageNum="${queryInfo.pageNumber}" >${queryInfo.pageNumber}</a>
     <@snPagesF pSize=queryInfo.pageNumber />
     <#if queryInfo.isLastPage >
     <span class="next" ><b></b> 下一页</span>
     <#else>
     <a class="nextEvent next" href="javascript:void(0)" type="next" ><b></b> 下一页</a>
     </#if>
</div>