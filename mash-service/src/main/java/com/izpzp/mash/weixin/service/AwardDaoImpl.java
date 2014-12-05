/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: AwardDaoImpl.java
 * Author:   izpzp
 * Date:     2014-11-17 下午9:55:32
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.izpzp.mash.intf.AwardDao;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.AwardBean;
import com.izpzp.mash.intf.weixin.dto.SearchAwardBean;
import com.izpzp.mash.service.dao.BaseDao;

/**
 * 微信上墙-中奖 <br> 
 * 微信上墙-中奖
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class AwardDaoImpl extends BaseDao implements AwardDao {

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AwardDao#addAward(com.izpzp.mash.intf.weixin.dto.AwardBean)
     */
    public boolean addAward(AwardBean awardBean) {
        getSqlMapClientTemplate().insert("insertAward", awardBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AwardDao#updateAward(com.izpzp.mash.intf.weixin.dto.AwardBean)
     */
    public boolean updateAward(AwardBean awardBean) {
        getSqlMapClientTemplate().update("updateAward", awardBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AwardDao#delAward(java.lang.Integer)
     */
    public boolean delAward(Integer awardId) {
        getSqlMapClientTemplate().delete("deleteAward", awardId);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AwardDao#getAward(java.lang.Integer)
     */
    public AwardBean getAward(Integer awardId) {
        AwardBean awardBean = (AwardBean) getSqlMapClientTemplate().queryForObject("getAwardObject", awardId);
        return awardBean;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AwardDao#getAwardList(com.izpzp.mash.intf.weixin.dto.SearchAwardBean)
     */
    public List<AwardBean> getAwardList(SearchAwardBean searchAwardBean) {
        @SuppressWarnings("unchecked")
        List<AwardBean> awardList = getSqlMapClientTemplate().queryForList("getAwardList", searchAwardBean);
        return awardList;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.AwardDao#getAwards(com.izpzp.mash.intf.weixin.dto.SearchAwardBean)
     */
    public QueryResult<AwardBean> getAwards(SearchAwardBean searchAwardBean) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getAwardCounts", searchAwardBean);
        QueryResult<AwardBean> querResult = new QueryResult<AwardBean>(totalDataCount, searchAwardBean.getPageSize(), searchAwardBean.getPageNumber());
        searchAwardBean.setStartIndex(querResult.getIndexNumber());
        searchAwardBean.setMaxCount(querResult.getPageSize());
        List<AwardBean> awardList = this.getAwardList(searchAwardBean);
        querResult.setDatas(awardList);
        return querResult;
    }

}
