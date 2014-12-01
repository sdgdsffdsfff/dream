/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: WeiXinServiceImpl.java
 * Author:   13075787
 * Date:     2014-11-17 下午4:25:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izpzp.mash.constants.NJ518Constants;
import com.izpzp.mash.intf.AccountInfoDao;
import com.izpzp.mash.intf.ActDao;
import com.izpzp.mash.intf.MsgDao;
import com.izpzp.mash.intf.WinningDao;
import com.izpzp.mash.intf.weixin.dto.AcceptMsg;
import com.izpzp.mash.intf.weixin.dto.AccountInfoBean;
import com.izpzp.mash.intf.weixin.dto.ActBean;
import com.izpzp.mash.intf.weixin.dto.AwardBean;
import com.izpzp.mash.intf.weixin.dto.MsgBean;
import com.izpzp.mash.intf.weixin.dto.ResponseMsg;
import com.izpzp.mash.intf.weixin.dto.SearchActBean;
import com.izpzp.mash.intf.weixin.dto.SearchAwardBean;
import com.izpzp.mash.intf.weixin.dto.SearchWinningBean;
import com.izpzp.mash.intf.weixin.dto.WinningBean;
import com.izpzp.mash.util.XStreamUtil;
import com.izpzp.mash.weixin.constants.Constants;
import com.izpzp.mash.weixin.intf.ShowTheWorldAdminService;
import com.izpzp.mash.weixin.intf.WeiXinService;
import com.thoughtworks.xstream.XStream;

/**
 * 微信服务接口<br> 
 * 微信服务接口
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class WeiXinServiceImpl implements WeiXinService {
    
    @Autowired
    AccountInfoDao accountInfoDao;
    
    @Autowired
    ActDao actDao;
    
    @Autowired
    MsgDao msgDao;
    
    @Autowired
    WinningDao winningDao;
    
    @Autowired
    ShowTheWorldAdminService showTheWorldAdminService;
    
    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.WeiXinService#acceptMsg(java.lang.String)
     */
    public String acceptMsg(String xml) {
        String result = Constants.FAIL;
        //检查xml内容不为空
        if(StringUtils.isNotBlank(xml)){
            AcceptMsg acceptMsg = (AcceptMsg)XStreamUtil.xmlToBean(xml, AcceptMsg.class);
            result = this.whatToDo(acceptMsg);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.WeiXinService#showTheWorld(com.izpzp.mash.intf.weixin.dto.AcceptMsg)
     */
    public String showTheWorld(MsgBean msgBean) {
        String result = Constants.FAIL;
        if(null != msgBean){
            msgDao.addMsg(msgBean);
            //消息发送成功
            result = Constants.SUCCESS;
        }
        return result;
    }

    /**
     * 功能描述: <br>
     * 检查该信息应该做什么处理
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String whatToDo(AcceptMsg acceptMsg){
        String result = Constants.FAIL;
        if(null != acceptMsg){
            if(StringUtils.isNotBlank(acceptMsg.getToUserName())){
                //活动Id
                Integer actId = null;
                Integer checkFlag = null;
                //根据开发号搜索出当前的活动-及关键词
                SearchActBean searchActBean = new SearchActBean();
                searchActBean.setWechatCode(acceptMsg.getToUserName());
                searchActBean.setPageSize(NJ518Constants.MAX_NUM);
                searchActBean.setActOnFlag(Constants.NUM_1);
                List<ActBean> actList = actDao.getActList(searchActBean);
                boolean flag = false;
                //若发布内容中包含有关键词则进行上墙
                if(null != actList && NJ518Constants.NUM_0 < actList.size()){
                    for (ActBean actBean : actList) {
                        //包含该关键字
                        if(acceptMsg.getContent().indexOf(actBean.getTopKeys()) > NJ518Constants.NUM_NEGATIVE_1){
                            actId = actBean.getActId();
                            checkFlag = actBean.getCheckFlag();
                            //上墙
                            MsgBean msgBean = new MsgBean();
                            msgBean.setActId(actId);
                            msgBean.setCheckFlag(checkFlag);
                            msgBean.setOpenId(acceptMsg.getFromUserName());
                            msgBean.setMsgContext(acceptMsg.getContent());
                            //信息上墙标志-默认未上墙
                            msgBean.setShowFlag(Constants.NUM_0);
                            result = this.showTheWorld(msgBean);
                            //标记已上墙
                            flag = true;
                            //回复感谢参加活动-有惊喜发现
                            ResponseMsg responseMsg = new ResponseMsg();
                            responseMsg.setToUserName(acceptMsg.getToUserName());
                            responseMsg.setFromUserName(acceptMsg.getFromUserName());
                            responseMsg.setCreateTime((int)new Date().getTime());
                            responseMsg.setMsgType("text");
                            responseMsg.setContent("感谢您参加("+actBean.getActName()+")活动，请继续关注，后面还有小礼品和惊喜等着您！");
                            result = this.getResponse(responseMsg);
                            break;
                        }
                    }
                    //若未集中上墙活动-则回复该活动的描述与规则
                    if(!flag){
                        if(acceptMsg.getContent().equals(Constants.I_BINGO)){
                            String openId = acceptMsg.getFromUserName();
                            WinningBean winningBean = null;
                            SearchWinningBean searchWinningBean = new SearchWinningBean();
                            searchWinningBean.setOpenId(openId);
                            searchWinningBean.setBingoFlag(Constants.NUM_0);
                            List<WinningBean> winningList = winningDao.getWinningList(searchWinningBean);
                            if(null != winningList && Constants.NUM_0 < winningList.size()){
                                winningBean = winningList.get(Constants.NUM_0);
                            }
                            //回复中奖消息
                            ResponseMsg responseMsg = new ResponseMsg();
                            responseMsg.setToUserName(acceptMsg.getToUserName());
                            responseMsg.setFromUserName(acceptMsg.getFromUserName());
                            responseMsg.setCreateTime((int)new Date().getTime());
                            responseMsg.setMsgType("text");
                            if(null != winningBean){
                                SearchAwardBean searchAwardBean = new SearchAwardBean();
                                searchAwardBean.setActId(winningBean.getActId());
                                searchAwardBean.setAwardId(winningBean.getAwardId());
                                AwardBean awardBean = showTheWorldAdminService.getAward(searchAwardBean);
                                responseMsg.setContent("恭喜您获得" + awardBean.getAwardName()+"，奖品是"+awardBean.getAwardCont()+"，请您凭领奖码:("+winningBean.getBingoCode()+")到服务台领奖！");
                            }else{
                                responseMsg.setContent("感谢您的参与，敬请关注我们的其他相关活动！");
                            }
                            result = this.getResponse(responseMsg);
                        }else{
                            for (ActBean actBean : actList) {
                                //当存在该账号活动的时候
                                if(acceptMsg.getToUserName().equals(actBean.getWechatCode())){
                                    ResponseMsg responseMsg = new ResponseMsg();
                                    responseMsg.setToUserName(acceptMsg.getToUserName());
                                    responseMsg.setFromUserName(acceptMsg.getFromUserName());
                                    responseMsg.setCreateTime((int)new Date().getTime());
                                    responseMsg.setMsgType("text");
                                    responseMsg.setContent("欢迎关注("+actBean.getActName()+")活动，"+actBean.getActLogo());
                                    result = this.getResponse(responseMsg);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.weixin.intf.WeiXinService#getAccountInfoBean(java.lang.Integer)
     */
    public String getAccountToken(Integer mpId) {
        String result = null;
        AccountInfoBean accountInfoBean = accountInfoDao.getAccountInfo(mpId);
        if(null != accountInfoBean){
            result = accountInfoBean.getToken();
        }
        return result;
    }
    
    /**
     * 生成响应消息
     */
    private String getResponse(ResponseMsg responseMsg){
        String result = "";
        XStream xstream = XStreamUtil.initXStream(true);
        xstream.processAnnotations(ResponseMsg.class);
        result = xstream.toXML(responseMsg);
        return result;
    }
    
}
