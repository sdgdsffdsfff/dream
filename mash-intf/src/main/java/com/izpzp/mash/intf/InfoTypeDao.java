/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: InfoTypeDao.java
 * Author:   izpzp
 * Date:     2014-11-12 上午9:40:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import com.izpzp.mash.intf.dto.InfoTypeBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoTypeBean;

/**
 * 信息类型-维护<br> 
 * 信息类型-维护
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface InfoTypeDao {
    
    /**
     * 功能描述: <br>
     * 添加信息类型
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean addInfoBase(InfoTypeBean infoTypeBean);
    
    /**
     * 功能描述: <br>
     * 更新信息类型
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateInfoBase(InfoTypeBean infoTypeBean);
    
    /**
     * 功能描述: <br>
     * 删除信息类型
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delInfoBase(Integer typeId);
    
    /**
     * 功能描述: <br>
     * 获取信息类型
     *
     * @param adId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    InfoTypeBean getInfoBase(Integer typeId);
    
    /**
     * 功能描述: <br>
     * 查询信息类型列表
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<InfoTypeBean> getInfoBaseList(SearchInfoTypeBean searchInfoTypeBean);
}
