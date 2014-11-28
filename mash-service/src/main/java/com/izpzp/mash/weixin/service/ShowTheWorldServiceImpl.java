/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: ShowTheWorldServiceImpl.java
 * Author:   13075787
 * Date:     2014-11-18 下午5:05:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izpzp.mash.intf.ActDao;
import com.izpzp.mash.intf.MsgDao;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.ActBean;
import com.izpzp.mash.intf.weixin.dto.MsgBean;
import com.izpzp.mash.intf.weixin.dto.MsgExtBean;
import com.izpzp.mash.intf.weixin.dto.SearchMsgBean;
import com.izpzp.mash.util.BeanUtil;
import com.izpzp.mash.util.DateUtil;
import com.izpzp.mash.weixin.constants.Constants;
import com.izpzp.mash.weixin.intf.ShowTheWorldService;

/**
 * 上墙-前端展示 <br> 
 * 上墙-前端展示
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ShowTheWorldServiceImpl implements ShowTheWorldService {
    
    @Autowired
    ActDao actDao;
    
    @Autowired
    MsgDao msgDao;
    
    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldService#getActInfo(java.lang.Integer)
     */
    public ActBean getActInfo(Integer actId) {
        ActBean result = actDao.getAct(actId);
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldService#getMsgs(java.lang.Integer, java.lang.Integer, java.lang.Integer)
     */
    public QueryResult<MsgExtBean> getMsgs(Integer actId, Integer pageIndex, Integer pageSize) {
        //获取带有用户信息的公众信息
        QueryResult<MsgExtBean> result = new QueryResult<MsgExtBean>();
        result.setPageCount(Constants.NUM_0);
        SearchMsgBean searchMsgBean = new SearchMsgBean();
        searchMsgBean.setActId(actId);
        //审核已通过
        searchMsgBean.setCheckFlag(Constants.NUM_1);
        //未展示
        searchMsgBean.setShowFlag(Constants.NUM_0);
        if(null != pageIndex){
            searchMsgBean.setPageNumber(pageIndex);
        }else{
            searchMsgBean.setPageNumber(Constants.NUM_1);
        }
        if(null != pageSize){
            searchMsgBean.setPageSize(pageSize);
        }else{
            searchMsgBean.setPageSize(Constants.WALL_MSG_SIZE);
        }
        QueryResult<MsgBean> query = msgDao.getMsgs(searchMsgBean);
        //将展示的信息-展示标识位置为-已展示
        if(null != query){
            List<MsgBean> msgList = query.getDatas();
            this.initMsgShowFlag(msgList, Constants.NUM_1);
            //获取带有用户信息的公众信息
            result = new QueryResult<MsgExtBean>();
            result.setIndexNumber(query.getIndexNumber());
            result.setIsLastPage(query.getIsLastPage());
            result.setPageCount(query.getPageCount());
            result.setPageNumber(query.getPageNumber());
            result.setPageSize(query.getPageSize());
            result.setTotalDataCount(query.getTotalDataCount());
            result.setDatas(this.fromMsgToExtList(msgList));
        }

        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldService#initMsgShowFlagStatus(java.lang.Integer)
     */
    public boolean initMsgShowFlagStatus(Integer actId) {
        //随机查询信息
        SearchMsgBean searchMsgBean = new SearchMsgBean();
        searchMsgBean.setActId(actId);
        //审核已通过
        searchMsgBean.setCheckFlag(Constants.NUM_1);
        //已展示
        searchMsgBean.setShowFlag(Constants.NUM_1);
        searchMsgBean.setStartIndex(Constants.NUM_0);
        searchMsgBean.setMaxCount(Constants.NUM_1);
        //随机取
        searchMsgBean.setOrderRand(Constants.ORDER_RAND);
        List<MsgBean> msgList = msgDao.getMsgList(searchMsgBean);
        this.initMsgShowFlag(msgList, Constants.NUM_0);
        return true;
    }
    
    /**
     * 将公众信息添加用户的个人信息
     */
    private List<MsgExtBean> fromMsgToExtList(List<MsgBean> msgList){
        List<MsgExtBean> result = null;
        if(null != msgList){
            result = new ArrayList<MsgExtBean>();
            for (MsgBean msgBean : msgList) {
                MsgExtBean msgExtBean = new MsgExtBean();
                BeanUtil.copyProperties(msgExtBean, msgBean);
                //添加头像和昵称
                String nickName = null;
                String msgContext = msgExtBean.getMsgContext();
                if(StringUtils.isNotBlank(msgContext)){
                    int indexNameBase = msgContext.indexOf(Constants.NAME_REPLACE);
                    if(indexNameBase >= Constants.NUM_0){
                        String nameBase = msgContext.substring(indexNameBase, msgContext.length());
                        //将#姓名#**过滤掉
                        msgContext = msgContext.replaceAll(nameBase, "");
                        nickName = nameBase.replaceAll(Constants.NAME_REPLACE, "");
                    }
                }
                msgExtBean.setMsgContext(msgContext);
                if(StringUtils.isNotBlank(nickName)){
                    msgExtBean.setNickname(nickName);
                }else{
                    msgExtBean.setNickname(Constants.SECRET_NAME);
                }
                //过滤时间
                msgExtBean.setMsgTime(DateUtil.getNowShortmmStr(msgBean.getCreateDttm()));
                result.add(msgExtBean);
            }
        }
        return result;
    }
    
    /**
     * 功能描述: <br>
     * 重置公众信息展示字段
     *
     * @param msgBean
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void initMsgShowFlag(List<MsgBean> msgList, Integer showFlag){
        if(null != msgList && Constants.NUM_0 < msgList.size()){
            for (MsgBean msgBean : msgList) {
                MsgBean locmsgBean = new MsgBean();
                locmsgBean.setActId(msgBean.getActId());
                locmsgBean.setMsgId(msgBean.getMsgId());
                //重置为未上墙
                locmsgBean.setShowFlag(showFlag);
                msgDao.updateMsgExt(locmsgBean);
            }
        }
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldService#getActExtInfo(java.lang.Integer)
     */
    public Map<String, Object> getActExtInfo(Integer actId) {
        Map<String, Object> result = new HashMap<String, Object>();
        int msgCounts = 0;
        int userCounts = 0;
        SearchMsgBean searchMsgBean = new SearchMsgBean();
        searchMsgBean.setActId(actId);
        msgCounts = msgDao.getMstCount(searchMsgBean);
        userCounts = msgDao.getUserCount(searchMsgBean);
        result.put("msgCounts", msgCounts);
        result.put("userCounts", userCounts);
        return result;
    }

}