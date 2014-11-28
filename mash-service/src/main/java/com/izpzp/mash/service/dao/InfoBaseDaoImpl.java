/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: InfoBaseDaoImpl.java
 * Author:   13075787
 * Date:     2014-11-12 上午11:15:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.izpzp.mash.entity.InfoBase;
import com.izpzp.mash.intf.InfoBaseDao;
import com.izpzp.mash.intf.dto.InfoBaseBean;
import com.izpzp.mash.intf.dto.InfoBaseExtBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoBaseBean;
import com.izpzp.mash.util.BeanUtil;

/**
 * 发布信息<br> 
 * 发布信息
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class InfoBaseDaoImpl extends BaseDao implements InfoBaseDao {
    
    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoBaseDao#addInfoBase(com.izpzp.mash.intf.dto.InfoBaseBean)
     */
    public boolean addInfoBase(InfoBaseBean infoBaseBean) {
        InfoBase infoBase = new InfoBase();
        if(null != infoBaseBean){
            BeanUtil.copyProperties(infoBase, infoBaseBean);
            getSqlMapClientTemplate().insert("insertInfoBase", infoBase);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoBaseDao#updateInfoBase(com.izpzp.mash.intf.dto.InfoBaseBean)
     */
    public boolean updateInfoBase(InfoBaseBean infoBaseBean) {
        InfoBase infoBase = new InfoBase();
        if(null != infoBaseBean){
            BeanUtil.copyProperties(infoBase, infoBaseBean);
            getSqlMapClientTemplate().update("updateInfoBase", infoBase);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoBaseDao#delInfoBase(java.lang.Integer)
     */
    public boolean delInfoBase(Integer infoId) {
        boolean result = false;
        int delNum = getSqlMapClientTemplate().delete("deleteInfoBase", infoId);
        if(0 < delNum){
            result = true;
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoBaseDao#getInfoBase(java.lang.Integer)
     */
    public InfoBaseBean getInfoBase(Integer infoId) {
        InfoBase infoBase = (InfoBase) getSqlMapClientTemplate().queryForObject("getInfoBaseObject", infoId);
        InfoBaseBean result = null;
        if(null != infoBase){
            result = new InfoBaseBean();
            BeanUtil.copyProperties(result, infoBase);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoBaseDao#getInfoBaseList(com.izpzp.mash.intf.dto.SearchInfoBaseBean)
     */
    public QueryResult<InfoBaseBean> getInfoBaseList(SearchInfoBaseBean searchInfoBase) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getInfoBaseCounts", searchInfoBase);
        QueryResult<InfoBaseBean> querResult = new QueryResult<InfoBaseBean>(totalDataCount, searchInfoBase.getPageSize(), searchInfoBase.getPageNumber());
        searchInfoBase.setStartIndex(querResult.getIndexNumber());
        searchInfoBase.setMaxCount(querResult.getPageSize());
        @SuppressWarnings("unchecked")
        List<InfoBaseBean> infoBaseList = getSqlMapClientTemplate().queryForList("getInfoBaseList", searchInfoBase);
        querResult.setDatas(infoBaseList);
        return querResult;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoBaseDao#getInfoBaseExtList(com.izpzp.mash.intf.dto.SearchInfoBaseBean)
     */
    public QueryResult<InfoBaseExtBean> getInfoBaseExtList(SearchInfoBaseBean searchInfoBase) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getInfoBaseExtBeanCounts", searchInfoBase);
        QueryResult<InfoBaseExtBean> querResult = new QueryResult<InfoBaseExtBean>(totalDataCount, searchInfoBase.getPageSize(), searchInfoBase.getPageNumber());
        searchInfoBase.setStartIndex(querResult.getIndexNumber());
        searchInfoBase.setMaxCount(querResult.getPageSize());
        @SuppressWarnings("unchecked")
        List<InfoBaseExtBean> infoBaseList = getSqlMapClientTemplate().queryForList("getInfoBaseExtBeanList", searchInfoBase);
        querResult.setDatas(infoBaseList);
        return querResult;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoBaseDao#delInfoBase(com.izpzp.mash.intf.dto.InfoBaseBean)
     */
    public boolean delInfoBase(InfoBaseBean infoBaseBean) {
        boolean result = false;
        getSqlMapClientTemplate().delete("deleteInfoBaseExt", infoBaseBean);
        result = true;
        return result;
    }
    
}
