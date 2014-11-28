/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: Award.java
 */
package com.izpzp.mash.intf.weixin.dto;

import java.io.Serializable;

/**
 * 实体类DTO微信上墙-奖品信息表   
 * 
 */
public class AwardBean implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 奖品ID 奖品ID
     */
    private Integer awardId;
    /**
     * 活动ID 活动ID
     */
    private Integer actId;
    /**
     * 奖品名称 奖品名称
     */
    private String awardName;
    /**
     * 奖品等级 奖品等级
     */
    private Integer awardLevel;
    /**
     * 奖品内容 奖品内容
     */
    private String awardCont;
    /**
     * 奖品图片 奖品图片
     */
    private String awardImg;
    /**
     * 奖品数量 奖品数量
     */
    private Integer awardNum;
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
     * Get awardName
     * 
     * @return awardName
     */
    public String getAwardName() {
        return this.awardName;
    }

    /**
     * Set awardName
     * 
     * @param awardName 奖品名称
     */

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    /**
     * Get awardLevel
     * 
     * @return awardLevel
     */
    public Integer getAwardLevel() {
        return this.awardLevel;
    }

    /**
     * Set awardLevel
     * 
     * @param awardLevel 奖品等级
     */

    public void setAwardLevel(Integer awardLevel) {
        this.awardLevel = awardLevel;
    }

    /**
     * Get awardCont
     * 
     * @return awardCont
     */
    public String getAwardCont() {
        return this.awardCont;
    }

    /**
     * Set awardCont
     * 
     * @param awardCont 奖品内容
     */

    public void setAwardCont(String awardCont) {
        this.awardCont = awardCont;
    }

    /**
     * Get awardImg
     * 
     * @return awardImg
     */
    public String getAwardImg() {
        return this.awardImg;
    }

    /**
     * Set awardImg
     * 
     * @param awardImg 奖品图片
     */

    public void setAwardImg(String awardImg) {
        this.awardImg = awardImg;
    }

    /**
     * Get awardNum
     * 
     * @return awardNum
     */
    public Integer getAwardNum() {
        return this.awardNum;
    }

    /**
     * Set awardNum
     * 
     * @param awardNum 奖品数量
     */

    public void setAwardNum(Integer awardNum) {
        this.awardNum = awardNum;
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
