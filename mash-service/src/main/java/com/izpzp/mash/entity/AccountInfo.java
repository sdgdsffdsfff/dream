/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: AccountInfo.java
 */
package com.izpzp.mash.entity;

import java.io.Serializable;

/**
 * 实体类DTO微信上墙-开发账号信息   
 * 
 */
public class AccountInfo implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 序号ID 序号ID
     */
    private Integer mpId;
    /**
     * TOKEN TOKEN
     */
    private String token;
    /**
     * 微信号 微信号
     */
    private String wechatCode;
    /**
     * 调用接口凭证 调用接口凭证
     */
    private String accessToken;
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
     * Get accessToken
     * 
     * @return accessToken
     */
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     * Set accessToken
     * 
     * @param accessToken 调用接口凭证
     */

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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
