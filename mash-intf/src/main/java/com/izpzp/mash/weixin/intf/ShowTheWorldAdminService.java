/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: ShowTheWorldAdminService.java
 * Author:   izpzp
 * Date:     2014-11-20 上午11:53:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.intf;

import java.util.Map;

import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.AccountInfoBean;
import com.izpzp.mash.intf.weixin.dto.ActBean;
import com.izpzp.mash.intf.weixin.dto.AwardBean;
import com.izpzp.mash.intf.weixin.dto.MsgBean;
import com.izpzp.mash.intf.weixin.dto.SearchAccountInfoBean;
import com.izpzp.mash.intf.weixin.dto.SearchActBean;
import com.izpzp.mash.intf.weixin.dto.SearchAwardBean;
import com.izpzp.mash.intf.weixin.dto.SearchMsgBean;
import com.izpzp.mash.intf.weixin.dto.SearchWinningBean;
import com.izpzp.mash.intf.weixin.dto.WinningBean;

/**
 * 微信上墙后台管理<br> 
 * 微信上墙后台管理-公众账号信息-活动信息-上墙信息维护-中奖规则-中奖统计<br>
 * 此类中查询条件中都必须传入 creator字段，用作用户信息鉴权
 *  
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ShowTheWorldAdminService {
    
    /**
     * 功能描述: <br>
     * 保存公众账号信息-已存在则修改更新-不存在则新增
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean saveAccountInfo(AccountInfoBean accountInfoBean);
    
    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param mpId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delAccountInfo(Integer mpId, String adminUserCode);
    
    /**
     * 功能描述: <br>
     * 获取公众账号详情
     *
     * @param searchAccountInfoBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    AccountInfoBean getAccountInfo(SearchAccountInfoBean searchAccountInfoBean);
    
    /**
     * 功能描述: <br>
     * 获取公众账号信息列表
     * 
     * @param searchAccountInfoBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<AccountInfoBean> getAccountInfos(SearchAccountInfoBean searchAccountInfoBean);
    
    /**
     * 功能描述: <br>
     * 保存活动信息-已存在则修改更新-不存在则新增
     *
     * @param searchActBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean saveAct(ActBean actBean);
    
    /**
     * 功能描述: <br>
     * 删除活动信息
     *
     * @param actId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delAct(Integer actId, String adminUserCode);
    
    /**
     * 功能描述: <br>
     * 获取活动信息
     *
     * @param searchActBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ActBean getAct(SearchActBean searchActBean);
    
    /**
     * 功能描述: <br>
     * 获取活动信息列表
     *
     * @param searchActBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<ActBean> getActs(SearchActBean searchActBean);
    
    /**
     * 功能描述: <br>
     * 保存公众信息-已存在则修改更新-不存在则新增
     *
     * @param msgBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean saveMsg(MsgBean msgBean);
    
    /**
     * 功能描述: <br>
     * 删除公众信息
     *
     * @param msgId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delMsg(Integer msgId, String adminUserCode);
    
    /**
     * 功能描述: <br>
     * 获取公众信息详情
     *
     * @param searchMsgBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    MsgBean getMsg(SearchMsgBean searchMsgBean);
    
    /**
     * 功能描述: <br>
     * 获取公众信息
     *
     * @param searchMsgBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<MsgBean> getMsgs(SearchMsgBean searchMsgBean);
    
    /**
     * 功能描述: <br>
     * 保存中奖规则信息-已存在则修改更新-不存在则新增
     *
     * @param actBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean saveAward(AwardBean awardBean);
    
    /**
     * 功能描述: <br>
     * 删除中奖规则
     *
     * @param awardId
     * @param adminUserCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delAward(Integer awardId, String adminUserCode);
    
    /**
     * 功能描述: <br>
     * 获得中奖规则详情
     *
     * @param awardId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    AwardBean getAward(SearchAwardBean searchAwardBean);
    
    /**
     * 功能描述: <br>
     * 获取中奖规则列表
     *
     * @param searchAwardBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<AwardBean> getAwards(SearchAwardBean searchAwardBean);
    
    /**
     * 功能描述: <br>
     * 保存中奖信息-已存在则修改更新-不存在则新增
     *
     * @param winningBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean saveWinning(WinningBean winningBean);
    
    /**
     * 功能描述: <br>
     * 删除中奖信息
     *
     * @param winId
     * @param adminUserCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delWinning(Integer winId, String adminUserCode);
    
    /**
     * 功能描述: <br>
     * 获取中奖信息
     *
     * @param searchWinningBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    WinningBean getWinning(SearchWinningBean searchWinningBean);
    
    /**
     * 功能描述: <br>
     * 获得中奖信息列表
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<WinningBean> getWinnings(SearchWinningBean searchWinningBean);
    
    /**
     * 功能描述: <br>
     * 活动抽奖
     *
     * @param actId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> binGo(Integer actId, String adminUserCode);
}
