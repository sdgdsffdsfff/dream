/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: WeiXinService.java
 * Author:   izpzp
 * Date:     2014-11-17 下午4:21:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.intf;

import com.izpzp.mash.intf.weixin.dto.MsgBean;

/**
 * 微信服务接口<br> 
 * 微信服务接口
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface WeiXinService {
    
    /**
     * 功能描述: <br>
     * 接受消息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String acceptMsg(String xml);
    
    /**
     * 功能描述: <br>
     * 微信信息上墙
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String showTheWorld(MsgBean msgBean);
    
    /**
     * 功能描述: <br>
     * 根据mpId获取当前开发账户信息
     *
     * @param mpId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String getAccountToken(Integer mpId);
}
