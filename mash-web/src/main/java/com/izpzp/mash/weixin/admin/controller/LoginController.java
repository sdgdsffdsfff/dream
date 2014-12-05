/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: LoginController.java
 * Author:   izpzp
 * Date:     2014-12-1 下午4:14:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录<br> 
 * 登录
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class LoginController {
    /**
     * 功能描述: <br>
     * 后台登陆页
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("login")
    public String login(){
        return "hiworld/login/login.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 无访问权限
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("noAccess")
    public String noAccess(){
        return "hiworld/login/noAccess.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 登录失败
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("loginFail")
    public String loginFail(){
        return "hiworld/login/loginFail.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 登录失败
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("loginSuccess")
    public String loginSuccess(){
        return "hiworld/login/loginSuccess.ftl";
    }
    
}
