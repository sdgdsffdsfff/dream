/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: MsgController.java
 * Author:   13075787
 * Date:     2014-11-21 上午10:11:12
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
import com.izpzp.mash.intf.weixin.dto.MsgBean;
import com.izpzp.mash.intf.weixin.dto.SearchMsgBean;
import com.izpzp.mash.weixin.constants.Constants;
import com.izpzp.mash.weixin.intf.ShowTheWorldAdminService;

/**
 * 微信上墙后台-公众消息上墙管理<br> 
 * 微信上墙后台-公众消息上墙管理
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RequestMapping("admin")
@Controller
public class MsgController {
    
    @Autowired
    ShowTheWorldAdminService showTheWorldAdminService;
    
    @RequestMapping("saveMsg")
    public void saveMsg(HttpServletResponse response, 
            MsgBean msgBean) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        msgBean.setCreator(adminUserCode);
        boolean flag = showTheWorldAdminService.saveMsg(msgBean);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.SUCCESS_FLAG, flag);
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
    /**
     * 功能描述: <br>
     * 删除公众账号信息
     *
     * @param response
     * @param msgId
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("delMsg")
    public void delMsg(HttpServletResponse response, 
            Integer msgId) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        boolean flag = showTheWorldAdminService.delMsg(msgId, adminUserCode);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.SUCCESS_FLAG, flag);
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
    /**
     * 功能描述: <br>
     * 获取公众信息详情
     *
     * @param response
     * @param msgId
     * @throws IOException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("getMsg")
    public void getMsg(HttpServletResponse response, 
            Integer msgId) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        SearchMsgBean searchMsgBean = new SearchMsgBean();
        searchMsgBean.setCreator(adminUserCode);
        searchMsgBean.setMsgId(msgId);
        MsgBean msgBean = showTheWorldAdminService.getMsg(searchMsgBean);
        WriteHtmlUtils.write(new Gson().toJson(msgBean), response);
    }
    
    /**
     * 功能描述: <br>
     * 获取公众信息列表
     *
     * @param response
     * @param searchMsgBean
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("getMsgs")
    public void getMsgs(HttpServletResponse response, 
            SearchMsgBean searchMsgBean) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        searchMsgBean.setCreator(adminUserCode);
        QueryResult<MsgBean> query = showTheWorldAdminService.getMsgs(searchMsgBean);
        WriteHtmlUtils.write(new Gson().toJson(query), response);
    }
    
}
