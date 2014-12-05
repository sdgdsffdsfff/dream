/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: InfoTypeDaoImpl.java
 * Author:   izpzp
 * Date:     2014-11-12 上午11:40:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service.dao;

import java.util.List;

import com.izpzp.mash.entity.InfoType;
import com.izpzp.mash.intf.InfoTypeDao;
import com.izpzp.mash.intf.dto.InfoTypeBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoTypeBean;
import com.izpzp.mash.util.BeanUtil;

/**
 * 信息类型-维护<br> 
 * 信息类型-维护
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InfoTypeDaoImpl extends BaseDao implements InfoTypeDao {

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoTypeDao#addInfoBase(com.izpzp.mash.intf.dto.InfoTypeBean)
     */
    public boolean addInfoBase(InfoTypeBean infoTypeBean) {
        InfoType infoType = new InfoType();
        if(null != infoTypeBean){
            BeanUtil.copyProperties(infoType, infoTypeBean);
            getSqlMapClientTemplate().insert("insertInfoType", infoType);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoTypeDao#updateInfoBase(com.izpzp.mash.intf.dto.InfoTypeBean)
     */
    public boolean updateInfoBase(InfoTypeBean infoTypeBean) {
        InfoType infoType = new InfoType();
        if(null != infoTypeBean){
            BeanUtil.copyProperties(infoType, infoTypeBean);
            getSqlMapClientTemplate().update("updateInfoType", infoType);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoTypeDao#delInfoBase(java.lang.Integer)
     */
    public boolean delInfoBase(Integer typeId) {
        boolean result = false;
        int delNum = getSqlMapClientTemplate().delete("deleteInfoType", typeId);
        if(0 < delNum){
            result = true;
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoTypeDao#getInfoBase(java.lang.Integer)
     */
    public InfoTypeBean getInfoBase(Integer typeId) {
        InfoType infoType = (InfoType) getSqlMapClientTemplate().queryForObject("getInfoTypeObject", typeId);
        InfoTypeBean result = null;
        if(null != infoType){
            result = new InfoTypeBean();
            BeanUtil.copyProperties(result, infoType);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoTypeDao#getInfoBaseList(com.izpzp.mash.intf.dto.SearchInfoTypeBean)
     */
    public QueryResult<InfoTypeBean> getInfoBaseList(SearchInfoTypeBean searchInfoTypeBean) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getInfoTypeCounts", searchInfoTypeBean);
        QueryResult<InfoTypeBean> querResult = new QueryResult<InfoTypeBean>(totalDataCount, searchInfoTypeBean.getPageSize(), searchInfoTypeBean.getPageNumber());
        searchInfoTypeBean.setStartIndex(querResult.getIndexNumber());
        searchInfoTypeBean.setMaxCount(querResult.getPageCount());
        @SuppressWarnings("unchecked")
        List<InfoTypeBean> infoBaseList = getSqlMapClientTemplate().queryForList("getInfoTypeList", searchInfoTypeBean);
        querResult.setDatas(infoBaseList);
        return querResult;
    }

}
