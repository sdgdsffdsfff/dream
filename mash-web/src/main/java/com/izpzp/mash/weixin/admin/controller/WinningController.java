/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: WinningController.java
 * Author:   13075787
 * Date:     2014-11-21 上午11:18:24
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
import com.izpzp.mash.intf.weixin.dto.SearchWinningBean;
import com.izpzp.mash.intf.weixin.dto.WinningBean;
import com.izpzp.mash.weixin.constants.Constants;
import com.izpzp.mash.weixin.intf.ShowTheWorldAdminService;

/**
 * 微信上墙后台-中奖统计维护<br> 
 * 微信上墙后台-中奖统计维护
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RequestMapping("admin")
@Controller
public class WinningController {
    
    @Autowired
    ShowTheWorldAdminService showTheWorldAdminService;
    
    /**
     * 功能描述: <br>
     * 保存中奖信息-无则新建-有则更新
     *
     * @param response
     * @param winningBean
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("saveWinning")
    public void saveWinning(HttpServletResponse response, 
            WinningBean winningBean) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        winningBean.setCreator(adminUserCode);
        boolean flag = showTheWorldAdminService.saveWinning(winningBean);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.SUCCESS_FLAG, flag);
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
    /**
     * 功能描述: <br>
     * 删除中奖信息
     *
     * @param response
     * @param winId
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("delWinning")
    public void delWinning(HttpServletResponse response, 
            Integer winId) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        boolean flag = showTheWorldAdminService.delWinning(winId, adminUserCode);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.SUCCESS_FLAG, flag);
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
    /**
     * 功能描述: <br>
     * 获取中奖信息详情
     *
     * @param response
     * @param winId
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("getWinning")
    public void getWinning(HttpServletResponse response, 
            SearchWinningBean searchWinningBean) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        searchWinningBean.setCreator(adminUserCode);
        
        WinningBean winningBean = showTheWorldAdminService.getWinning(searchWinningBean);
        WriteHtmlUtils.write(new Gson().toJson(winningBean), response);
    }
    
    /**
     * 功能描述: <br>
     * 获取中奖信息列表
     *
     * @param response
     * @param searchWinningBean
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("getWinnings")
    public void getWinnings(HttpServletResponse response, 
            SearchWinningBean searchWinningBean) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        searchWinningBean.setCreator(adminUserCode);
        QueryResult<WinningBean> query = showTheWorldAdminService.getWinnings(searchWinningBean);
        WriteHtmlUtils.write(new Gson().toJson(query), response);
    }
    
    /**
     * 功能描述: <br>
     * 进行摇奖-产生中奖结果
     * @throws IOException 
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("bingo")
    public void binGo(HttpServletResponse response, 
            Integer actId) throws IOException{
        String adminUserCode = Constants.DEF_ADMIN;
        //返回是否还能摇奖-名额已满
        Map<String, Object> result = null;
        //进行抽奖
        result = showTheWorldAdminService.binGo(actId, adminUserCode);
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
}
