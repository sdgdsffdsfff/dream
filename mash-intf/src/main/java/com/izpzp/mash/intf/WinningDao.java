/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: WinningDao.java
 * Author:   izpzp
 * Date:     2014-11-18 上午9:08:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import java.util.List;

import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.SearchWinningBean;
import com.izpzp.mash.intf.weixin.dto.WinningBean;

/**
 * 微信上墙-中奖 <br> 
 * 微信上墙-中奖
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface WinningDao {
    /**
     * 功能描述: <br>
     * 添加接收微信上墙-中奖
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean addWinning(WinningBean winningBean);
    
    /**
     * 功能描述: <br>
     * 更新微信上墙-中奖
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateWinning(WinningBean winningBean);
    
    /**
     * 功能描述: <br>
     * 删除接收微信上墙-中奖
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delWinning(Integer winId);
    
    /**
     * 功能描述: <br>
     * 获取接收微信上墙-中奖
     *
     * @param adId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    WinningBean getWinning(Integer winId);
    
    /**
     * 功能描述: <br>
     * 查询微信上墙-中奖列表
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<WinningBean> getWinningList(SearchWinningBean searchWinningBean);
    
    /**
     * 功能描述: <br>
     * 查询微信上墙-中奖-分页
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<WinningBean> getWinnings(SearchWinningBean searchWinningBean);
    
    /**
     * 功能描述: <br>
     * 查询中奖人数
     *
     * @param searchWinningBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer getWinningCount(SearchWinningBean searchWinningBean);
}
