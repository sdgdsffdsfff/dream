/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: ShowTheWorldService.java
 * Author:   13075787
 * Date:     2014-11-18 下午4:49:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.intf;

import java.util.Map;

import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.ActBean;
import com.izpzp.mash.intf.weixin.dto.MsgExtBean;

/**
 * 上墙-前端展示<br> 
 * 上墙-前端展示
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ShowTheWorldService {
    
    /**
     * 功能描述: <br>
     * 查询当前上墙活动信息
     *
     * @param actId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ActBean getActInfo(Integer actId);
    
    /**
     * 功能描述: <br>
     * 获取公众消息列表
     *
     * @param actId
     * @param pageIndex
     * @param pageSize
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<MsgExtBean> getMsgs(Integer actId, Integer pageIndex, Integer pageSize);
    
    /**
     * 功能描述: <br>
     * 将展示标识初始化-重新置为未展示
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean initMsgShowFlagStatus(Integer actId);
    
    /**
     * 功能描述: <br>
     * 获取该活动的参与人数及消息总数
     * 
     * @param actId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> getActExtInfo(Integer actId);
}
