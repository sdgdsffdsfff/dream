/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: UserServiceImpl.java
 * Author:   izpzp
 * Date:     2014-11-7 上午11:51:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 登陆认证<br> 
 * 登陆认证
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserServiceImpl implements AuthenticationProvider {

    /** 默认的基本权限 */
    public final static String ROLE_LOGINED = "AD_HODLE";
    
    /* (non-Javadoc)
     * @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
     */
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        UserDetails userDetails = null;
        
        
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                userDetails, authentication.getCredentials(),userDetails.getAuthorities());
        return result;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
     */
    public boolean supports(Class<?> authentication) {
        return true;
    }
    
}
