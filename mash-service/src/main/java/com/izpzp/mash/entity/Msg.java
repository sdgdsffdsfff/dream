/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: Msg.java
 */
package com.izpzp.mash.entity;

import java.io.Serializable;

/**
 * 实体类DTO微信上墙-公众消息表   
 * 
 */
public class Msg implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 消息ID 消息ID
     */
    private Integer msgId;
    /**
     * 用户编码 用户编码
     */
    private String openId;
    /**
     * 活动ID 活动ID
     */
    private Integer actId;
    /**
     * 消息内容 消息内容
     */
    private String msgContext;
    /**
     * 审核标志 审核标志
     */
    private Integer checkFlag;
    /**
     * 上墙标志 上墙标志
     */
    private Integer showFlag;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 更新者
     */
    private String updater;
    /**
     * 创建时间
     */
    private java.util.Date createDttm = new java.util.Date();;
    /**
     * 更新时间
     */
    private java.util.Date updateDttm = new java.util.Date();;

    /**
     * Get msgId
     * 
     * @return msgId
     */
    public Integer getMsgId() {
        return this.msgId;
    }

    /**
     * Set msgId
     * 
     * @param msgId 消息ID
     */

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    /**
     * Get openId
     * 
     * @return openId
     */
    public String getOpenId() {
        return this.openId;
    }

    /**
     * Set openId
     * 
     * @param openId 用户编码
     */

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * Get actId
     * 
     * @return actId
     */
    public Integer getActId() {
        return this.actId;
    }

    /**
     * Set actId
     * 
     * @param actId 活动ID
     */

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    /**
     * Get msgContext
     * 
     * @return msgContext
     */
    public String getMsgContext() {
        return this.msgContext;
    }

    /**
     * Set msgContext
     * 
     * @param msgContext 消息内容
     */

    public void setMsgContext(String msgContext) {
        this.msgContext = msgContext;
    }

    /**
     * Get checkFlag
     * 
     * @return checkFlag
     */
    public Integer getCheckFlag() {
        return this.checkFlag;
    }

    /**
     * Set checkFlag
     * 
     * @param checkFlag 审核标志
     */

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }

    /**
     * Get showFlag
     * 
     * @return showFlag
     */
    public Integer getShowFlag() {
        return this.showFlag;
    }

    /**
     * Set showFlag
     * 
     * @param showFlag 上墙标志
     */

    public void setShowFlag(Integer showFlag) {
        this.showFlag = showFlag;
    }


    /**
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return the updater
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * @param updater the updater to set
     */
    public void setUpdater(String updater) {
        this.updater = updater;
    }

 	/**
     * @return the createDttm
     */
    public java.util.Date getCreateDttm() {
        return createDttm;
    }

    /**
     * @param createDttm the createDttm to set
     */
    public void setCreateDttm(java.util.Date createDttm) {
        this.createDttm = createDttm;
    }

    /**
     * @return the updateDttm
     */
    public java.util.Date getUpdateDttm() {
        return updateDttm;
    }

    /**
     * @param updateDttm the updateDttm to set
     */
    public void setUpdateDttm(java.util.Date updateDttm) {
        this.updateDttm = updateDttm;
    }
}
