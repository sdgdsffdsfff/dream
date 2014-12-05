/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: AdminController.java
 * Author:   izpzp
 * Date:     2014-11-24 下午7:25:05
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izpzp.mash.intf.UserDao;
import com.izpzp.mash.intf.weixin.dto.SearchUserBean;
import com.izpzp.mash.intf.weixin.dto.UserBean;

/**
 * 微信上墙-管理台<br> 
 * 微信上墙-管理台
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RequestMapping("admin")
@Controller
public class AdminController {
    
    @Autowired
    UserDao userDao;
    
    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("")
    public String index(HttpServletRequest request, 
            Map<String, Object> model){
        String userCode = request.getRemoteUser();
        SearchUserBean searchUserBean = new SearchUserBean();
        UserBean userBean = userDao.getUser(searchUserBean);
        model.put("userCode", userCode);
        model.put("userName", userBean.getUserCode());
        return "hiworld/admin/easy/index.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 公众账号信息列表页面
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("accountList")
    public String accountList(){
        return "hiworld/admin/easy/accountList.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 活动信息列表页面
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("actList")
    public String actList(){
        return "hiworld/admin/easy/actList.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 活动信息详情页面
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("actDetail")
    public String actDetail(Map<String, Object> model, 
            Integer actId){
        model.put("actId", actId);
        return "hiworld/admin/easy/actDetail.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 中奖规则列表页面
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("awardList")
    public String awardList(){
        return "hiworld/admin/easy/awardList.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 中奖规则详情页面
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("awardDetail")
    public String awardDetail(){
        return "hiworld/admin/easy/awardDetail.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 公众消息列表页
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("msgList")
    public String msgList(){
        return "hiworld/admin/easy/msgList.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 中奖统计页面
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("winningList")
    public String winningList(){
        return "hiworld/admin/easy/winningList.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 中奖统计页面
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("adminInfo")
    public String adminInfo(){
        return "hiworld/admin/easy/adminInfo.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 活动图片维护页面
     *
     * @param model
     * @param actId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("actImg")
    public String actImg(Map<String, Object> model, 
            Integer actId){
        model.put("actId", actId);
        return "hiworld/admin/easy/actImg.ftl";
    }
    
    /**
     * 功能描述: <br>
     * 消息统计
     *
     * @param model
     * @param actId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("msgSta")
    public String msgStatistics(Map<String, Object> model, 
            Integer actId){
        model.put("actId", actId);
        return "hiworld/admin/easy/msgSta.ftl";
    }
    
}
