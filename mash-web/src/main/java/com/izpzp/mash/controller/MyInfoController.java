/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: MyInfoController.java
 * Author:   13075787
 * Date:     2014-11-14 上午11:22:42
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.izpzp.mash.constants.NJ518Constants;
import com.izpzp.mash.intf.NJ518PersonService;
import com.izpzp.mash.intf.NJ518Service;
import com.izpzp.mash.intf.dto.InfoBaseBean;
import com.izpzp.mash.intf.dto.InfoBaseExtBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoBaseBean;
import com.izpzp.mash.intf.dto.ext.InfoBaseOpr;
import com.izpzp.mash.intf.dto.ext.SIndexInfoBaseBean;
import com.izpzp.mash.util.BeanUtil;
import com.izpzp.mash.util.FreeMarkerResolver;

/**
 * 个人信息页<br> 
 * 个人信息页:维护发布信息，维护个人信息
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RequestMapping("myInfo")
@Controller
public class MyInfoController {
    
    @Autowired
    NJ518Service nJ518Service;
    
    @Autowired
    NJ518PersonService nJ518PersonService;
    
    @Autowired
    FreeMarkerResolver freeMarkerResolver;
    
    /**
     * 功能描述: <br>
     * 个人首页
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("index")
    public String privateIndex(){
        return "nj518/index_private.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 我的信息s
     *
     * @return
     * @throws IOException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("myInfos")
    public void myInfos(HttpServletResponse response, SIndexInfoBaseBean sIndexInfoBase) throws IOException{
        //查询条件
        SearchInfoBaseBean searchInfoBase = new SearchInfoBaseBean();
        BeanUtil.copyProperties(searchInfoBase, sIndexInfoBase);
        searchInfoBase.setPageSize(NJ518Constants.INFO_LIST_SIZE);//分页大小
        searchInfoBase.setInfoDelFlag(NJ518Constants.INFO_DEL_FLAG_NO_DEL);//未删除
        //用户信息 - TODO
        searchInfoBase.setUserId(123);
        //查询信息
        QueryResult<InfoBaseExtBean> query = nJ518PersonService.getMyInfoBaseList(searchInfoBase);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("infoList", query.getDatas());
        model.put("queryInfo", query);
        String infoList = freeMarkerResolver.resolve("nj518/myinfo/infoList.ftl", model);
        String nextPage = freeMarkerResolver.resolve("nj518/myinfo/nextPage.ftl", model);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("infoList", infoList);
        result.put("nextPage", nextPage);
        String html = new Gson().toJson(result);
        WriteHtmlUtils.write(html, response);
    }
    
    /**
     * 功能描述: <br>
     * 我的信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("info")
    public String myInfo(){
        
        return "nj518/myinfo/myInfo.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 保存信息
     * @throws IOException 
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("saveInfo")
    public void saveInfo(HttpServletResponse response, InfoBaseOpr infoBaseOpr) throws IOException{
        InfoBaseBean infoBase = new InfoBaseBean();
        BeanUtil.copyProperties(infoBase, infoBaseOpr);
        //用户信息 TODO
        infoBase.setCreator("123");
        infoBase.setUserId(123);
        
        Map<String, Object> msg = nJ518PersonService.saveInfo(infoBase);
        String html = new Gson().toJson(msg);
        WriteHtmlUtils.write(html, response);
    }
    
    /**
     * 功能描述: <br>
     * 修改信息
     * @throws IOException 
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("updateInfo")
    public void updateInfo(HttpServletResponse response, Integer infoId, InfoBaseOpr infoBaseOpr) throws IOException{
        InfoBaseBean infoBase = new InfoBaseBean();
        BeanUtil.copyProperties(infoBase, infoBaseOpr);
        infoBase.setInfoId(infoId);
        //用户信息 TODO
        infoBase.setCreator("123");
        infoBase.setUserId(123);
        
        Map<String, Object> msg = nJ518PersonService.updateInfo(infoBase);
        String html = new Gson().toJson(msg);
        WriteHtmlUtils.write(html, response);
    }
    
    /**
     * 功能描述: <br>
     * 删除信息
     * @throws IOException 
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("delInfo")
    public void delInfo(HttpServletResponse response, Integer infoId) throws IOException{
        InfoBaseBean infoBase = new InfoBaseBean();
        infoBase.setInfoId(infoId);
        //用户信息 TODO
        infoBase.setUserId(123);
        
        Map<String, Object> msg = nJ518PersonService.delInfo(infoBase);
        String html = new Gson().toJson(msg);
        WriteHtmlUtils.write(html, response);
    }
    
}
