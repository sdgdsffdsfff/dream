/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: MashArg.java
 * Author:   izpzp
 * Date:     2014-11-5 下午4:38:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

/**
 * 从前台页面传入数据<br> 
 * 入参
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MashArg {
    
    /**
     * mashA
     */
    private Integer mashAid;
    /**
     * mashB
     */
    private Integer mashBid;
    /**
     * 获胜或优势
     */
    private Integer winId;
    /**
     * @return the mashAid
     */
    public Integer getMashAid() {
        return mashAid;
    }
    /**
     * @param mashAid the mashAid to set
     */
    public void setMashAid(Integer mashAid) {
        this.mashAid = mashAid;
    }
    /**
     * @return the mashBid
     */
    public Integer getMashBid() {
        return mashBid;
    }
    /**
     * @param mashBid the mashBid to set
     */
    public void setMashBid(Integer mashBid) {
        this.mashBid = mashBid;
    }
    /**
     * @return the winId
     */
    public Integer getWinId() {
        return winId;
    }
    /**
     * @param winId the winId to set
     */
    public void setWinId(Integer winId) {
        this.winId = winId;
    }
    
}
