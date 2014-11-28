/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: FirstController.java
 * Author:   13075787
 * Date:     2014-11-4 下午7:24:11
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izpzp.mash.intf.MashArg;
import com.izpzp.mash.intf.MashInfoDao;
import com.izpzp.mash.intf.MashService;
import com.izpzp.mash.intf.dto.MashInfoBean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("mash")
public class MashController {
    
    @Autowired
    MashInfoDao mashInfoDao;
    
    @Autowired
    MashService mashService;
    
    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param model
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("index")
    public String mashIndex(Map<String, Object> model){
        List<MashInfoBean> list = mashInfoDao.getMashRandom();
        model.put("list", list);
        return "mash/mash.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param model
     * @param response
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("mashList")
    public String mashList(Map<String, Object> model, HttpServletResponse response){
        List<MashInfoBean> list = mashInfoDao.getMashRandom();
        model.put("list", list);
        return "mash/mashList.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 保存评分
     *
     * @return
     * @throws IOException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("saveScore")
    public void mashScore(MashArg mashArg, HttpServletResponse response) throws IOException{
        mashService.saveMashResult(mashArg);
        WriteHtmlUtils.write("true", response);
    }
    
    /**
     * 功能描述: <br>
     * mash比较排名排序
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("sortPage")
    public String mashSortPage(Map<String, Object> model){
        List<MashInfoBean> sortlist = mashInfoDao.getMashSort();
        List<MashInfoBean> newSortlist = mashInfoDao.getNewMashSort();
        model.put("sortlist", sortlist);
        model.put("newSortlist", newSortlist);
        return "mash/mashSort.ftl";
    }
}
