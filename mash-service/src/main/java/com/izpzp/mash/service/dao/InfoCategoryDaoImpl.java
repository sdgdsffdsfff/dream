/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: InfoCategoryDaoImpl.java
 * Author:   13075787
 * Date:     2014-11-12 上午11:32:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izpzp.mash.entity.InfoCategory;
import com.izpzp.mash.intf.InfoCategoryDao;
import com.izpzp.mash.intf.dto.InfoCategoryBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoCategoryBean;
import com.izpzp.mash.util.BeanUtil;

/**
 * 信息-类目信息<br> 
 * 信息-类目信息维护
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class InfoCategoryDaoImpl extends BaseDao implements InfoCategoryDao {

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoCategoryDao#addInfoBase(com.izpzp.mash.intf.dto.InfoCategoryBean)
     */
    public boolean addInfoBase(InfoCategoryBean infoCategoryBean) {
        InfoCategory infoCategory = new InfoCategory();
        if(null != infoCategoryBean){
            BeanUtil.copyProperties(infoCategory, infoCategoryBean);
            getSqlMapClientTemplate().insert("insertInfoCategory", infoCategory);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoCategoryDao#updateInfoBase(com.izpzp.mash.intf.dto.InfoCategoryBean)
     */
    public boolean updateInfoBase(InfoCategoryBean infoCategoryBean) {
        InfoCategory infoCategory = new InfoCategory();
        if(null != infoCategoryBean){
            BeanUtil.copyProperties(infoCategory, infoCategoryBean);
            getSqlMapClientTemplate().update("updateInfoCategory", infoCategory);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoCategoryDao#delInfoBase(java.lang.Integer)
     */
    public boolean delInfoBase(Integer categoryId) {
        boolean result = false;
        int delNum = getSqlMapClientTemplate().delete("deleteInfoCategory", categoryId);
        if(0 < delNum){
            result = true;
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoCategoryDao#getInfoBase(java.lang.Integer)
     */
    public InfoCategoryBean getInfoBase(Integer categoryId) {
        InfoCategory infoCategory = (InfoCategory) getSqlMapClientTemplate().queryForObject("getInfoCategoryObject", categoryId);
        InfoCategoryBean result = null;
        if(null != infoCategory){
            result = new InfoCategoryBean();
            BeanUtil.copyProperties(result, infoCategory);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.InfoCategoryDao#getInfoBaseList(com.izpzp.mash.intf.dto.SearchInfoCategoryBean)
     */
    public QueryResult<InfoCategoryBean> getInfoCategoryList(SearchInfoCategoryBean searchInfoCategoryBean) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getInfoCategoryCounts", searchInfoCategoryBean);
        if(searchInfoCategoryBean.getPageSize() > totalDataCount){
            searchInfoCategoryBean.setPageSize(totalDataCount);
        }
        QueryResult<InfoCategoryBean> querResult = new QueryResult<InfoCategoryBean>(totalDataCount, searchInfoCategoryBean.getPageSize(), searchInfoCategoryBean.getPageNumber());
        searchInfoCategoryBean.setStartIndex(querResult.getIndexNumber());
        searchInfoCategoryBean.setMaxCount(querResult.getPageSize());
        @SuppressWarnings("unchecked")
        List<InfoCategory> infoBaseList = getSqlMapClientTemplate().queryForList("getInfoCategoryList", searchInfoCategoryBean);
        querResult.setDatas(this.toBeanList(infoBaseList));
        return querResult;
    }
    
    /*
     * list转换
     */
    private List<InfoCategoryBean> toBeanList(List<InfoCategory> list){
        List<InfoCategoryBean> result = null;
        if(null != list){
            result = new ArrayList<InfoCategoryBean>();
            for (InfoCategory infoCategory : list) {
                InfoCategoryBean infoCategoryBean = new InfoCategoryBean();
                BeanUtil.copyProperties(infoCategoryBean, infoCategory);
                result.add(infoCategoryBean);
            }
        }
        return result;
    }

}
