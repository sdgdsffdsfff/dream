/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: AwardDao.java
 * Author:   izpzp
 * Date:     2014-11-17 下午9:53:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import java.util.List;

import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.weixin.dto.AwardBean;
import com.izpzp.mash.intf.weixin.dto.SearchAwardBean;

/**
 * 微信上墙-中奖<br> 
 * 微信上墙-中奖
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface AwardDao {
    /**
     * 功能描述: <br>
     * 添加接收微信上墙-中奖
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean addAward(AwardBean actBean);
    
    /**
     * 功能描述: <br>
     * 更新广告信息
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateAward(AwardBean actBean);
    
    /**
     * 功能描述: <br>
     * 删除接收微信上墙-中奖
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean delAward(Integer awardId);
    
    /**
     * 功能描述: <br>
     * 获取接收微信上墙-中奖
     *
     * @param awardId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    AwardBean getAward(Integer awardId);
    
    /**
     * 功能描述: <br>
     * 查询微信上墙-中奖列表
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AwardBean> getAwardList(SearchAwardBean searchAwardBean);
    
    /**
     * 功能描述: <br>
     * 查询微信上墙-中奖-分页
     *
     * @param infoAd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResult<AwardBean> getAwards(SearchAwardBean searchAwardBean);
}
