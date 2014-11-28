/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: AccountController.java
 * Author:   13075787
 * Date:     2014-11-20 下午7:18:13
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
import com.izpzp.mash.intf.weixin.dto.AccountInfoBean;
import com.izpzp.mash.intf.weixin.dto.SearchAccountInfoBean;
import com.izpzp.mash.weixin.constants.Constants;
import com.izpzp.mash.weixin.intf.ShowTheWorldAdminService;

/**
 * 微信上墙后台-公众账号管理<br> 
 * 微信上墙后台-公众账号管理
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RequestMapping("admin")
@Controller
public class AccountController {
    
    @Autowired
    ShowTheWorldAdminService showTheWorldAdminService;
    
    /**
     * 功能描述: <br>
     * 保存账户信息-当mpId为空的时候为新增记录，mpId存在的时候为更新记录
     *
     * @param response
     * @param accountInfoBean
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("saveAccount")
    public void saveAccount(HttpServletResponse response, 
            AccountInfoBean accountInfoBean) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        accountInfoBean.setCreator(adminUserCode);
        boolean flag = showTheWorldAdminService.saveAccountInfo(accountInfoBean);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.SUCCESS_FLAG, flag);
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
    /**
     * 功能描述: <br>
     * 删除账户信息
     *
     * @param response
     * @param mpId
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("delAccount")
    public void delAccount(HttpServletResponse response,
            Integer mpId) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        boolean flag = showTheWorldAdminService.delAccountInfo(mpId, adminUserCode);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.SUCCESS_FLAG, flag);
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
    /**
     * 功能描述: <br>
     * 获取账号信息详情
     *
     * @param response
     * @param searchAccountInfoBean
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("getAccount")
    public void getAccount(HttpServletResponse response,
            Integer mpId) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        SearchAccountInfoBean searchAccountInfoBean = new SearchAccountInfoBean();
        searchAccountInfoBean.setMpId(mpId);
        searchAccountInfoBean.setCreator(adminUserCode);
        AccountInfoBean accountInfoBean = showTheWorldAdminService.getAccountInfo(searchAccountInfoBean);
        WriteHtmlUtils.write(new Gson().toJson(accountInfoBean), response);
    }
    
    /**
     * 功能描述: <br>
     * 获取账户信息列表
     *
     * @param response
     * @throws IOException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("getAccounts")
    public void getAccounts(HttpServletResponse response,
            SearchAccountInfoBean searchAccountInfoBean) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        searchAccountInfoBean.setCreator(adminUserCode);
        QueryResult<AccountInfoBean> query = showTheWorldAdminService.getAccountInfos(searchAccountInfoBean);
        WriteHtmlUtils.write(new Gson().toJson(query), response);
    }
}
