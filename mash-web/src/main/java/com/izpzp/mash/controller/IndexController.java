/*
 * Copyright (C), 2002-2014, izpzp
 * FileName: IndexController.java
 * Date:     2014-11-11 上午11:40:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izpzp.mash.constants.NJ518Constants;
import com.izpzp.mash.intf.NJ518Service;
import com.izpzp.mash.intf.dto.InfoAdBean;
import com.izpzp.mash.intf.dto.InfoBaseExtBean;
import com.izpzp.mash.intf.dto.InfoCategoryBean;
import com.izpzp.mash.intf.dto.LinkInfoBean;
import com.izpzp.mash.intf.dto.QueryResult;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class IndexController {
    
    @Autowired
    NJ518Service nJ518Service;
    
    /**
     * 功能描述: <br>
     * 首页-信息首页
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("index")
    public String index(Map<String, Object> model){
        //查询出首页一级页广告信息
        List<InfoAdBean> indexAdList = nJ518Service.getInfoAdList(null, NJ518Constants.AD_LOCATION_1);
        model.put("indexAdList", indexAdList);
        //查询出首页的最新文章消息-本地的最新消息-促销-新闻-新店-动态-商机
        List<InfoBaseExtBean> indexInfoList = nJ518Service.getInfoBaseFirstList(NJ518Constants.BLOG_CATEGORY);
        model.put("indexInfoList", indexInfoList);
        //查询出类目信息
        List<InfoCategoryBean> infoCategoryList = nJ518Service.getInfoCategoryList();
        model.put("categoryList", infoCategoryList);
        //查询类目对应的广告
        Map<String, Object> adMap = new HashMap<String, Object>();
        for (InfoCategoryBean infoCategoryBean : infoCategoryList) {
            List<InfoAdBean> adList = nJ518Service.getInfoAdList(infoCategoryBean.getCategoryCode(), NJ518Constants.AD_LOCATION_2);
            adMap.put(infoCategoryBean.getCategoryCode(), adList);
        }
        model.put("adMap", adMap);
        //存放类目对应的消息
        Map<String, Object> infoMap = new HashMap<String, Object>();
        for (InfoCategoryBean infoCategoryBean : infoCategoryList) {
            List<InfoBaseExtBean> infoList = nJ518Service.getInfoBaseFirstList(infoCategoryBean.getCategoryCode());
            infoMap.put(infoCategoryBean.getCategoryCode(), infoList);
        }
        model.put("infoMap", infoMap);
        
        //查询友情链接
        List<LinkInfoBean> linkInfoList = nJ518Service.getLinkInfoList();
        model.put("linkInfoList", linkInfoList);
        
        return "nj518/index_public.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 信息列表展示
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("infos/{categoryCode}/{pageNumber}")
    public String infoListShow(Map<String, Object> model, @PathVariable String categoryCode, @PathVariable Integer pageNumber){
        //信息类目
        model.put("categoryCode", categoryCode);
        //查询出类目信息
        List<InfoCategoryBean> infoCategoryList = nJ518Service.getInfoCategoryList();
        model.put("categoryList", infoCategoryList);
        //查询信息列表
        QueryResult<InfoBaseExtBean> queryInfo = nJ518Service.getInfoBaseList(categoryCode, pageNumber, NJ518Constants.INFO_LIST_SIZE);
        model.put("queryInfo", queryInfo);
        return "nj518/infos.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 信息展示
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("info/{infoId}")
    public String infoShow(Map<String, Object> model, @PathVariable Integer infoId){
        //信息id
        model.put("infoId", infoId);
        InfoBaseExtBean info = nJ518Service.getInfoBaseExt(infoId);
        model.put("info", info);
        return "nj518/info.ftl";
    }
    
}
