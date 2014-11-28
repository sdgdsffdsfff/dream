/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: InfoAd.java
 */
package com.izpzp.mash.entity;

import java.io.Serializable;

/**
 * 实体类DTO518信息广告表   
 * 
 */
public class InfoAd implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 广告id 广告id
     */
    private Integer adId;
    /**
     * 类目编码 类目编码
     */
    private String categoryCode;
    /**
     * 图片链接 图片链接
     */
    private String imgUrl;
    /**
     * 目标链接 目标链接
     */
    private String targetUrl;
    /**
     * 广告描述 广告描述
     */
    private String adDesc;
    /**
     * 广告标题 广告标题
     */
    private String adTitle;
    /**
     * 广告位置 广告位置
     */
    private Integer adLocation;
    /**
     * 展示标识 展示标识
     */
    private Integer adShowFlag;
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
     * Get adId
     * 
     * @return adId
     */
    public Integer getAdId() {
        return this.adId;
    }

    /**
     * Set adId
     * 
     * @param adId 广告id
     */

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    /**
     * Get categoryCode
     * 
     * @return categoryCode
     */
    public String getCategoryCode() {
        return this.categoryCode;
    }

    /**
     * Set categoryCode
     * 
     * @param categoryCode 类目编码
     */

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * Get imgUrl
     * 
     * @return imgUrl
     */
    public String getImgUrl() {
        return this.imgUrl;
    }

    /**
     * Set imgUrl
     * 
     * @param imgUrl 图片链接
     */

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * Get targetUrl
     * 
     * @return targetUrl
     */
    public String getTargetUrl() {
        return this.targetUrl;
    }

    /**
     * Set targetUrl
     * 
     * @param targetUrl 目标链接
     */

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    /**
     * Get adDesc
     * 
     * @return adDesc
     */
    public String getAdDesc() {
        return this.adDesc;
    }

    /**
     * Set adDesc
     * 
     * @param adDesc 广告描述
     */

    public void setAdDesc(String adDesc) {
        this.adDesc = adDesc;
    }

    /**
     * Get adTitle
     * 
     * @return adTitle
     */
    public String getAdTitle() {
        return this.adTitle;
    }

    /**
     * Set adTitle
     * 
     * @param adTitle 广告标题
     */

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    /**
     * Get adLocation
     * 
     * @return adLocation
     */
    public Integer getAdLocation() {
        return this.adLocation;
    }

    /**
     * Set adLocation
     * 
     * @param adLocation 广告位置
     */

    public void setAdLocation(Integer adLocation) {
        this.adLocation = adLocation;
    }

    /**
     * Get adShowFlag
     * 
     * @return adShowFlag
     */
    public Integer getAdShowFlag() {
        return this.adShowFlag;
    }

    /**
     * Set adShowFlag
     * 
     * @param adShowFlag 展示标识
     */

    public void setAdShowFlag(Integer adShowFlag) {
        this.adShowFlag = adShowFlag;
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
