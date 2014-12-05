/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: LinkInfoDao.java
 * Author:   izpzp
 * Date:     2014-11-13 上午11:52:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import com.izpzp.mash.intf.dto.LinkInfoBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchLinkInfoBean;

/**
 * 友情链接信息<br> 
 * 友情链接信息
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface LinkInfoDao {
    /**
     * 功能描述: <br>
     * 添加友情链接信息
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean addLinkInfo(LinkInfoBean linkInfoBean);
    
    /**
     * 功能描述: <br>
     * 更新友情链接信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateLinkInfo(LinkInfoBean linkInfoBean);
    
    /**
     * 功能描述: <br>
     * 删除友情链接信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delLinkInfo(Integer linkId);
    
    /**
     * 功能描述: <br>
     * 获取友情链接信息
     *
     * @param adId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LinkInfoBean getLinkInfo(Integer linkId);
    
    /**
     * 功能描述: <br>
     * 查询友情链接信息列表
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<LinkInfoBean> getLinkInfoList(SearchLinkInfoBean searchLinkInfoBean);
}
