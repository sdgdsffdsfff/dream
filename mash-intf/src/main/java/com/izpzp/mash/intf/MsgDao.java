/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: MsgDao.java
 * Author:   izpzp
 * Date:     2014-11-17 下午9:58:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import java.util.List;

import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.MsgBean;
import com.izpzp.mash.intf.weixin.dto.SearchMsgBean;

/**
 * 微信上墙-用户消息<br> 
 * 微信上墙-用户消息
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface MsgDao {
    /**
     * 功能描述: <br>
     * 添加接收微信上墙-用户消息
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean addMsg(MsgBean msgBean);
    
    /**
     * 功能描述: <br>
     * 更新接收微信上墙-用户消息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateMsg(MsgBean msgBean);
    
    /**
     * 功能描述: <br>
     * 更新接收微信上墙-用户消息-扩展-将展示字段置为未展示
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateMsgExt(MsgBean msgBean);
    
    /**
     * 功能描述: <br>
     * 删除接收微信上墙-用户消息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delMsg(Integer msgId);
    
    /**
     * 功能描述: <br>
     * 获取接收微信上墙-用户消息
     *
     * @param adId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    MsgBean getMsg(Integer msgId);
    
    /**
     * 功能描述: <br>
     * 查询微信上墙-用户消息列表
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<MsgBean> getMsgList(SearchMsgBean searchMsgBean);
    
    /**
     * 功能描述: <br>
     * 查询微信上墙-用户消息列表-分页
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<MsgBean> getMsgs(SearchMsgBean searchMsgBean);
    
    /**
     * 功能描述: <br>
     * 获得消息数量
     *
     * @param searchMsgBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer getMstCount(SearchMsgBean searchMsgBean);
    
    /**
     * 功能描述: <br>
     * 获得参与用户人数
     *
     * @param searchMsgBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer getUserCount(SearchMsgBean searchMsgBean);
}
