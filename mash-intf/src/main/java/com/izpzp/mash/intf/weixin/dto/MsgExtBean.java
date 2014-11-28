/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: MsgExtBean.java
 * Author:   13075787
 * Date:     2014-11-19 上午11:00:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf.weixin.dto;

/**
 * 用户扩展信息<br> 
 * 用户扩展信息
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MsgExtBean extends MsgBean {

    /**
     */
    private static final long serialVersionUID = -4428006778012733911L;

    /**
     * 消息发布时间
     */
    private String msgTime;
    
    /**
     * 用户的标识，对当前公众号唯一
     */
    private String openid;
    /**
     * 用户的昵称
     */
    private String nickname;
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     */
    private String headimgurl;
    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer sex;
    /**
     * 用户所在城市
     */
    private String city;
    /**
     * 用户所在国家
     */
    private String country;
    /**
     * 用户所在省份
     */
    private String province;
    /**
     * @return the openid
     */
    public String getOpenid() {
        return openid;
    }
    /**
     * @param openid the openid to set
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }
    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    /**
     * @return the headimgurl
     */
    public String getHeadimgurl() {
        return headimgurl;
    }
    /**
     * @param headimgurl the headimgurl to set
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }
    /**
     * @return the sex
     */
    public Integer getSex() {
        return sex;
    }
    /**
     * @param sex the sex to set
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }
    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }
    /**
     * @return the msgTime
     */
    public String getMsgTime() {
        return msgTime;
    }
    /**
     * @param msgTime the msgTime to set
     */
    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }
    
}
