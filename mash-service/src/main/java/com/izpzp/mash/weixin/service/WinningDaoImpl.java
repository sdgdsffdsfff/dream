/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: WinningDaoImpl.java
 * Author:   izpzp
 * Date:     2014-11-18 上午9:11:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.izpzp.mash.intf.WinningDao;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.SearchWinningBean;
import com.izpzp.mash.intf.weixin.dto.WinningBean;
import com.izpzp.mash.service.dao.BaseDao;

/**
 * 微信上墙-中奖<br> 
 * 微信上墙-中奖
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class WinningDaoImpl extends BaseDao implements WinningDao {

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.WinningDao#addWinning(com.izpzp.mash.intf.weixin.dto.WinningBean)
     */
    public boolean addWinning(WinningBean winningBean) {
        getSqlMapClientTemplate().insert("insertWinning", winningBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.WinningDao#updateWinning(com.izpzp.mash.intf.weixin.dto.WinningBean)
     */
    public boolean updateWinning(WinningBean winningBean) {
        getSqlMapClientTemplate().update("updateWinning", winningBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.WinningDao#delWinning(java.lang.Integer)
     */
    public boolean delWinning(Integer winId) {
        getSqlMapClientTemplate().delete("deleteWinning", winId);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.WinningDao#getWinning(java.lang.Integer)
     */
    public WinningBean getWinning(Integer winId) {
        WinningBean winningBean = (WinningBean) getSqlMapClientTemplate().queryForObject("getWinningObject", winId);
        return winningBean;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.WinningDao#getWinningList(com.izpzp.mash.intf.weixin.dto.SearchWinningBean)
     */
    public List<WinningBean> getWinningList(SearchWinningBean searchWinningBean) {
        @SuppressWarnings("unchecked")
        List<WinningBean> winningList = getSqlMapClientTemplate().queryForList("getWinningList", searchWinningBean);
        return winningList;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.WinningDao#getWinnings(com.izpzp.mash.intf.weixin.dto.SearchWinningBean)
     */
    public QueryResult<WinningBean> getWinnings(SearchWinningBean searchWinningBean) {
        int totalDataCount = this.getWinningCount(searchWinningBean);
        QueryResult<WinningBean> querResult = new QueryResult<WinningBean>(totalDataCount, searchWinningBean.getPageSize(), searchWinningBean.getPageNumber());
        searchWinningBean.setStartIndex(querResult.getIndexNumber());
        searchWinningBean.setMaxCount(querResult.getPageSize());
        List<WinningBean> winningList = this.getWinningList(searchWinningBean);
        querResult.setDatas(winningList);
        return querResult;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.WinningDao#getWinningCount(com.izpzp.mash.intf.weixin.dto.SearchWinningBean)
     */
    public Integer getWinningCount(SearchWinningBean searchWinningBean) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getWinningCounts", searchWinningBean);
        return totalDataCount;
    }

}
