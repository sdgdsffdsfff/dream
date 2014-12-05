/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: AccessToken.java
 * Author:   izpzp
 * Date:     2014-11-19 上午9:36:15
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf.weixin.dto;

/**
 * access_token<br> 
 * access_token
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AccessToken {
    
    /**
     * 获取到的凭证
     */
    private String access_token;
    /**
     * 凭证有效时间，单位：秒
     */
    private Integer expires_in;
    /**
     * 错误码
     */
    private String errcode;
    /**
     * 错误信息
     */
    private String errmsg;
    
    /**
     * @return the access_token
     */
    public String getAccess_token() {
        return access_token;
    }
    /**
     * @param access_token the access_token to set
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
    /**
     * @return the expires_in
     */
    public Integer getExpires_in() {
        return expires_in;
    }
    /**
     * @param expires_in the expires_in to set
     */
    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
    /**
     * @return the errcode
     */
    public String getErrcode() {
        return errcode;
    }
    /**
     * @param errcode the errcode to set
     */
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }
    /**
     * @return the errmsg
     */
    public String getErrmsg() {
        return errmsg;
    }
    /**
     * @param errmsg the errmsg to set
     */
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    
}
