/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: UserDao.java
 * Author:   13075787
 * Date:     2014-11-24 下午3:12:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.intf;

import java.util.List;

import com.izpzp.mash.intf.weixin.dto.SearchUserBean;
import com.izpzp.mash.intf.weixin.dto.UserBean;

/**
 * 用户信息服务 <br> 
 * 用户信息服务
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface UserDao {
    
    /**
     * 功能描述: <br>
     * 新增用户
     *
     * @param userBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean addUser(UserBean userBean);
    
    /**
     * 功能描述: <br>
     * 更新用户信息
     *
     * @param userBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean updateUser(UserBean userBean);
    
    /**
     * 功能描述: <br>
     * 获得用户信息
     *
     * @param searchUserBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    UserBean getUser(SearchUserBean searchUserBean);
    
    /**
     * 功能描述: <br>
     * 获得用户信息列表
     *
     * @param searchUserBean
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<UserBean> getUserList(SearchUserBean searchUserBean);
}
