/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: ActDaoImpl.java
 * Author:   izpzp
 * Date:     2014-11-17 下午9:49:13
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.izpzp.mash.intf.ActDao;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.ActBean;
import com.izpzp.mash.intf.weixin.dto.SearchActBean;
import com.izpzp.mash.service.dao.BaseDao;

/**
 * 微信上墙-活动信息 <br> 
 * 微信上墙-活动信息
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ActDaoImpl extends BaseDao implements ActDao {

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.ActDao#addAct(com.izpzp.mash.intf.weixin.dto.ActBean)
     */
    public boolean addAct(ActBean actBean) {
        getSqlMapClientTemplate().insert("insertAct", actBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.ActDao#updateAct(com.izpzp.mash.intf.weixin.dto.ActBean)
     */
    public boolean updateAct(ActBean actBean) {
        getSqlMapClientTemplate().update("updateAct", actBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.ActDao#delAct(java.lang.Integer)
     */
    public boolean delAct(Integer actId) {
        getSqlMapClientTemplate().delete("deleteAct", actId);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.ActDao#getAct(java.lang.Integer)
     */
    public ActBean getAct(Integer actId) {
        ActBean actBean = (ActBean) getSqlMapClientTemplate().queryForObject("getActObject", actId);
        return actBean;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.ActDao#getActList(com.izpzp.mash.intf.weixin.dto.SearchActBean)
     */
    public List<ActBean> getActList(SearchActBean searchActBean) {
        @SuppressWarnings("unchecked")
        List<ActBean> actList = getSqlMapClientTemplate().queryForList("getActList", searchActBean);
        return actList;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.ActDao#getActs(com.izpzp.mash.intf.weixin.dto.SearchActBean)
     */
    public QueryResult<ActBean> getActs(SearchActBean searchActBean) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getActCounts", searchActBean);
        QueryResult<ActBean> querResult = new QueryResult<ActBean>(totalDataCount, searchActBean.getPageSize(), searchActBean.getPageNumber());
        searchActBean.setStartIndex(querResult.getIndexNumber());
        searchActBean.setMaxCount(querResult.getPageSize());
        List<ActBean> actList = this.getActList(searchActBean);
        querResult.setDatas(actList);
        return querResult;
    }

}
