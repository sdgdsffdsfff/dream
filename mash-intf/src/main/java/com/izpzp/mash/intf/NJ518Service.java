/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: NJ518Service.java
 * Author:   13075787
 * Date:     2014-11-12 下午12:08:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import java.util.List;

import com.izpzp.mash.intf.dto.InfoAdBean;
import com.izpzp.mash.intf.dto.InfoBaseExtBean;
import com.izpzp.mash.intf.dto.InfoCategoryBean;
import com.izpzp.mash.intf.dto.LinkInfoBean;
import com.izpzp.mash.intf.dto.QueryResult;

/**
 * nj518<br> 
 * nj518信息
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface NJ518Service {
    
    /**
     * 功能描述: <br>
     * 获取类目列表
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<InfoCategoryBean> getInfoCategoryList();

    /**
     * 功能描述: <br>
     * 首页-获取pageSize为7的列表-查询条件为不同的目录
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<InfoBaseExtBean> getInfoBaseFirstList(String categoryCode);
    
    /**
     * 功能描述: <br>
     * 信息列表页-查询信息的方法
     *
     * @param categoryCode
     * @param pageNumber
     * @param pageSize
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<InfoBaseExtBean> getInfoBaseList(String categoryCode, Integer pageNumber, Integer pageSize);
    
    /**
     * 功能描述: <br>
     * 获取广告信息
     *
     * @param categoryCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<InfoAdBean> getInfoAdList(String categoryCode, Integer adLocation);
    
    /**
     * 功能描述: <br>
     * 获取友情链接信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<LinkInfoBean> getLinkInfoList();
    
    /**
     * 功能描述: <br>
     * 查询信息bean
     *
     * @param infoId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    InfoBaseExtBean getInfoBaseExt(Integer infoId);
    
}
