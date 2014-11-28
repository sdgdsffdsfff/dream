/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: MashInfo.java
 */
package com.izpzp.mash.intf.dto;

import java.io.Serializable;

/**
 * 实体类DTOMash信息表   
 * 
 */
public class MashInfoBean implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * mashId 唯一标示id
     */
    private Integer mashId;
    /**
     * 基础分数 基础-初始化分数
     */
    private Long baseValue;
    /**
     * 比较分数 比较中的分值
     */
    private Long mashValue;
    /**
     * mash活动id mash活动id
     */
    private Integer mashActId;
    /**
     * mash内容 比较的内容
     */
    private String mashContent;
    /**
     * 用户id 用户id
     */
    private Integer userId;
    /**
     * 用户名称 用户名称
     */
    private String userName;
    /**
     * 比较次数 比较次数
     */
    private Integer mashNum;
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
     * Get mashId
     * 
     * @return mashId
     */
    public Integer getMashId() {
        return this.mashId;
    }

    /**
     * Set mashId
     * 
     * @param mashId mashId
     */

    public void setMashId(Integer mashId) {
        this.mashId = mashId;
    }

    /**
     * Get baseValue
     * 
     * @return baseValue
     */
    public Long getBaseValue() {
        return this.baseValue;
    }

    /**
     * Set baseValue
     * 
     * @param baseValue 基础分数
     */

    public void setBaseValue(Long baseValue) {
        this.baseValue = baseValue;
    }

    /**
     * Get mashValue
     * 
     * @return mashValue
     */
    public Long getMashValue() {
        return this.mashValue;
    }

    /**
     * Set mashValue
     * 
     * @param mashValue 比较分数
     */

    public void setMashValue(Long mashValue) {
        this.mashValue = mashValue;
    }

    /**
     * Get mashActId
     * 
     * @return mashActId
     */
    public Integer getMashActId() {
        return this.mashActId;
    }

    /**
     * Set mashActId
     * 
     * @param mashActId mash活动id
     */

    public void setMashActId(Integer mashActId) {
        this.mashActId = mashActId;
    }

    /**
     * Get mashContent
     * 
     * @return mashContent
     */
    public String getMashContent() {
        return this.mashContent;
    }

    /**
     * Set mashContent
     * 
     * @param mashContent mash内容
     */

    public void setMashContent(String mashContent) {
        this.mashContent = mashContent;
    }

    /**
     * Get userId
     * 
     * @return userId
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * Set userId
     * 
     * @param userId 用户id
     */

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Get userName
     * 
     * @return userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Set userName
     * 
     * @param userName 用户名称
     */

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get mashNum
     * 
     * @return mashNum
     */
    public Integer getMashNum() {
        return this.mashNum;
    }

    /**
     * Set mashNum
     * 
     * @param mashNum 比较次数
     */

    public void setMashNum(Integer mashNum) {
        this.mashNum = mashNum;
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
