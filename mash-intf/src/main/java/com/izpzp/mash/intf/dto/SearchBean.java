/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: SearchBean.java
 * Author:   izpzp
 * Date:     2014-3-11 上午10:27:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf.dto;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 搜索条件Bean
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SearchBean implements Serializable {
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
    
}
