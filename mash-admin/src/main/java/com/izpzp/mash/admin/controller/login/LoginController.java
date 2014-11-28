/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: LoginController.java
 * Author:   13075787
 * Date:     2014-11-7 上午10:29:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.admin.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 13075787
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
        return "/login/login.ftl";
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
        return "/login/noAccess.ftl";
    }
    
    @RequestMapping("loginFail")
    public String loginFail(){
        return "/login/loginFail.ftl";
    }
    
    @RequestMapping("loginSuccess")
    public String loginSuccess(){
        return "/login/loginSuccess.ftl";
    }
}
