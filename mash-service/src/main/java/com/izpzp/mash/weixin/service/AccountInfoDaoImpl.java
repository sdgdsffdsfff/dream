/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: AcceptMsgDaoImpl.java
 * Author:   izpzp
 * Date:     2014-11-17 下午8:28:44
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.izpzp.mash.intf.AccountInfoDao;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.AccountInfoBean;
import com.izpzp.mash.intf.weixin.dto.SearchAccountInfoBean;
import com.izpzp.mash.service.dao.BaseDao;

/**
 * 微信上墙-接收用户信息 <br> 
 * 微信上墙-接收用户信息
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class AccountInfoDaoImpl extends BaseDao implements AccountInfoDao {

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AccountInfoDao#addAccountInfo(com.izpzp.mash.intf.weixin.dto.AccountInfoBean)
     */
    public boolean addAccountInfo(AccountInfoBean accountInfoBean) {
        getSqlMapClientTemplate().insert("insertAccountInfo", accountInfoBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AccountInfoDao#updateAccountInfo(com.izpzp.mash.intf.weixin.dto.AccountInfoBean)
     */
    public boolean updateAccountInfo(AccountInfoBean accountInfoBean) {
        getSqlMapClientTemplate().update("updateAccountInfo", accountInfoBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AccountInfoDao#delAccountInfo(java.lang.Integer)
     */
    public boolean delAccountInfo(Integer mpId) {
        getSqlMapClientTemplate().delete("deleteAccountInfo", mpId);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AccountInfoDao#getAccountInfo(java.lang.Integer)
     */
    public AccountInfoBean getAccountInfo(Integer mpId) {
        AccountInfoBean accountInfoBean = (AccountInfoBean) getSqlMapClientTemplate().queryForObject("getAccountInfoObject", mpId);
        return accountInfoBean;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AccountInfoDao#getAccountInfoList(com.izpzp.mash.intf.weixin.dto.SearchAccountInfoBean)
     */
    public List<AccountInfoBean> getAccountInfoList(SearchAccountInfoBean searchAccountInfoBean) {
        @SuppressWarnings("unchecked")
        List<AccountInfoBean> accountInfoList = getSqlMapClientTemplate().queryForList("getAccountInfoList", searchAccountInfoBean);
        return accountInfoList;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AccountInfoDao#getAccountInfos(com.izpzp.mash.intf.weixin.dto.SearchAccountInfoBean)
     */
    public QueryResult<AccountInfoBean> getAccountInfos(SearchAccountInfoBean searchAccountInfoBean) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getAccountInfoCounts", searchAccountInfoBean);
        QueryResult<AccountInfoBean> querResult = new QueryResult<AccountInfoBean>(totalDataCount, searchAccountInfoBean.getPageSize(), searchAccountInfoBean.getPageNumber());
        searchAccountInfoBean.setStartIndex(querResult.getIndexNumber());
        searchAccountInfoBean.setMaxCount(querResult.getPageSize());
        List<AccountInfoBean> accountInfoList = this.getAccountInfoList(searchAccountInfoBean);
        querResult.setDatas(accountInfoList);
        return querResult;
    }

}
