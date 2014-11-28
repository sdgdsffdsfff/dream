/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: LinkInfo.java
 */
package com.izpzp.mash.intf.dto;

import java.io.Serializable;

/**
 * 实体类DTO518信息友情链接   
 * 
 */
public class LinkInfoBean implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 链接id 链接id
     */
    private Integer linkId;
    /**
     * 链接标题 链接标题
     */
    private String linkTitle;
    /**
     * 链接描述 链接描述
     */
    private String linkDesc;
    /**
     * 链接图片 链接图片
     */
    private String linkImg;
    /**
     * 链接url 链接url
     */
    private String linkUrl;
    /**
     * 链接展示标示 链接展示标示
     */
    private Integer linkShowFlag;
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
     * Get linkId
     * 
     * @return linkId
     */
    public Integer getLinkId() {
        return this.linkId;
    }

    /**
     * Set linkId
     * 
     * @param linkId 链接id
     */

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    /**
     * Get linkTitle
     * 
     * @return linkTitle
     */
    public String getLinkTitle() {
        return this.linkTitle;
    }

    /**
     * Set linkTitle
     * 
     * @param linkTitle 链接标题
     */

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    /**
     * Get linkDesc
     * 
     * @return linkDesc
     */
    public String getLinkDesc() {
        return this.linkDesc;
    }

    /**
     * Set linkDesc
     * 
     * @param linkDesc 链接描述
     */

    public void setLinkDesc(String linkDesc) {
        this.linkDesc = linkDesc;
    }

    /**
     * Get linkImg
     * 
     * @return linkImg
     */
    public String getLinkImg() {
        return this.linkImg;
    }

    /**
     * Set linkImg
     * 
     * @param linkImg 链接图片
     */

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    /**
     * Get linkUrl
     * 
     * @return linkUrl
     */
    public String getLinkUrl() {
        return this.linkUrl;
    }

    /**
     * Set linkUrl
     * 
     * @param linkUrl 链接url
     */

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * Get linkShowFlag
     * 
     * @return linkShowFlag
     */
    public Integer getLinkShowFlag() {
        return this.linkShowFlag;
    }

    /**
     * Set linkShowFlag
     * 
     * @param linkShowFlag 链接展示标示
     */

    public void setLinkShowFlag(Integer linkShowFlag) {
        this.linkShowFlag = linkShowFlag;
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
