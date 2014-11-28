/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: InfoAdDaoImpl.java
 * Author:   13075787
 * Date:     2014-11-12 上午10:07:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.izpzp.mash.entity.InfoAd;
import com.izpzp.mash.intf.InfoAdDao;
import com.izpzp.mash.intf.dto.InfoAdBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoAdBean;
import com.izpzp.mash.util.BeanUtil;

/**
 * 信息广告<br> 
 * 信息广告维护
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class InfoAdDaoImpl extends BaseDao implements InfoAdDao {

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoAdDao#addInfoAd(com.izpzp.mash.intf.dto.InfoAdBean)
     */
    public boolean addInfoAd(InfoAdBean infoAdbean) {
        InfoAd infoAd = new InfoAd();
        if(null != infoAd){
            BeanUtil.copyProperties(infoAd, infoAdbean);
            getSqlMapClientTemplate().insert("insertInfoAd", infoAd);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoAdDao#updateInfoAd(com.izpzp.mash.intf.dto.InfoAdBean)
     */
    public boolean updateInfoAd(InfoAdBean infoAdbean) {
        InfoAd infoAd = new InfoAd();
        if(null != infoAdbean){
            BeanUtil.copyProperties(infoAd, infoAdbean);
            getSqlMapClientTemplate().update("updateInfoAd", infoAd);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoAdDao#delInfoAd(java.lang.Integer)
     */
    public boolean delInfoAd(Integer adId) {
        boolean result = false;
        int delNum = getSqlMapClientTemplate().delete("deleteInfoAd", adId);
        if(0 < delNum){
            result = true;
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoAdDao#getInfoAd(java.lang.Integer)
     */
    public InfoAdBean getInfoAd(Integer adId) {
        InfoAd infoAd = (InfoAd) getSqlMapClientTemplate().queryForObject("getInfoAdObject", adId);
        InfoAdBean result = null;
        if(null != infoAd){
            result = new InfoAdBean();
            BeanUtil.copyProperties(result, infoAd);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoAdDao#getInfoAdList(com.izpzp.mash.intf.dto.InfoAdBean, java.lang.Integer, java.lang.Integer)
     */
    public QueryResult<InfoAdBean> getInfoAdList(SearchInfoAdBean searchInfoAd) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getInfoAdCounts", searchInfoAd);
        QueryResult<InfoAdBean> querResult = new QueryResult<InfoAdBean>(totalDataCount, searchInfoAd.getPageSize(), searchInfoAd.getPageNumber());
        searchInfoAd.setStartIndex(querResult.getIndexNumber());
        searchInfoAd.setMaxCount(querResult.getPageSize());
        @SuppressWarnings("unchecked")
        List<InfoAdBean> infoAdList = getSqlMapClientTemplate().queryForList("getInfoAdList", searchInfoAd);
        querResult.setDatas(infoAdList);
        return querResult;
    }

}
