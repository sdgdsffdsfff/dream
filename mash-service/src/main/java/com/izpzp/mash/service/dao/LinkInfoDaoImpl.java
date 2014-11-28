/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: LinkInfoDaoImpl.java
 * Author:   13075787
 * Date:     2014-11-13 上午11:58:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izpzp.mash.entity.LinkInfo;
import com.izpzp.mash.intf.LinkInfoDao;
import com.izpzp.mash.intf.dto.LinkInfoBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchLinkInfoBean;
import com.izpzp.mash.util.BeanUtil;

/**
 * 友情链接信息<br> 
 * 友情链接信息
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class LinkInfoDaoImpl extends BaseDao implements LinkInfoDao {

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.LinkInfoDao#addLinkInfo(com.izpzp.mash.intf.dto.LinkInfoBean)
     */
    public boolean addLinkInfo(LinkInfoBean linkInfoBean) {
        LinkInfo linkInfo = new LinkInfo();
        if(null != linkInfoBean){
            BeanUtil.copyProperties(linkInfo, linkInfoBean);
            getSqlMapClientTemplate().insert("insertLinkInfo", linkInfo);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.LinkInfoDao#updateLinkInfo(com.izpzp.mash.intf.dto.LinkInfoBean)
     */
    public boolean updateLinkInfo(LinkInfoBean linkInfoBean) {
        LinkInfo linkInfo = new LinkInfo();
        if(null != linkInfoBean){
            BeanUtil.copyProperties(linkInfo, linkInfoBean);
            getSqlMapClientTemplate().update("updateLinkInfo", linkInfo);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.LinkInfoDao#delLinkInfo(java.lang.Integer)
     */
    public boolean delLinkInfo(Integer linkId) {
        boolean result = false;
        int delNum = getSqlMapClientTemplate().delete("deleteLinkInfo", linkId);
        if(0 < delNum){
            result = true;
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.LinkInfoDao#getLinkInfo(java.lang.Integer)
     */
    public LinkInfoBean getLinkInfo(Integer linkId) {
        LinkInfo linkInfo = (LinkInfo) getSqlMapClientTemplate().queryForObject("getLinkInfoObject", linkId);
        LinkInfoBean result = null;
        if(null != linkInfo){
            result = new LinkInfoBean();
            BeanUtil.copyProperties(result, linkInfo);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.LinkInfoDao#getLinkInfoList(com.izpzp.mash.intf.dto.SearchLinkInfoBean)
     */
    public QueryResult<LinkInfoBean> getLinkInfoList(SearchLinkInfoBean searchLinkInfoBean) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getLinkInfoCounts", searchLinkInfoBean);
        if(searchLinkInfoBean.getPageSize() > totalDataCount){
            searchLinkInfoBean.setPageSize(totalDataCount);
        }
        QueryResult<LinkInfoBean> querResult = new QueryResult<LinkInfoBean>(totalDataCount, searchLinkInfoBean.getPageSize(), searchLinkInfoBean.getPageNumber());
        searchLinkInfoBean.setStartIndex(querResult.getIndexNumber());
        searchLinkInfoBean.setMaxCount(querResult.getPageSize());
        @SuppressWarnings("unchecked")
        List<LinkInfo> linkInfoList = getSqlMapClientTemplate().queryForList("getLinkInfoList", searchLinkInfoBean);
        querResult.setDatas(this.toBeanList(linkInfoList));
        return querResult;
    }

    /*
     * list转换
     */
    private List<LinkInfoBean> toBeanList(List<LinkInfo> list){
        List<LinkInfoBean> result = null;
        if(null != list){
            result = new ArrayList<LinkInfoBean>();
            for (LinkInfo linkInfo : list) {
                LinkInfoBean linkInfoBean = new LinkInfoBean();
                BeanUtil.copyProperties(linkInfoBean, linkInfo);
                result.add(linkInfoBean);
            }
        }
        return result;
    }
    
}
