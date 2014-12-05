/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: InfoBaseDao.java
 * Author:   izpzp
 * Date:     2014-11-12 上午9:40:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import com.izpzp.mash.intf.dto.InfoBaseBean;
import com.izpzp.mash.intf.dto.InfoBaseExtBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoBaseBean;

/**
 * 信息-信息发布维护<br> 
 * 信息-发布维护
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface InfoBaseDao {
    
    /**
     * 功能描述: <br>
     * 添加信息发布
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean addInfoBase(InfoBaseBean infoBaseBean);
    
    /**
     * 功能描述: <br>
     * 更新信息发布
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateInfoBase(InfoBaseBean infoBaseBean);
    
    /**
     * 功能描述: <br>
     * 删除信息发布
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delInfoBase(Integer infoId);
    
    /**
     * 功能描述: <br>
     * 删除信息发布
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delInfoBase(InfoBaseBean infoBaseBean);
    
    /**
     * 功能描述: <br>
     * 获取信息发布
     *
     * @param adId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    InfoBaseBean getInfoBase(Integer infoId);
    
    /**
     * 功能描述: <br>
     * 查询信息发布列表
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<InfoBaseBean> getInfoBaseList(SearchInfoBaseBean searchInfoBase);
    
    /**
     * 功能描述: <br>
     * 查询信息发布列表
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<InfoBaseExtBean> getInfoBaseExtList(SearchInfoBaseBean searchInfoBase);

}
