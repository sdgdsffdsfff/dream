/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: ActController.java
 * Author:   13075787
 * Date:     2014-11-21 上午9:49:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.izpzp.mash.controller.WriteHtmlUtils;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.ActBean;
import com.izpzp.mash.intf.weixin.dto.SearchActBean;
import com.izpzp.mash.weixin.constants.Constants;
import com.izpzp.mash.weixin.intf.ShowTheWorldAdminService;

/**
 * 微信上墙后台-活动维护<br> 
 * 微信上墙后台-活动维护
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RequestMapping("admin")
@Controller
public class ActController {
    
    @Autowired
    ShowTheWorldAdminService showTheWorldAdminService;
    
    /**
     * 功能描述: <br>
     * 保存活动信息-不存在则新增-存在则更新操作
     * @throws IOException 
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("saveAct")
    public void saveAct(HttpServletResponse response, 
            ActBean actBean) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        actBean.setCreator(adminUserCode);
        boolean flag = showTheWorldAdminService.saveAct(actBean);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.SUCCESS_FLAG, flag);
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
    /**
     * 功能描述: <br>
     * 删除活动信息
     *
     * @param response
     * @param actId
     * @throws IOException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("delAct")
    public void delAct(HttpServletResponse response, 
            Integer actId) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        boolean flag = showTheWorldAdminService.delAct(actId, adminUserCode);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.SUCCESS_FLAG, flag);
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
    /**
     * 功能描述: <br>
     * 获取活动信息详情
     *
     * @param response
     * @param actId
     * @throws IOException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("getAct")
    public void getAct(HttpServletResponse response, 
            Integer actId) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        SearchActBean searchActBean = new SearchActBean();
        searchActBean.setActId(actId);
        searchActBean.setCreator(adminUserCode);
        ActBean actBean = showTheWorldAdminService.getAct(searchActBean);
        WriteHtmlUtils.write(new Gson().toJson(actBean), response);
    }
    
    /**
     * 功能描述: <br>
     * 获取活动信息列表
     *
     * @param response
     * @param searchActBean
     * @throws IOException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("getActs")
    public void getActs(HttpServletResponse response, 
            SearchActBean searchActBean) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        searchActBean.setCreator(adminUserCode);
        QueryResult<ActBean> query = showTheWorldAdminService.getActs(searchActBean);
        WriteHtmlUtils.write(new Gson().toJson(query), response);
    }
}
