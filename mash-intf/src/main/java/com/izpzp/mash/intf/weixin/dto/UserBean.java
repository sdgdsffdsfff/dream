/*
 * Copyright (C), 2014-2020, izpzp.com
 * FileName: User.java
 */
package com.izpzp.mash.intf.weixin.dto;

import java.io.Serializable;

/**
 * 实体类DTO微信上墙-用户管理   
 * 
 */
public class UserBean implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户id 用户id
     */
    private Integer userId;
    /**
     * 用户名称 用户名称
     */
    private String userName;
    /**
     * 用户密码 用户密码
     */
    private String password;
    /**
     * 用户编码 用户编码
     */
    private String userCode;
    /**
     * 用户联系电话 用户联系电话
     */
    private String userTel;
    /**
     * 用户描述 用户描述
     */
    private String userDesc;
    /**
     * 有效标志 有效标志
     */
    private String enabledFlag;
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
     * Get password
     * 
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Set password
     * 
     * @param password 用户密码
     */

    public void setPassword(String password) {
        this.password = password;
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
     * @param userTel 用户联系电话
     */

    public void setUserTel(String userTel) {
        this.userTel = userTel;
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
     * @param userDesc 用户描述
     */

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    /**
     * Get enabledFlag
     * 
     * @return enabledFlag
     */
    public String getEnabledFlag() {
        return this.enabledFlag;
    }

    /**
     * Set enabledFlag
     * 
     * @param enabledFlag 有效标志
     */

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
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
