/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: UserDaoImpl.java
 * Author:   izpzp
 * Date:     2014-11-24 下午3:20:33
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.izpzp.mash.intf.UserDao;
import com.izpzp.mash.intf.weixin.dto.SearchUserBean;
import com.izpzp.mash.intf.weixin.dto.UserBean;
import com.izpzp.mash.service.dao.BaseDao;
import com.izpzp.mash.weixin.constants.Constants;

/**
 * 用户信息服务<br> 
 * 用户信息服务
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class UserDaoImpl extends BaseDao implements UserDao {

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.UserDao#addUser(com.izpzp.mash.intf.weixin.dto.UserBean)
     */
    public boolean addUser(UserBean userBean) {
        getSqlMapClientTemplate().insert("insertUser", userBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.UserDao#updateUser(com.izpzp.mash.intf.weixin.dto.UserBean)
     */
    public boolean updateUser(UserBean userBean) {
        getSqlMapClientTemplate().update("updateUser", userBean);
        return true;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.UserDao#getUser(com.izpzp.mash.intf.weixin.dto.SearchUserBean)
     */
    public UserBean getUser(SearchUserBean searchUserBean) {
        UserBean result = null;
        List<UserBean> userList = this.getUserList(searchUserBean);
        if(null != userList && Constants.NUM_0 < userList.size()){
            result = userList.get(Constants.NUM_0);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.UserDao#getUserList(com.izpzp.mash.intf.weixin.dto.SearchUserBean)
     */
    public List<UserBean> getUserList(SearchUserBean searchUserBean) {
        @SuppressWarnings("unchecked")
        List<UserBean> userList = getSqlMapClientTemplate().queryForList("getUserList", searchUserBean);
        return userList;
    }

}
