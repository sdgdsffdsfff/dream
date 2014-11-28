/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: Winning.java
 */
package com.izpzp.mash.entity;

import java.io.Serializable;

/**
 * 实体类DTO微信上墙-公众中奖表   
 * 
 */
public class Winning implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 中奖ID 中奖ID
     */
    private Integer winId;
    /**
     * 用户编码 用户编码
     */
    private String openId;
    /**
     * 奖品ID 奖品ID
     */
    private Integer awardId;
    /**
     * 活动ID 活动ID
     */
    private Integer actId;
    /**
     * 领奖标志 领奖标志
     */
    private Integer bingoFlag;
    /**
     * 领奖编码 领奖编码
     */
    private String bingoCode;
    /**
     * 领奖人姓名 领奖人姓名
     */
    private String bingoName;
    /**
     * 领奖人手机号码 领奖人手机号码
     */
    private String bingoTel;
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
     * Get winId
     * 
     * @return winId
     */
    public Integer getWinId() {
        return this.winId;
    }

    /**
     * Set winId
     * 
     * @param winId 中奖ID
     */

    public void setWinId(Integer winId) {
        this.winId = winId;
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
     * Get awardId
     * 
     * @return awardId
     */
    public Integer getAwardId() {
        return this.awardId;
    }

    /**
     * Set awardId
     * 
     * @param awardId 奖品ID
     */

    public void setAwardId(Integer awardId) {
        this.awardId = awardId;
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
     * Get bingoFlag
     * 
     * @return bingoFlag
     */
    public Integer getBingoFlag() {
        return this.bingoFlag;
    }

    /**
     * Set bingoFlag
     * 
     * @param bingoFlag 领奖标志
     */

    public void setBingoFlag(Integer bingoFlag) {
        this.bingoFlag = bingoFlag;
    }

    /**
     * Get bingoCode
     * 
     * @return bingoCode
     */
    public String getBingoCode() {
        return this.bingoCode;
    }

    /**
     * Set bingoCode
     * 
     * @param bingoCode 领奖编码
     */

    public void setBingoCode(String bingoCode) {
        this.bingoCode = bingoCode;
    }

    /**
     * Get bingoName
     * 
     * @return bingoName
     */
    public String getBingoName() {
        return this.bingoName;
    }

    /**
     * Set bingoName
     * 
     * @param bingoName 领奖人姓名
     */

    public void setBingoName(String bingoName) {
        this.bingoName = bingoName;
    }

    /**
     * Get bingoTel
     * 
     * @return bingoTel
     */
    public String getBingoTel() {
        return this.bingoTel;
    }

    /**
     * Set bingoTel
     * 
     * @param bingoTel 领奖人手机号码
     */

    public void setBingoTel(String bingoTel) {
        this.bingoTel = bingoTel;
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
