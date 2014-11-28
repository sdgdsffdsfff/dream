/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: UserInfo.java
 */
package com.izpzp.mash.intf.dto;

import java.io.Serializable;

/**
 * 实体类DTO518信息用户信息表   
 * 
 */
public class UserInfoBean implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户id 用户id
     */
    private Integer userId;
    /**
     * 用户编码 用户编码
     */
    private String userCode;
    /**
     * 用户微信昵称 用户微信昵称
     */
    private String userWeixinName;
    /**
     * 用户昵称 用户昵称
     */
    private String userName;
    /**
     * 用户密码 用户密码
     */
    private String userPasscard;
    /**
     * 用户认证标示 用户认证标示
     */
    private Integer userVipFlag;
    /**
     * 用户禁言标志 用户禁言标志
     */
    private Integer userGagFlag;
    /**
     * 用户删除标志 用户删除标志
     */
    private Integer userDelFlag;
    /**
     * 用户联系方式 用户联系方式
     */
    private String userTel;
    /**
     * 用户QQ 用户QQ
     */
    private String userQq;
    /**
     * 用户邮箱 用户邮箱
     */
    private String userMail;
    /**
     * 用户简介 用户简介
     */
    private String userDesc;
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
     * Get userCode
     * 
     * @return userCode
     */
    public String getUserCode() {
        return this.userCode;
    }

    /**
     * Set userCode
     * 
     * @param userCode 用户编码
     */

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * Get userWeixinName
     * 
     * @return userWeixinName
     */
    public String getUserWeixinName() {
        return this.userWeixinName;
    }

    /**
     * Set userWeixinName
     * 
     * @param userWeixinName 用户微信昵称
     */

    public void setUserWeixinName(String userWeixinName) {
        this.userWeixinName = userWeixinName;
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
     * @param userName 用户昵称
     */

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get userPasscard
     * 
     * @return userPasscard
     */
    public String getUserPasscard() {
        return this.userPasscard;
    }

    /**
     * Set userPasscard
     * 
     * @param userPasscard 用户密码
     */

    public void setUserPasscard(String userPasscard) {
        this.userPasscard = userPasscard;
    }

    /**
     * Get userVipFlag
     * 
     * @return userVipFlag
     */
    public Integer getUserVipFlag() {
        return this.userVipFlag;
    }

    /**
     * Set userVipFlag
     * 
     * @param userVipFlag 用户认证标示
     */

    public void setUserVipFlag(Integer userVipFlag) {
        this.userVipFlag = userVipFlag;
    }

    /**
     * Get userGagFlag
     * 
     * @return userGagFlag
     */
    public Integer getUserGagFlag() {
        return this.userGagFlag;
    }

    /**
     * Set userGagFlag
     * 
     * @param userGagFlag 用户禁言标志
     */

    public void setUserGagFlag(Integer userGagFlag) {
        this.userGagFlag = userGagFlag;
    }

    /**
     * Get userDelFlag
     * 
     * @return userDelFlag
     */
    public Integer getUserDelFlag() {
        return this.userDelFlag;
    }

    /**
     * Set userDelFlag
     * 
     * @param userDelFlag 用户删除标志
     */

    public void setUserDelFlag(Integer userDelFlag) {
        this.userDelFlag = userDelFlag;
    }

    /**
     * Get userTel
     * 
     * @return userTel
     */
    public String getUserTel() {
        return this.userTel;
    }

    /**
     * Set userTel
     * 
     * @param userTel 用户联系方式
     */

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    /**
     * Get userQq
     * 
     * @return userQq
     */
    public String getUserQq() {
        return this.userQq;
    }

    /**
     * Set userQq
     * 
     * @param userQq 用户QQ
     */

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    /**
     * Get userMail
     * 
     * @return userMail
     */
    public String getUserMail() {
        return this.userMail;
    }

    /**
     * Set userMail
     * 
     * @param userMail 用户邮箱
     */

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    /**
     * Get userDesc
     * 
     * @return userDesc
     */
    public String getUserDesc() {
        return this.userDesc;
    }

    /**
     * Set userDesc
     * 
     * @param userDesc 用户简介
     */

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
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
