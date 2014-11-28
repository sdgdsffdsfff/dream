/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: InfoType.java
 */
package com.izpzp.mash.entity;

import java.io.Serializable;

/**
 * 实体类DTO518信息类型表   
 * 
 */
public class InfoType implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 类型id 类目id
     */
    private Integer typeId;
    /**
     * 类目编码 类目编码
     */
    private String categoryCode;
    /**
     * 类型名称 类型名称
     */
    private String typeName;
    /**
     * 标题显示 标题显示
     */
    private String typeInfoTitleLable;
    /**
     * 信息值显示 信息值显示
     */
    private String typeInfoValueLable;
    /**
     * 信息描述显示 信息描述显示
     */
    private String typeInfoDescLable;
    /**
     * 信息类型备注 信息类型备注
     */
    private String typeInfoRemark;
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
     * Get typeId
     * 
     * @return typeId
     */
    public Integer getTypeId() {
        return this.typeId;
    }

    /**
     * Set typeId
     * 
     * @param typeId 类型id
     */

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
     * Get typeName
     * 
     * @return typeName
     */
    public String getTypeName() {
        return this.typeName;
    }

    /**
     * Set typeName
     * 
     * @param typeName 类型名称
     */

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * Get typeInfoTitleLable
     * 
     * @return typeInfoTitleLable
     */
    public String getTypeInfoTitleLable() {
        return this.typeInfoTitleLable;
    }

    /**
     * Set typeInfoTitleLable
     * 
     * @param typeInfoTitleLable 标题显示
     */

    public void setTypeInfoTitleLable(String typeInfoTitleLable) {
        this.typeInfoTitleLable = typeInfoTitleLable;
    }

    /**
     * Get typeInfoValueLable
     * 
     * @return typeInfoValueLable
     */
    public String getTypeInfoValueLable() {
        return this.typeInfoValueLable;
    }

    /**
     * Set typeInfoValueLable
     * 
     * @param typeInfoValueLable 信息值显示
     */

    public void setTypeInfoValueLable(String typeInfoValueLable) {
        this.typeInfoValueLable = typeInfoValueLable;
    }

    /**
     * Get typeInfoDescLable
     * 
     * @return typeInfoDescLable
     */
    public String getTypeInfoDescLable() {
        return this.typeInfoDescLable;
    }

    /**
     * Set typeInfoDescLable
     * 
     * @param typeInfoDescLable 信息描述显示
     */

    public void setTypeInfoDescLable(String typeInfoDescLable) {
        this.typeInfoDescLable = typeInfoDescLable;
    }

    /**
     * Get typeInfoRemark
     * 
     * @return typeInfoRemark
     */
    public String getTypeInfoRemark() {
        return this.typeInfoRemark;
    }

    /**
     * Set typeInfoRemark
     * 
     * @param typeInfoRemark 信息类型备注
     */

    public void setTypeInfoRemark(String typeInfoRemark) {
        this.typeInfoRemark = typeInfoRemark;
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
