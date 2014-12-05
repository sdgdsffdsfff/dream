/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: AcceptMsgDao.java
 * Author:   izpzp
 * Date:     2014-11-17 下午8:26:48
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import java.util.List;

import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.AccountInfoBean;
import com.izpzp.mash.intf.weixin.dto.SearchAccountInfoBean;

/**
 * 微信上墙-接收用户信息 <br> 
 * 微信上墙-接收用户信息
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface AccountInfoDao {
    /**
     * 功能描述: <br>
     * 添加接收用户信息
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean addAccountInfo(AccountInfoBean accountInfoBean);
    
    /**
     * 功能描述: <br>
     * 更新广告信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateAccountInfo(AccountInfoBean accountInfoBean);
    
    /**
     * 功能描述: <br>
     * 删除接收用户信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delAccountInfo(Integer mpId);
    
    /**
     * 功能描述: <br>
     * 获取接收用户信息
     *
     * @param adId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    AccountInfoBean getAccountInfo(Integer mpId);
    
    /**
     * 功能描述: <br>
     * 查询微信上墙-活动信息列表
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AccountInfoBean> getAccountInfoList(SearchAccountInfoBean searchAccountInfoBean);
    
    /**
     * 功能描述: <br>
     * 查询微信上墙-活动信息列表-分页
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<AccountInfoBean> getAccountInfos(SearchAccountInfoBean searchAccountInfoBean);
}
