/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: UserServiceImpl.java
 * Author:   izpzp
 * Date:     2014-11-24 下午1:23:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.izpzp.mash.intf.UserDao;
import com.izpzp.mash.intf.weixin.dto.SearchUserBean;
import com.izpzp.mash.intf.weixin.dto.UserBean;

/**
 * 用户信息管理<br> 
 * 用户信息管理
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserDao UserDao;
    
    public UserDetailServiceImpl(){
    }
    
    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.UserService#loadUserByUsername(java.lang.String)
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        SearchUserBean searchUserBean = new SearchUserBean();
        searchUserBean.setUserName(username);
        UserBean userBean = UserDao.getUser(searchUserBean);
        if(null == userBean){
            throw new UsernameNotFoundException(username+" not exist!");
        }
        List<GrantedAuthority> authsList = new ArrayList<GrantedAuthority>();
        authsList.add(new SimpleGrantedAuthority("ROLE_USER"));
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        boolean enabledFlag = false;
        if(null != userBean && "1".equals(userBean.getEnabledFlag())){
            enabledFlag = true;
        }
        UserDetails userdetails = new org.springframework.security.core.userdetails.User(userBean.getUserName(), userBean  
                .getPassword(),enabledFlag, accountNonExpired, credentialsNonExpired, accountNonLocked, authsList);
        
        return userdetails;
    }

}
