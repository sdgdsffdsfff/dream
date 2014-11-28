/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: NJ518ServiceImpl.java
 * Author:   13075787
 * Date:     2014-11-12 下午12:09:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izpzp.mash.constants.NJ518Constants;
import com.izpzp.mash.intf.InfoAdDao;
import com.izpzp.mash.intf.InfoBaseDao;
import com.izpzp.mash.intf.InfoCategoryDao;
import com.izpzp.mash.intf.LinkInfoDao;
import com.izpzp.mash.intf.NJ518Service;
import com.izpzp.mash.intf.dto.InfoAdBean;
import com.izpzp.mash.intf.dto.InfoBaseExtBean;
import com.izpzp.mash.intf.dto.InfoCategoryBean;
import com.izpzp.mash.intf.dto.LinkInfoBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoAdBean;
import com.izpzp.mash.intf.dto.SearchInfoBaseBean;
import com.izpzp.mash.intf.dto.SearchInfoCategoryBean;
import com.izpzp.mash.intf.dto.SearchLinkInfoBean;

/**
 * nj518<br> 
 * nj518信息
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class NJ518ServiceImpl implements NJ518Service {

    @Autowired
    InfoCategoryDao infoCategoryDao;
    
    @Autowired
    InfoBaseDao infoBaseDao;
    
    @Autowired
    InfoAdDao infoAdDao;
    
    @Autowired
    LinkInfoDao linkInfoDao;
    
    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.NJ518Service#getInfoAdList()
     */
    public List<InfoCategoryBean> getInfoCategoryList() {
        List<InfoCategoryBean> result = null;
        SearchInfoCategoryBean searchInfoCategoryBean = new SearchInfoCategoryBean();
        searchInfoCategoryBean.setPageNumber(NJ518Constants.NUM_1);
        searchInfoCategoryBean.setPageSize(NJ518Constants.MAX_NUM);
        QueryResult<InfoCategoryBean> query = infoCategoryDao.getInfoCategoryList(searchInfoCategoryBean);
        result = query.getDatas();
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.NJ518Service#getInfoBaseFirstList(java.lang.String)
     */
    public List<InfoBaseExtBean> getInfoBaseFirstList(String categoryCode) {
        List<InfoBaseExtBean> result = null;
        QueryResult<InfoBaseExtBean> query = this.getInfoBaseList(categoryCode, NJ518Constants.NUM_1, NJ518Constants.COM_NUM);
        result = query.getDatas();
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.NJ518Service#getInfoAdList(java.lang.String)
     */
    public List<InfoAdBean> getInfoAdList(String categoryCode, Integer adLocation) {
        List<InfoAdBean> result = null;
        SearchInfoAdBean searchInfoAd =new SearchInfoAdBean();
        searchInfoAd.setPageNumber(NJ518Constants.NUM_1);
        searchInfoAd.setPageSize(NJ518Constants.AD_COM_NUM);
        //查询条件
        searchInfoAd.setCategoryCode(categoryCode);
        searchInfoAd.setAdShowFlag(NJ518Constants.AD_SHOW_FLAG_SHOW);
        if(null != adLocation){
            searchInfoAd.setAdLocation(adLocation);
        }
        QueryResult<InfoAdBean> query = infoAdDao.getInfoAdList(searchInfoAd);
        result = query.getDatas();
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.NJ518Service#getLinkInfoList()
     */
    public List<LinkInfoBean> getLinkInfoList() {
        List<LinkInfoBean> result = null;
        SearchLinkInfoBean searchLinkInfoBean = new SearchLinkInfoBean();
        searchLinkInfoBean.setPageNumber(NJ518Constants.NUM_1);
        searchLinkInfoBean.setPageSize(NJ518Constants.MAX_NUM);
        //查询条件
        searchLinkInfoBean.setLinkShowFlag(NJ518Constants.LINK_SHOW_FLAG_SHOW);
        QueryResult<LinkInfoBean> query = linkInfoDao.getLinkInfoList(searchLinkInfoBean);
        result = query.getDatas();
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.NJ518Service#getInfoBaseList(java.lang.String, java.lang.Integer, java.lang.Integer)
     */
    public QueryResult<InfoBaseExtBean> getInfoBaseList(String categoryCode, Integer pageNumber, Integer pageSize) {
        SearchInfoBaseBean searchInfoBase = new SearchInfoBaseBean();
        if(null != pageNumber){
            searchInfoBase.setPageNumber(pageNumber);
        }
        if(null != pageSize){
            searchInfoBase.setPageSize(pageSize);
        }
        //查询条件
        searchInfoBase.setCategoryCode(categoryCode);
        searchInfoBase.setInfoDelFlag(NJ518Constants.INFO_DEL_FLAG_NO_DEL);
        QueryResult<InfoBaseExtBean> query = infoBaseDao.getInfoBaseExtList(searchInfoBase);
        return query;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.NJ518Service#getInfoBaseExt(java.lang.Integer)
     */
    public InfoBaseExtBean getInfoBaseExt(Integer infoId) {
        InfoBaseExtBean result = null;
        SearchInfoBaseBean searchInfoBase = new SearchInfoBaseBean();
        searchInfoBase.setPageNumber(NJ518Constants.NUM_1);
        searchInfoBase.setPageSize(NJ518Constants.NUM_1);
        //查询条件
        searchInfoBase.setInfoId(infoId);
        searchInfoBase.setInfoDelFlag(NJ518Constants.INFO_DEL_FLAG_NO_DEL);
        if(null != infoId){
            QueryResult<InfoBaseExtBean> query = infoBaseDao.getInfoBaseExtList(searchInfoBase);
            List<InfoBaseExtBean> resultList = query.getDatas();
            if(null != resultList){
                result = resultList.get(0);
            }
        }
        return result;
    }

}
