/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: ShowTheWorldController.java
 * Author:   izpzp
 * Date:     2014-11-18 下午3:08:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.izpzp.mash.controller.WriteHtmlUtils;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.ActBean;
import com.izpzp.mash.intf.weixin.dto.MsgExtBean;
import com.izpzp.mash.weixin.constants.Constants;
import com.izpzp.mash.weixin.intf.ShowTheWorldService;

/**
 * 上墙-ShowTheWorld <br> 
 * 上墙
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RequestMapping("showTheWorld")
@Controller
public class ShowTheWorldController {
    
    @Autowired
    ShowTheWorldService showTheWorldService;
    
    /**
     * 功能描述: <br>
     * 墙
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/{actId}")
    public String showTheWorld(Map<String, Object> model,
            @PathVariable Integer actId){
        if(null != actId){
            ActBean actInfo = showTheWorldService.getActInfo(actId);
            model.put("actInfo", actInfo);
        }
        return "hiworld/summer/theWall.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 获取公众信息列表
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/{actId}/msgs")
    public String getMPMsgs(@PathVariable Integer actId, Integer pageIndex, 
            Map<String, Object> model){
        Integer pageSize = Constants.WALL_MSG_SIZE;
        QueryResult<MsgExtBean> msgQuery = showTheWorldService.getMsgs(actId, pageIndex, pageSize);
        model.put("msgQuery", msgQuery);
        return "hiworld/summer/msgs.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 获取公众信息列表-json格式数据
     *
     * @param actId
     * @param pageIndex
     * @param model
     * @return
     * @throws IOException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/{actId}/msgsJson")
    public void getMPMsgsJson(@PathVariable Integer actId, Integer pageIndex, Integer pageSize, 
            HttpServletResponse response) throws IOException{
        QueryResult<MsgExtBean> msgQuery = showTheWorldService.getMsgs(actId, pageIndex, pageSize);
        String html = new Gson().toJson(msgQuery);
        WriteHtmlUtils.write(html, response);
    }
    
    /**
     * 功能描述: <br>
     * 初始化显示过的公众信息-随机展示其中的几条-暂定初始1条
     *
     * @param response
     * @param actId
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/{actId}/initShow")
    public void initMsgShowFlagStatus(HttpServletResponse response, 
            @PathVariable Integer actId) throws IOException{
        Map<String, Object> result = new HashMap<String, Object>();
        boolean resultFlag = showTheWorldService.initMsgShowFlagStatus(actId);
        result.put("flag", resultFlag);
        String html = new Gson().toJson(result);
        WriteHtmlUtils.write(html, response);
    }
    
    /**
     * 功能描述: <br>
     * 获取该活动的参数人数与发布消息数
     *
     * @param response
     * @param actId
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/{actId}/actExt")
    public void getActExtInfo(HttpServletResponse response, 
            @PathVariable Integer actId) throws IOException{
        Map<String, Object> result = showTheWorldService.getActExtInfo(actId);
        String html = new Gson().toJson(result);
        WriteHtmlUtils.write(html, response);
    }
}
