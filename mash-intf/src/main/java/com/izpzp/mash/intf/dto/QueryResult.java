/*
 * Copyright (C), 2002-2014,izpzp
 * FileName: QueryResult.java
 * Author:   13075787
 * Date:     2014-3-11 上午10:19:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询bean<br> 
 * 分页查询bean
 *
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class QueryResult<T> implements Serializable {

    private static final long serialVersionUID = 7745430438963207491L;

    private List<T> datas;

    private Boolean isLastPage;

    private Integer totalDataCount;

    private int pageNumber = 1;

    private int pageSize = 10;

    private Integer pageCount;

    private int indexNumber;

    public QueryResult(int totalDataCount, int pageSize, int pageNumber) {
        super();
        this.totalDataCount = totalDataCount;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        if (this.pageNumber < 1) {
            this.pageNumber = 1;
        }
        if (this.totalDataCount <= 0) {
            return;
        }
        if (this.totalDataCount <= (this.pageNumber - 1) * this.pageSize) {
            this.pageNumber = (this.totalDataCount + this.pageSize - 1) / this.pageSize;
        }
        this.indexNumber = (this.pageNumber - 1) * this.pageSize;
        this.pageCount = (this.totalDataCount + this.pageSize - 1) / this.pageSize;
        this.isLastPage = (this.pageNumber == this.pageCount ? true : false);
    }

    public QueryResult() {
        super();
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public Boolean getIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(Boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public Integer getTotalDataCount() {
        return totalDataCount;
    }

    public void setTotalDataCount(Integer totalDataCount) {
        this.totalDataCount = totalDataCount;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

}
