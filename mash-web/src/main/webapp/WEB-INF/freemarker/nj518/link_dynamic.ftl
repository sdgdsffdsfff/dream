            <div class="link1">
            <h2>友情链接</h2>
            <div class="linkListWrap1">
                <div class="linkListWrap2">
                    <ul class="linkList1 linkScroll">
                        <#list linkInfoList as linkInfo> 
                        <li>
                            <a href="${linkInfo.linkUrl}" title="${linkInfo.linkTitle}" target="_blank"><img src="${resRoot}/${linkInfo.linkImg}" width="170" height="60" alt="${linkInfo.linkDesc}"/></a>
                            <p class="linkInfoBg"></p>
                            <p class="linkInfo"><a href="${linkInfo.linkUrl}" target="_blank" rel="nofollow" >${linkInfo.linkTitle}</a></p>
                        </li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>