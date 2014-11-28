/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: InfoBase.java
 */
package com.izpzp.mash.intf.dto;

import java.io.Serializable;

/**
 * 实体类DTO518发布信息表   
 * 
 */
public class InfoBaseBean implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 信息id 信息id
     */
    private Integer infoId;
    /**
     * 信息标题 信息标题
     */
    private String infoTitle;
    /**
     * 信息类目 信息类目
     */
    private String categoryCode;
    /**
     * 信息类型 信息类型
     */
    private Integer typeId;
    /**
     * 信息值 信息值
     */
    private String infoValue;
    /**
     * 信息描述 信息描述
     */
    private String infoDesc;
    /**
     * 信息审核标识 信息审核标识
     */
    private Integer infoCheckFlag;
    /**
     * 信息删除标识 信息删除标识
     */
    private Integer infoDelFlag;
    /**
     * 信息序值 信息序值
     */
    private Integer infoSortIndex;
    /**
     * 信息联系人 信息联系人
     */
    private String infoContact;
    /**
     * 信息联系方式 信息联系方式
     */
    private String infoTel;
    /**
     * 信息联系QQ 信息联系QQ
     */
    private String infoQq;
    /**
     * 信息联系邮箱 信息联系邮箱
     */
    private String infoMail;
    /**
     * 信息所属用户id 信息所属用户id
     */
    private Integer userId;
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
     * Get infoId
     * 
     * @return infoId
     */
    public Integer getInfoId() {
        return this.infoId;
    }

    /**
     * Set infoId
     * 
     * @param infoId 信息id
     */

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    /**
     * Get infoTitle
     * 
     * @return infoTitle
     */
    public String getInfoTitle() {
        return this.infoTitle;
    }

    /**
     * Set infoTitle
     * 
     * @param infoTitle 信息标题
     */

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
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
     * @param categoryCode 信息类目
     */

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

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
     * @param typeId 信息类型
     */

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * Get infoValue
     * 
     * @return infoValue
     */
    public String getInfoValue() {
        return this.infoValue;
    }

    /**
     * Set infoValue
     * 
     * @param infoValue 信息值
     */

    public void setInfoValue(String infoValue) {
        this.infoValue = infoValue;
    }

    /**
     * Get infoDesc
     * 
     * @return infoDesc
     */
    public String getInfoDesc() {
        return this.infoDesc;
    }

    /**
     * Set infoDesc
     * 
     * @param infoDesc 信息描述
     */

    public void setInfoDesc(String infoDesc) {
        this.infoDesc = infoDesc;
    }

    /**
     * Get infoCheckFlag
     * 
     * @return infoCheckFlag
     */
    public Integer getInfoCheckFlag() {
        return this.infoCheckFlag;
    }

    /**
     * Set infoCheckFlag
     * 
     * @param infoCheckFlag 信息审核标识
     */

    public void setInfoCheckFlag(Integer infoCheckFlag) {
        this.infoCheckFlag = infoCheckFlag;
    }

    /**
     * Get infoDelFlag
     * 
     * @return infoDelFlag
     */
    public Integer getInfoDelFlag() {
        return this.infoDelFlag;
    }

    /**
     * Set infoDelFlag
     * 
     * @param infoDelFlag 信息删除标识
     */

    public void setInfoDelFlag(Integer infoDelFlag) {
        this.infoDelFlag = infoDelFlag;
    }

    /**
     * Get infoSortIndex
     * 
     * @return infoSortIndex
     */
    public Integer getInfoSortIndex() {
        return this.infoSortIndex;
    }

    /**
     * Set infoSortIndex
     * 
     * @param infoSortIndex 信息序值
     */

    public void setInfoSortIndex(Integer infoSortIndex) {
        this.infoSortIndex = infoSortIndex;
    }

    /**
     * Get infoContact
     * 
     * @return infoContact
     */
    public String getInfoContact() {
        return this.infoContact;
    }

    /**
     * Set infoContact
     * 
     * @param infoContact 信息联系人
     */

    public void setInfoContact(String infoContact) {
        this.infoContact = infoContact;
    }

    /**
     * Get infoTel
     * 
     * @return infoTel
     */
    public String getInfoTel() {
        return this.infoTel;
    }

    /**
     * Set infoTel
     * 
     * @param infoTel 信息联系方式
     */

    public void setInfoTel(String infoTel) {
        this.infoTel = infoTel;
    }

    /**
     * Get infoQq
     * 
     * @return infoQq
     */
    public String getInfoQq() {
        return this.infoQq;
    }

    /**
     * Set infoQq
     * 
     * @param infoQq 信息联系QQ
     */

    public void setInfoQq(String infoQq) {
        this.infoQq = infoQq;
    }

    /**
     * Get infoMail
     * 
     * @return infoMail
     */
    public String getInfoMail() {
        return this.infoMail;
    }

    /**
     * Set infoMail
     * 
     * @param infoMail 信息联系邮箱
     */

    public void setInfoMail(String infoMail) {
        this.infoMail = infoMail;
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
     * @param userId 信息所属用户id
     */

    public void setUserId(Integer userId) {
        this.userId = userId;
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
