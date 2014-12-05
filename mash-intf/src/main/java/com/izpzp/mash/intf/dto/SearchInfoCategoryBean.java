/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: SearchInfoCategoryBean.java
 * Author:   izpzp
 * Date:     2014-11-12 上午11:29:47
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf.dto;

/**
 * 信息类目维护<br> 
 * 信息类目维护
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SearchInfoCategoryBean extends InfoCategoryBean {

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

}
