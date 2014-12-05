/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: BaseDao.java
 * Author:   izpzp
 * Date:     2014-11-5 上午11:50:41
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * BaseDao <br> 
 * BaseDao
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BaseDao extends SqlMapClientDaoSupport {
    
    @Autowired//为了注入SqlMapClient所以多了一个baseDao  
    public void setSqlMapClientBase(SqlMapClient sqlMapClient) {  
        super.setSqlMapClient(sqlMapClient);  
    }
}  
