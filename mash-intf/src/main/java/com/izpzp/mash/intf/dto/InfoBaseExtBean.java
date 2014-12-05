/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: InfoBaseExtBean.java
 * Author:   izpzp
 * Date:     2014-11-12 下午5:33:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf.dto;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InfoBaseExtBean extends InfoBaseBean {

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 类型名称 类型名称
     */
    private String typeName;

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
}
