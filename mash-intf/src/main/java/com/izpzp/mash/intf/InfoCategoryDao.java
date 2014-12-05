/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: InfoCategoryDao.java
 * Author:   izpzp
 * Date:     2014-11-12 上午9:40:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import com.izpzp.mash.intf.dto.InfoCategoryBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoCategoryBean;

/**
 * 信息-类目<br> 
 * 信息-类目信息维护
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface InfoCategoryDao {
    /**
     * 功能描述: <br>
     * 添加类目信息
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean addInfoBase(InfoCategoryBean infoCategoryBean);
    
    /**
     * 功能描述: <br>
     * 更新类目信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateInfoBase(InfoCategoryBean infoCategoryBean);
    
    /**
     * 功能描述: <br>
     * 删除类目信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delInfoBase(Integer categoryId);
    
    /**
     * 功能描述: <br>
     * 获取类目信息
     *
     * @param adId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    InfoCategoryBean getInfoBase(Integer categoryId);
    
    /**
     * 功能描述: <br>
     * 查询类目信息列表
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<InfoCategoryBean> getInfoCategoryList(SearchInfoCategoryBean searchInfoCategoryBean);
}
