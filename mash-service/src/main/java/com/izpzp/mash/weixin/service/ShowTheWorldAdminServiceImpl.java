/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: ShowTheWorldAdminServiceImpl.java
 * Author:   13075787
 * Date:     2014-11-20 下午6:02:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izpzp.mash.intf.AccountInfoDao;
import com.izpzp.mash.intf.ActDao;
import com.izpzp.mash.intf.AwardDao;
import com.izpzp.mash.intf.MsgDao;
import com.izpzp.mash.intf.WinningDao;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.AccountInfoBean;
import com.izpzp.mash.intf.weixin.dto.ActBean;
import com.izpzp.mash.intf.weixin.dto.AwardBean;
import com.izpzp.mash.intf.weixin.dto.MsgBean;
import com.izpzp.mash.intf.weixin.dto.SearchAccountInfoBean;
import com.izpzp.mash.intf.weixin.dto.SearchActBean;
import com.izpzp.mash.intf.weixin.dto.SearchAwardBean;
import com.izpzp.mash.intf.weixin.dto.SearchMsgBean;
import com.izpzp.mash.intf.weixin.dto.SearchWinningBean;
import com.izpzp.mash.intf.weixin.dto.WinningBean;
import com.izpzp.mash.util.MD5Util;
import com.izpzp.mash.weixin.constants.Constants;
import com.izpzp.mash.weixin.intf.ShowTheWorldAdminService;

/**
 * 微信上墙后台管理<br> 
 * 微信上墙后台管理-公众账号信息-活动信息-上墙信息维护-中奖规则-中奖统计<br>
 * 此类中查询条件中都必须传入 creator字段，用作用户信息鉴权
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ShowTheWorldAdminServiceImpl implements ShowTheWorldAdminService {

    @Autowired
    AccountInfoDao accountInfoDao;
    
    @Autowired
    ActDao actDao;
    
    @Autowired
    MsgDao msgDao;
    
    @Autowired
    AwardDao awardDao;
    
    @Autowired
    WinningDao winningDao;
    
    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#saveAccountInfo(com.izpzp.mash.intf.weixin.dto.AccountInfoBean)
     */
    public boolean saveAccountInfo(AccountInfoBean accountInfoBean) {
        //必须为该账号所有者
        if(null != accountInfoBean){
            if(null != accountInfoBean.getMpId()){
                 //调用更新方法
                accountInfoDao.updateAccountInfo(accountInfoBean);
            }else{
                //调用新增方法
                accountInfoDao.addAccountInfo(accountInfoBean);
            }
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#delAccountInfo(java.lang.Integer, java.lang.String)
     */
    public boolean delAccountInfo(Integer mpId, String adminUserCode) {
        if(null != mpId){
            accountInfoDao.delAccountInfo(mpId);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#getAccountInfo(com.izpzp.mash.intf.weixin.dto.SearchAccountInfoBean)
     */
    public AccountInfoBean getAccountInfo(SearchAccountInfoBean searchAccountInfoBean) {
        AccountInfoBean result = null;
        List<AccountInfoBean> accountInfoList = accountInfoDao.getAccountInfoList(searchAccountInfoBean);
        if(null != accountInfoList){
            result = accountInfoList.get(Constants.NUM_0);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#getAccountInfos(com.izpzp.mash.intf.weixin.dto.SearchAccountInfoBean)
     */
    public QueryResult<AccountInfoBean> getAccountInfos(SearchAccountInfoBean searchAccountInfoBean) {
        return accountInfoDao.getAccountInfos(searchAccountInfoBean);
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#saveAct(com.izpzp.mash.intf.weixin.dto.ActBean)
     */
    public boolean saveAct(ActBean actBean) {
        //必须为该账号所有者
        if(null != actBean){
            if(null != actBean.getActId()){
                 //调用更新方法
                actDao.updateAct(actBean);
            }else{
                //调用新增方法
                actDao.addAct(actBean);
            }
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#delAct(java.lang.Integer, java.lang.String)
     */
    public boolean delAct(Integer actId, String adminUserCode) {
        if(actId != null){
            actDao.delAct(actId);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#getAct(com.izpzp.mash.intf.weixin.dto.SearchActBean)
     */
    public ActBean getAct(SearchActBean searchActBean) {
        ActBean result = null;
        List<ActBean> actList = actDao.getActList(searchActBean);
        if(null != actList){
            result = actList.get(Constants.NUM_0);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#getActs(com.izpzp.mash.intf.weixin.dto.SearchActBean)
     */
    public QueryResult<ActBean> getActs(SearchActBean searchActBean) {
        return actDao.getActs(searchActBean);
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#saveMsg(com.izpzp.mash.intf.weixin.dto.MsgBean)
     */
    public boolean saveMsg(MsgBean msgBean) {
        //必须为该账号所有者
        if(null != msgBean && StringUtils.isNotBlank(msgBean.getCreator())){
            if(null != msgBean.getMsgId()){
                 //调用更新方法
                msgDao.updateMsg(msgBean);
            }else{
                //调用新增方法
                msgDao.addMsg(msgBean);
            }
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#delMsg(java.lang.Integer, java.lang.String)
     */
    public boolean delMsg(Integer msgId, String adminUserCode) {
        if(msgId != null){
            msgDao.delMsg(msgId);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#getMsg(com.izpzp.mash.intf.weixin.dto.SearchMsgBean)
     */
    public MsgBean getMsg(SearchMsgBean searchMsgBean) {
        MsgBean result = null;
        List<MsgBean> msgList = msgDao.getMsgList(searchMsgBean);
        if(null != msgList){
            result = msgList.get(Constants.NUM_0);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#getMsgs(com.izpzp.mash.intf.weixin.dto.SearchMsgBean)
     */
    public QueryResult<MsgBean> getMsgs(SearchMsgBean searchMsgBean) {
        return msgDao.getMsgs(searchMsgBean);
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#saveAward(com.izpzp.mash.intf.weixin.dto.AwardBean)
     */
    public boolean saveAward(AwardBean awardBean) {
        //必须为该账号所有者
        if(null != awardBean){
            if(null != awardBean.getAwardId()){
                 //调用更新方法
                awardDao.updateAward(awardBean);
            }else{
                //调用新增方法
                awardDao.addAward(awardBean);
            }
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#delAward(java.lang.Integer, java.lang.String)
     */
    public boolean delAward(Integer awardId, String adminUserCode) {
        if(null != awardId){
            awardDao.delAward(awardId);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#getAward(com.izpzp.mash.intf.weixin.dto.SearchAwardBean)
     */
    public AwardBean getAward(SearchAwardBean searchAwardBean) {
        AwardBean result = null;
        List<AwardBean> awardList = awardDao.getAwardList(searchAwardBean);
        if(null != awardList){
            result = awardList.get(Constants.NUM_0);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#getAwards(com.izpzp.mash.intf.weixin.dto.SearchAwardBean)
     */
    public QueryResult<AwardBean> getAwards(SearchAwardBean searchAwardBean) {
        return awardDao.getAwards(searchAwardBean);
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#saveWinning(com.izpzp.mash.intf.weixin.dto.WinningBean)
     */
    public boolean saveWinning(WinningBean winningBean) {
        //必须为该账号所有者
        if(null != winningBean){
            if(null != winningBean.getWinId()){
                 //调用更新方法
                winningDao.updateWinning(winningBean);
            }else{
                //调用新增方法
                winningDao.addWinning(winningBean);
            }
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#delWinning(java.lang.Integer, java.lang.String)
     */
    public boolean delWinning(Integer winId, String adminUserCode) {
        if(null != winId){
            winningDao.delWinning(winId);
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#getWinning(com.izpzp.mash.intf.weixin.dto.SearchWinningBean)
     */
    public WinningBean getWinning(SearchWinningBean searchWinningBean) {
        WinningBean result = null;
        List<WinningBean> winningList = winningDao.getWinningList(searchWinningBean);
        if(null != winningList && Constants.NUM_0 < winningList.size()){
            result = winningList.get(Constants.NUM_0);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#getWinnings()
     */
    public QueryResult<WinningBean> getWinnings(SearchWinningBean searchWinningBean) {
        return winningDao.getWinnings(searchWinningBean);
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.ShowTheWorldAdminService#binGo(java.lang.Integer)
     */
    public Map<String, Object> binGo(Integer actId, String adminUserCode) {
        Map<String, Object> result = new HashMap<String, Object>();
        if(null != actId){
            SearchAwardBean searchAwardBean = new SearchAwardBean();
            searchAwardBean.setActId(actId);
            searchAwardBean.setCreator(adminUserCode);
            List<AwardBean> awardList = awardDao.getAwardList(searchAwardBean);
            if(null != awardList){
                //按照奖品的不同等级进行抽奖
                for (AwardBean awardBean : awardList) {
                    //首先查询该奖励等级已抽取人数
                    SearchWinningBean searchWinningBean = new SearchWinningBean();
                    searchWinningBean.setActId(actId);
                    searchWinningBean.setAwardId(awardBean.getAwardId());
                    int getAwardNum = winningDao.getWinningCount(searchWinningBean);
                    //获得该等级剩余奖励名额
                    int awardUserNum = awardBean.getAwardNum() - getAwardNum;
                    //按照剩余奖励名额，进行抽奖-活动id、奖品id、抽奖人数
                    this.binGo(actId, awardBean.getAwardId(), awardUserNum, adminUserCode);
                }
            }
            result.put(Constants.SUCCESS_FLAG, true);
            result.put(Constants.TIP_MSG, "抽奖完成!");
        }else{
            //活动id不能为空
            result.put(Constants.SUCCESS_FLAG, false);
            result.put(Constants.TIP_MSG, "活动id不能为空!");
        }
        return result;
    }

    /**
     * 功能描述: <br>
     * 抽奖算法
     *
     * @param actId
     * @param awardId
     * @param awardUserNum
     * @param adminUserCode
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void binGo(Integer actId, Integer awardId, Integer awardUserNum, String adminUserCode){
        if(null != awardUserNum && Constants.NUM_0.intValue() < awardUserNum.intValue()){
            //抽取发布信息的用户
            SearchMsgBean searchMsgBean = new SearchMsgBean();
            searchMsgBean.setActId(actId);
            //审核通过的
            searchMsgBean.setCheckFlag(Constants.NUM_1);
            searchMsgBean.setOrderRand(Constants.ORDER_RAND);
            searchMsgBean.setStartIndex(Constants.NUM_0);
            searchMsgBean.setMaxCount(awardUserNum);
            //抽奖去重
            searchMsgBean.setBinGo(Constants.SUCCESS);
            searchMsgBean.setGroupOpenId(Constants.SUCCESS);
            List<MsgBean> msgList = msgDao.getMsgList(searchMsgBean);
            if(null != msgList){
                //将抽中的用户存入中奖表
                for (MsgBean msgBean : msgList) {
                    WinningBean winningBean = new WinningBean();
                    winningBean.setActId(actId);
                    winningBean.setAwardId(awardId);
                    //设置兑奖编码  
                    winningBean.setBingoCode(this.generateBingoCode(actId, msgBean.getMsgId()));
                    //未领奖
                    winningBean.setBingoFlag(Constants.NUM_0);
                    //openId
                    winningBean.setOpenId(msgBean.getOpenId());
                    winningDao.addWinning(winningBean);
                }
            }
        }
    }
    
    /*
     * 随机生成
     */
    private String generateBingoCode(Integer actId, Integer msgId){
        String result = null;
        if(null != msgId){
            while(true){
                String bingoCode = this.generateRandom8Code(actId, msgId);
                SearchWinningBean searchWinningBean = new SearchWinningBean();
                searchWinningBean.setActId(actId);
                searchWinningBean.setBingoCode(bingoCode);
                WinningBean winning = this.getWinning(searchWinningBean);
                if(null == winning || null == winning.getWinId()){
                    result = bingoCode;
                    break;
                }
            }
        }
        return result;
    }
    
    /*
     * 随机8位字符
     */
    private String generateRandom8Code(Integer actId, Integer msgId){
        String bingoCode = null;
        if(null != msgId){
            String msgIdStr = String.valueOf(msgId);
            long nowTime = System.currentTimeMillis();
            String nowStr = String.valueOf(nowTime);
            Random random = new Random(100);
            String rand = String.valueOf(random.nextInt());
            //检验生成的8位置随机码-在库中是否存在-若存在则重新生成
            String md5Str = MD5Util.MD5(msgIdStr + nowStr + rand);
            if(StringUtils.isNotBlank(md5Str) && md5Str.length() > Constants.NUM_8){
                bingoCode = md5Str.substring(Constants.NUM_0, Constants.NUM_8);
            }
        }
        return bingoCode;
    }
    
}
