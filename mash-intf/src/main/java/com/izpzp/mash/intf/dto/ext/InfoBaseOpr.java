/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: InfoBaseOpr.java
 * Author:   izpzp
 * Date:     2014-11-14 下午3:25:07
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf.dto.ext;

import java.io.Serializable;

/**
 * 前台传参bean<br> 
 * 前台传参bean
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InfoBaseOpr implements Serializable {
    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 信息标题 信息标题
     */
    private String infoTitle;
    /**
     * 信息值 信息值
     */
    private String infoValue;
    /**
     * 信息描述 信息描述
     */
    private String infoDesc;
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
     * @return the infoTitle
     */
    public String getInfoTitle() {
        return infoTitle;
    }
    /**
     * @param infoTitle the infoTitle to set
     */
    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }
    /**
     * @return the infoValue
     */
    public String getInfoValue() {
        return infoValue;
    }
    /**
     * @param infoValue the infoValue to set
     */
    public void setInfoValue(String infoValue) {
        this.infoValue = infoValue;
    }
    /**
     * @return the infoDesc
     */
    public String getInfoDesc() {
        return infoDesc;
    }
    /**
     * @param infoDesc the infoDesc to set
     */
    public void setInfoDesc(String infoDesc) {
        this.infoDesc = infoDesc;
    }
    /**
     * @return the infoContact
     */
    public String getInfoContact() {
        return infoContact;
    }
    /**
     * @param infoContact the infoContact to set
     */
    public void setInfoContact(String infoContact) {
        this.infoContact = infoContact;
    }
    /**
     * @return the infoTel
     */
    public String getInfoTel() {
        return infoTel;
    }
    /**
     * @param infoTel the infoTel to set
     */
    public void setInfoTel(String infoTel) {
        this.infoTel = infoTel;
    }
    /**
     * @return the infoQq
     */
    public String getInfoQq() {
        return infoQq;
    }
    /**
     * @param infoQq the infoQq to set
     */
    public void setInfoQq(String infoQq) {
        this.infoQq = infoQq;
    }
    /**
     * @return the infoMail
     */
    public String getInfoMail() {
        return infoMail;
    }
    /**
     * @param infoMail the infoMail to set
     */
    public void setInfoMail(String infoMail) {
        this.infoMail = infoMail;
    }
    
}
