/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: MsgDaoImpl.java
 * Author:   izpzp
 * Date:     2014-11-17 下午10:00:41
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.izpzp.mash.intf.MsgDao;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.MsgBean;
import com.izpzp.mash.intf.weixin.dto.SearchMsgBean;
import com.izpzp.mash.service.dao.BaseDao;

/**
 * 微信上墙-用户消息<br> 
 * 微信上墙-用户消息
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class MsgDaoImpl extends BaseDao implements MsgDao {

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MsgDao#addMsg(com.izpzp.mash.intf.weixin.dto.MsgBean)
     */
    public boolean addMsg(MsgBean msgBean) {
        getSqlMapClientTemplate().insert("insertMsg", msgBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MsgDao#updateMsg(com.izpzp.mash.intf.weixin.dto.MsgBean)
     */
    public boolean updateMsg(MsgBean msgBean) {
        getSqlMapClientTemplate().update("updateMsg", msgBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MsgDao#delMsg(java.lang.Integer)
     */
    public boolean delMsg(Integer msgId) {
        getSqlMapClientTemplate().delete("deleteMsg", msgId);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MsgDao#getMsg(java.lang.Integer)
     */
    public MsgBean getMsg(Integer msgId) {
        MsgBean msgBean = (MsgBean) getSqlMapClientTemplate().queryForObject("getMsgObject", msgId);
        return msgBean;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MsgDao#getMsgList(com.izpzp.mash.intf.weixin.dto.SearchMsgBean)
     */
    public List<MsgBean> getMsgList(SearchMsgBean searchMsgBean) {
        @SuppressWarnings("unchecked")
        List<MsgBean> msgList = getSqlMapClientTemplate().queryForList("getMsgList", searchMsgBean);
        return msgList;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MsgDao#getMsgs(com.izpzp.mash.intf.weixin.dto.SearchMsgBean)
     */
    public QueryResult<MsgBean> getMsgs(SearchMsgBean searchMsgBean) {
        int totalDataCount = this.getMstCount(searchMsgBean);
        QueryResult<MsgBean> querResult = new QueryResult<MsgBean>(totalDataCount, searchMsgBean.getPageSize(), searchMsgBean.getPageNumber());
        searchMsgBean.setStartIndex(querResult.getIndexNumber());
        searchMsgBean.setMaxCount(querResult.getPageSize());
        List<MsgBean> msgList = this.getMsgList(searchMsgBean);
        querResult.setDatas(msgList);
        return querResult;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MsgDao#updateMsgExt(com.izpzp.mash.intf.weixin.dto.MsgBean)
     */
    public boolean updateMsgExt(MsgBean msgBean) {
        getSqlMapClientTemplate().update("updateMsgExt", msgBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MsgDao#getMstCount(com.izpzp.mash.intf.weixin.dto.SearchMsgBean)
     */
    public Integer getMstCount(SearchMsgBean searchMsgBean) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getMsgCounts", searchMsgBean);
        return totalDataCount;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.MsgDao#getUserCount(com.izpzp.mash.intf.weixin.dto.SearchMsgBean)
     */
    public Integer getUserCount(SearchMsgBean searchMsgBean) {
        int totalDataCount = (Integer) getSqlMapClientTemplate().queryForObject("getMsgExtCounts", searchMsgBean);
        return totalDataCount;
    }

}
