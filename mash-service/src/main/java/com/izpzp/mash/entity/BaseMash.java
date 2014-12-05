/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: BaseMash.java
 * Author:   izpzp
 * Date:     2014-11-5 上午9:11:50
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.entity;

/**
 * 基础mashBean <br> 
 * 基础mashBean
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BaseMash {
    
    /**
     * 基础值
     */
    private Long baseValue;
    
    /**
     * mash比较值
     */
    private Long mashValue;

    /**
     * @return the baseValue
     */
    public Long getBaseValue() {
        return baseValue;
    }

    /**
     * @param baseValue the baseValue to set
     */
    public void setBaseValue(Long baseValue) {
        this.baseValue = baseValue;
    }

    /**
     * @return the mashValue
     */
    public Long getMashValue() {
        return mashValue;
    }

    /**
     * @param mashValue the mashValue to set
     */
    public void setMashValue(Long mashValue) {
        this.mashValue = mashValue;
    }
    
}
