/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: SearchMsgBean.java
 * Author:   13075787
 * Date:     2014-11-18 下午5:09:44
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf.weixin.dto;

/**
 * 公众消息查询bean <br> 
 * 公众消息查询bean
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SearchMsgBean extends MsgBean {

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 页面起始页
     */
    private Integer pageNumber = 1;
    
    /**
     * 单页面记录数
     */
    private Integer pageSize = 15;

    /**
     * limit
     */
    private Integer startIndex = 0;
    
    /**
     * limit
     */
    private Integer maxCount = 10;
    
    /**
     * 用户数量计数
     */
    private String userCountsFlag;
    
    /**
     * ORDER BY rand()
     */
    private String orderRand;

    /**
     * groupByOpenId
     */
    private String groupOpenId;
    
    /**
     * 抽奖使用
     */
    private String binGo;
    
    /**
     * @return the pageNumber
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber the pageNumber to set
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the startIndex
     */
    public Integer getStartIndex() {
        return startIndex;
    }

    /**
     * @param startIndex the startIndex to set
     */
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * @return the maxCount
     */
    public Integer getMaxCount() {
        return maxCount;
    }

    /**
     * @param maxCount the maxCount to set
     */
    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * @return the orderRand
     */
    public String getOrderRand() {
        return orderRand;
    }

    /**
     * @param orderRand the orderRand to set
     */
    public void setOrderRand(String orderRand) {
        this.orderRand = orderRand;
    }

    /**
     * @return the userCountsFlag
     */
    public String getUserCountsFlag() {
        return userCountsFlag;
    }

    /**
     * @param userCountsFlag the userCountsFlag to set
     */
    public void setUserCountsFlag(String userCountsFlag) {
        this.userCountsFlag = userCountsFlag;
    }

    /**
     * @return the binGo
     */
    public String getBinGo() {
        return binGo;
    }

    /**
     * @param binGo the binGo to set
     */
    public void setBinGo(String binGo) {
        this.binGo = binGo;
    }

    /**
     * @return the groupOpenId
     */
    public String getGroupOpenId() {
        return groupOpenId;
    }

    /**
     * @param groupOpenId the groupOpenId to set
     */
    public void setGroupOpenId(String groupOpenId) {
        this.groupOpenId = groupOpenId;
    }

}
