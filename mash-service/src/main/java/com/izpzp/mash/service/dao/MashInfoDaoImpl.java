/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: MashInfoDaoImpl.java
 * Author:   izpzp
 * Date:     2014-11-5 上午11:31:41
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izpzp.mash.entity.MashInfo;
import com.izpzp.mash.intf.MashInfoDao;
import com.izpzp.mash.intf.dto.MashInfoBean;
import com.izpzp.mash.util.BeanUtil;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class MashInfoDaoImpl extends BaseDao implements MashInfoDao {

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MashInfoDao#getMashInfo(java.lang.Integer)
     */
    public MashInfoBean getMashInfo(Integer mashId) {
        MashInfo mashInfo = (MashInfo) getSqlMapClientTemplate().queryForObject("getMashInfoObject", mashId);
        MashInfoBean result = null;
        if(null != mashInfo){
            result = new MashInfoBean();  
            BeanUtil.copyProperties(result, mashInfo);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MashInfoDao#getMashRandom()
     */
    public List<MashInfoBean> getMashRandom() {
        @SuppressWarnings("unchecked")
        List<MashInfo> mashList = getSqlMapClientTemplate().queryForList("getMashRand2List");
        return this.toBeanList(mashList);
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MashInfoDao#updateMashInfo(java.lang.Integer)
     */
    public void updateMashInfo(MashInfoBean mashInfoBean) {
        MashInfo mashInfo = new MashInfo();
        if(null != mashInfoBean){
            BeanUtil.copyProperties(mashInfo, mashInfoBean);
            getSqlMapClientTemplate().update("updateMashInfo", mashInfo);
        }
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MashInfoDao#getMashSort()
     */
    public List<MashInfoBean> getMashSort() {
        @SuppressWarnings("unchecked")
        List<MashInfo> mashList = getSqlMapClientTemplate().queryForList("getMashSort");
        return this.toBeanList(mashList);
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MashInfoDao#getNewMashSort()
     */
    public List<MashInfoBean> getNewMashSort() {
        @SuppressWarnings("unchecked")
        List<MashInfo> mashList = getSqlMapClientTemplate().queryForList("getNewMashSort");
        return this.toBeanList(mashList);
    }
    
    /*
     * list转换
     */
    private List<MashInfoBean> toBeanList(List<MashInfo> mashList){
        List<MashInfoBean> result = null;
        if(null != mashList){
            result = new ArrayList<MashInfoBean>();
            for (MashInfo mashInfo : mashList) {
                MashInfoBean mashInfoBean = new MashInfoBean();
                BeanUtil.copyProperties(mashInfoBean, mashInfo);
                result.add(mashInfoBean);
            }
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MashInfoDao#insertMashInfo()
     */
    public void insertMashInfo(MashInfoBean mashInfobean) {
        MashInfo mashInfo = new MashInfo();
        if(null != mashInfobean){
            BeanUtil.copyProperties(mashInfo, mashInfobean);
            getSqlMapClientTemplate().insert("insertMashInfo", mashInfo);
        }
    }

}
