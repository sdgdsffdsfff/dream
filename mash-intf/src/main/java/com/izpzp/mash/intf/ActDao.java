/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: ActDao.java
 * Author:   13075787
 * Date:     2014-11-17 下午9:46:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import java.util.List;

import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.ActBean;
import com.izpzp.mash.intf.weixin.dto.SearchActBean;

/**
 * 微信上墙-活动信息<br> 
 * 微信上墙-活动信息
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ActDao {
    /**
     * 功能描述: <br>
     * 添加接收微信上墙-活动信息
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean addAct(ActBean actBean);
    
    /**
     * 功能描述: <br>
     * 更新广告信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateAct(ActBean actBean);
    
    /**
     * 功能描述: <br>
     * 删除接收微信上墙-活动信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delAct(Integer actId);
    
    /**
     * 功能描述: <br>
     * 获取接收微信上墙-活动信息
     *
     * @param adId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ActBean getAct(Integer actId);
    
    /**
     * 功能描述: <br>
     * 查询微信上墙-活动信息列表
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<ActBean> getActList(SearchActBean searchActBean);
    
    /**
     * 功能描述: <br>
     * 查询微信上墙-活动信息列表-分页
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<ActBean> getActs(SearchActBean searchActBean);
}
