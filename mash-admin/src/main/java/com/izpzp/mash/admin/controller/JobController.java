/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: JobController.java
 * Author:   izpzp
 * Date:     2014-11-6 下午5:53:57
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("job")
public class JobController {
    
    @RequestMapping("init")
    public String initUser(HttpServletRequest request,
            Map<String, Object> model){
        model.put("user", request.getRemoteUser());
        model.put("session", request.getSession());
        return "/login/test.ftl";
    } 
    
}
