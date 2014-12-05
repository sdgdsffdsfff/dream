/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: AwardController.java
 * Author:   izpzp
 * Date:     2014-11-21 上午10:53:48
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.izpzp.mash.controller.WriteHtmlUtils;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.AwardBean;
import com.izpzp.mash.intf.weixin.dto.SearchAwardBean;
import com.izpzp.mash.weixin.constants.Constants;
import com.izpzp.mash.weixin.intf.ShowTheWorldAdminService;

/**
 * 微信上墙后台-中奖规则维护<br> 
 * 微信上墙后台-中奖规则维护
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RequestMapping("admin")
@Controller
public class AwardController {
    
    @Autowired
    ShowTheWorldAdminService showTheWorldAdminService;
    
    /**
     * 功能描述: <br>
     * 保存中奖规则信息-不存在则新建-有则更新
     *
     * @param response
     * @param awardBean
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("saveAward")
    public void saveAward(HttpServletRequest request,
            HttpServletResponse response, 
            AwardBean awardBean) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        adminUserCode = request.getRemoteUser();
        awardBean.setCreator(adminUserCode);
        boolean flag = showTheWorldAdminService.saveAward(awardBean);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.SUCCESS_FLAG, flag);
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
    /**
     * 功能描述: <br>
     * 删除中奖规则信息
     *
     * @param response
     * @param awardId
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("delAward")
    public void delAward(HttpServletRequest request,
            HttpServletResponse response, 
            Integer awardId) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        adminUserCode = request.getRemoteUser();
        boolean flag = showTheWorldAdminService.delAward(awardId, adminUserCode);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.SUCCESS_FLAG, flag);
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
    /**
     * 功能描述: <br>
     * 获取中奖规则详情
     *
     * @param response
     * @param awardId
     * @throws IOException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("getAward")
    public void getAward(HttpServletRequest request,
            HttpServletResponse response, 
            Integer awardId) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        adminUserCode = request.getRemoteUser();
        SearchAwardBean searchAwardBean = new SearchAwardBean();
        searchAwardBean.setCreator(adminUserCode);
        searchAwardBean.setAwardId(awardId);
        AwardBean awardBean = showTheWorldAdminService.getAward(searchAwardBean);
        WriteHtmlUtils.write(new Gson().toJson(awardBean), response);
    }
    
    /**
     * 功能描述: <br>
     * 获取中奖规则信息列表
     *
     * @param response
     * @param searchAwardBean
     * @throws IOException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("getAwards")
    public void getAwards(HttpServletRequest request,
            HttpServletResponse response, 
            SearchAwardBean searchAwardBean) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        adminUserCode = request.getRemoteUser();
        searchAwardBean.setCreator(adminUserCode);
        QueryResult<AwardBean> query = showTheWorldAdminService.getAwards(searchAwardBean);
        WriteHtmlUtils.write(new Gson().toJson(query), response);
    }
    
}
