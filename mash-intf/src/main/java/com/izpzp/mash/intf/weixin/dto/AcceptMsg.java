/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: AcceptMsg.java
 * Author:   izpzp
 * Date:     2014-11-17 上午11:53:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf.weixin.dto;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微信接受信息bean<br> 
 * 微信接受信息bean
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("xml")
public class AcceptMsg implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 开发者微信号
     */
    private String ToUserName;
    
    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;
    
    /**
     * 消息创建时间 （整型）
     */
    private Long CreateTime;
    
    /**
     * text
     */
    private String MsgType;
    
    /**
     * 文本消息内容
     */
    private String Content;
    
    /**
     * 消息id，64位整型
     */
    private String MsgId;

    /**
     * @return the toUserName
     */
    public String getToUserName() {
        return ToUserName;
    }

    /**
     * @param toUserName the toUserName to set
     */
    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    /**
     * @return the fromUserName
     */
    public String getFromUserName() {
        return FromUserName;
    }

    /**
     * @param fromUserName the fromUserName to set
     */
    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    /**
     * @return the msgType
     */
    public String getMsgType() {
        return MsgType;
    }

    /**
     * @param msgType the msgType to set
     */
    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return Content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        Content = content;
    }

    /**
     * @return the msgId
     */
    public String getMsgId() {
        return MsgId;
    }

    /**
     * @param msgId the msgId to set
     */
    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    /**
     * @return the createTime
     */
    public Long getCreateTime() {
        return CreateTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }
    
}
