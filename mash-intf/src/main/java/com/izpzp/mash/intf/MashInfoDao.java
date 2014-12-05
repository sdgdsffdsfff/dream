/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: MashInfoDao.java
 * Author:   izpzp
 * Date:     2014-11-5 上午11:31:28
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import java.util.List;

import com.izpzp.mash.intf.dto.MashInfoBean;


/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface MashInfoDao {
    
    /**
     * 功能描述: <br>
     * 获得Mash信息
     *
     * @param mashId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    MashInfoBean getMashInfo(Integer mashId);
    
    /**
     * 功能描述: <br>
     * 随机获取两条要mash的数据
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<MashInfoBean> getMashRandom();
    
    /**
     * 功能描述: <br>
     * 更新mash信息
     *
     * @param mashId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void updateMashInfo(MashInfoBean mashInfoBean);
    
    /**
     * 功能描述: <br>
     * 获取总排名-15人
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<MashInfoBean> getMashSort();
    
    /**
     * 功能描述: <br>
     * 获取最佳新人排名
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<MashInfoBean> getNewMashSort();
    
    /**
     * 功能描述: <br>
     * mashInfo信息入库
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void insertMashInfo(MashInfoBean mashInfobean);
}
