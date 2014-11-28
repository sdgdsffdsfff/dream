        <#list list as mash>
        <div class="col-lg-6 col-xs-6">
          <h4>${mash.userName}</h4>
          <p></p>
          <img src="${mash.mashContent}" alt="${mash.userName}" mashId="${mash.mashId}" class="img-thumbnail mashimg">
        </div>
        </#list>