<#macro snPagesPre pSize>
<#list ["${pSize-5}","${pSize-4}","${pSize-3}","${pSize-2}","${pSize-1}"] as ppSize >
<#if !(ppSize?contains("-") || ppSize?contains("0")) >
<a href="${base}/infos/${categoryCode}/${ppSize}">${ppSize}</a>
</#if>
</#list>
</#macro>
<#macro snPagesF pSize>
<#list ["${pSize+1}","${pSize+2}","${pSize+3}","${pSize+4}","${pSize+5}"] as ppSize >
<#if (ppSize?number < queryInfo.pageCount) >
<a href="${base}/infos/${categoryCode}/${ppSize}">${ppSize}</a>
</#if>
</#list>
</#macro>