/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: WeinXinApi.java
 * Author:   13075787
 * Date:     2014-11-19 上午9:33:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.izpzp.mash.intf.weixin.dto.AccessToken;
import com.izpzp.mash.intf.weixin.dto.WeChatUserInfo;
import com.izpzp.mash.util.HttpClientUtil;

/**
 * 微信api<br> 
 * 微信api
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class WeinXinApi {
    
    /**
     * 功能描述: <br>
     * 获取access token
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public AccessToken getAccessToken(String appId, String secret){
        AccessToken accesToken = null;
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
        url = url + "&appid="+ appId +"&secret=" + secret;
        String result = HttpClientUtil.getData(url, null, null);
        if(StringUtils.isNotBlank(result)){
            accesToken = new Gson().fromJson(result, AccessToken.class);
        }
        return accesToken;
    }
    
    /**
     * 功能描述: <br>
     * 获取用户基本信息
     *
     * @param openid
     * @param accesToken
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public WeChatUserInfo getUserBaseInfo(String openid, String accesToken){
        WeChatUserInfo weChatUserInfo = null;
        String url = "https://api.weixin.qq.com/cgi-bin/user/info";
        url = url + "?access_token="+ accesToken +"&openid="+ openid +"&lang=zh_CN";
        String result = HttpClientUtil.getData(url, null, null);
        if(StringUtils.isNotBlank(result)){
            weChatUserInfo = new Gson().fromJson(result, WeChatUserInfo.class);
        }
        return weChatUserInfo;
    }
    
}
