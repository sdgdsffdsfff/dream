/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: InfoCategory.java
 */
package com.izpzp.mash.intf.dto;

import java.io.Serializable;

/**
 * 实体类DTO518信息类目表   
 * 
 */
public class InfoCategoryBean implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 类目id 类目id
     */
    private Integer categoryId;
    /**
     * 类目编码 类目编码
     */
    private String categoryCode;
    /**
     * 类目名称 类目名称
     */
    private String categoryName;
    /**
     * 类目链接 类目链接
     */
    private String categoryUrl;
    /**
     * 类目图片 类目图片
     */
    private String categoryImgUrl;
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
     * Get categoryId
     * 
     * @return categoryId
     */
    public Integer getCategoryId() {
        return this.categoryId;
    }

    /**
     * Set categoryId
     * 
     * @param categoryId 类目id
     */

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
     * Get categoryName
     * 
     * @return categoryName
     */
    public String getCategoryName() {
        return this.categoryName;
    }

    /**
     * Set categoryName
     * 
     * @param categoryName 类目名称
     */

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Get categoryUrl
     * 
     * @return categoryUrl
     */
    public String getCategoryUrl() {
        return this.categoryUrl;
    }

    /**
     * Set categoryUrl
     * 
     * @param categoryUrl 类目链接
     */

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    /**
     * Get categoryImgUrl
     * 
     * @return categoryImgUrl
     */
    public String getCategoryImgUrl() {
        return this.categoryImgUrl;
    }

    /**
     * Set categoryImgUrl
     * 
     * @param categoryImgUrl 类目图片
     */

    public void setCategoryImgUrl(String categoryImgUrl) {
        this.categoryImgUrl = categoryImgUrl;
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
