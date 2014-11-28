/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: NJ518PersonService.java
 * Author:   13075787
 * Date:     2014-11-14 下午12:26:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import java.util.Map;

import com.izpzp.mash.intf.dto.InfoBaseBean;
import com.izpzp.mash.intf.dto.InfoBaseExtBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoBaseBean;

/**
 * 个人服务<br> 
 * 个人服务
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface NJ518PersonService {
    
    /**
     * 功能描述: <br>
     * 查询个人用户发布信息列表
     *
     * @param searchInfoBaseBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<InfoBaseExtBean> getMyInfoBaseList(SearchInfoBaseBean searchInfoBase);
    
    /**
     * 功能描述: <br>
     * 发布信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> saveInfo(InfoBaseBean infoBase);
    
    /**
     * 功能描述: <br>
     * 更新信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> updateInfo(InfoBaseBean infoBase);
    
    /**
     * 功能描述: <br>
     * 删除信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> delInfo(InfoBaseBean infoBase);
    
}
