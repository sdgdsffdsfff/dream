/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: Act.java
 */
package com.izpzp.mash.entity;

import java.io.Serializable;

/**
 * 实体类DTO微信上墙-活动信息表   
 * 
 */
public class Act implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 活动ID 活动ID
     */
    private Integer actId;
    /**
     * 序号ID 序号ID
     */
    private Integer mpId;
    /**
     * 微信号 微信号
     */
    private String wechatCode;
    /**
     * TOKEN TOKEN
     */
    private String token;
    /**
     * 活动名称 活动名称
     */
    private String actName;
    /**
     * 活动LOGO 活动LOGO
     */
    private String actLogo;
    /**
     * 活动背景图 活动背景图
     */
    private String actBacImg;
    /**
     * 活动公共账号二维码图 活动公共账号二维码图
     */
    private String mpQrImg;
    /**
     * 关键词 关键词 
     */
    private String topKeys;
    /**
     * 审核标识 审核标识
     */
    private Integer checkFlag;
    /**
     * 活动上线标识 活动上线标识
     */
    private Integer actOnFlag;
    /**
     * 活动开始时间 活动开始时间
     */
    private java.util.Date actStartTime;
    /**
     * 活动结束时间 活动结束时间
     */
    private java.util.Date actEndTime;
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
     * Get mpId
     * 
     * @return mpId
     */
    public Integer getMpId() {
        return this.mpId;
    }

    /**
     * Set mpId
     * 
     * @param mpId 序号ID
     */

    public void setMpId(Integer mpId) {
        this.mpId = mpId;
    }

    /**
     * Get wechatCode
     * 
     * @return wechatCode
     */
    public String getWechatCode() {
        return this.wechatCode;
    }

    /**
     * Set wechatCode
     * 
     * @param wechatCode 微信号
     */

    public void setWechatCode(String wechatCode) {
        this.wechatCode = wechatCode;
    }

    /**
     * Get token
     * 
     * @return token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * Set token
     * 
     * @param token TOKEN
     */

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Get actName
     * 
     * @return actName
     */
    public String getActName() {
        return this.actName;
    }

    /**
     * Set actName
     * 
     * @param actName 活动名称
     */

    public void setActName(String actName) {
        this.actName = actName;
    }

    /**
     * Get actLogo
     * 
     * @return actLogo
     */
    public String getActLogo() {
        return this.actLogo;
    }

    /**
     * Set actLogo
     * 
     * @param actLogo 活动LOGO
     */

    public void setActLogo(String actLogo) {
        this.actLogo = actLogo;
    }

    /**
     * Get actBacImg
     * 
     * @return actBacImg
     */
    public String getActBacImg() {
        return this.actBacImg;
    }

    /**
     * Set actBacImg
     * 
     * @param actBacImg 活动背景图
     */

    public void setActBacImg(String actBacImg) {
        this.actBacImg = actBacImg;
    }

    /**
     * Get mpQrImg
     * 
     * @return mpQrImg
     */
    public String getMpQrImg() {
        return this.mpQrImg;
    }

    /**
     * Set mpQrImg
     * 
     * @param mpQrImg 活动公共账号二维码图
     */

    public void setMpQrImg(String mpQrImg) {
        this.mpQrImg = mpQrImg;
    }

    /**
     * Get topKeys
     * 
     * @return topKeys
     */
    public String getTopKeys() {
        return this.topKeys;
    }

    /**
     * Set topKeys
     * 
     * @param topKeys 关键词
     */

    public void setTopKeys(String topKeys) {
        this.topKeys = topKeys;
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
     * @param checkFlag 审核标识
     */

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }

    /**
     * Get actOnFlag
     * 
     * @return actOnFlag
     */
    public Integer getActOnFlag() {
        return this.actOnFlag;
    }

    /**
     * Set actOnFlag
     * 
     * @param actOnFlag 活动上线标识
     */

    public void setActOnFlag(Integer actOnFlag) {
        this.actOnFlag = actOnFlag;
    }

    /**
     * Get actStartTime
     * 
     * @return actStartTime
     */
    public java.util.Date getActStartTime() {
        return this.actStartTime;
    }

    /**
     * Set actStartTime
     * 
     * @param actStartTime 活动开始时间
     */

    public void setActStartTime(java.util.Date actStartTime) {
        this.actStartTime = actStartTime;
    }

    /**
     * Get actEndTime
     * 
     * @return actEndTime
     */
    public java.util.Date getActEndTime() {
        return this.actEndTime;
    }

    /**
     * Set actEndTime
     * 
     * @param actEndTime 活动结束时间
     */

    public void setActEndTime(java.util.Date actEndTime) {
        this.actEndTime = actEndTime;
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
