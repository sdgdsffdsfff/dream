/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: SIndexInfoBaseBean.java
 * Author:   13075787
 * Date:     2014-11-14 下午12:31:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf.dto.ext;

import java.io.Serializable;

/**
 * 前台页面查询条件使用bean<br> 
 * 前台页面查询条件使用bean
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SIndexInfoBaseBean implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 信息id 信息id
     */
    private Integer infoId;
    
    /**
     * 信息类目 信息类目
     */
    private String categoryCode;
    
    /**
     * 信息类型 信息类型
     */
    private Integer typeId;

    /**
     * 页面起始页
     */
    private Integer pageNumber = 1;
    
    /**
     * @return the infoId
     */
    public Integer getInfoId() {
        return infoId;
    }

    /**
     * @param infoId the infoId to set
     */
    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    /**
     * @return the categoryCode
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * @param categoryCode the categoryCode to set
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * @return the typeId
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the typeId to set
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

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
    
}
