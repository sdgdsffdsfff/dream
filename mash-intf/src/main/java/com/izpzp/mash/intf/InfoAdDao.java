/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: InfoAdDao.java
 * Author:   13075787
 * Date:     2014-11-12 上午9:39:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import com.izpzp.mash.intf.dto.InfoAdBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoAdBean;

/**
 * 信息-广告维护<br> 
 * 信息-广告信息维护
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface InfoAdDao {
    
    /**
     * 功能描述: <br>
     * 添加广告信息
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean addInfoAd(InfoAdBean infoAdbean);
    
    /**
     * 功能描述: <br>
     * 更新广告信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateInfoAd(InfoAdBean infoAdbean);
    
    /**
     * 功能描述: <br>
     * 删除广告信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delInfoAd(Integer adId);
    
    /**
     * 功能描述: <br>
     * 获取广告信息
     *
     * @param adId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    InfoAdBean getInfoAd(Integer adId);
    
    /**
     * 功能描述: <br>
     * 查询广告列表
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<InfoAdBean> getInfoAdList(SearchInfoAdBean searchInfoAd);
}
