/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: NJ518PersonServiceImpl.java
 * Author:   13075787
 * Date:     2014-11-14 下午12:26:58
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izpzp.mash.constants.NJ518Constants;
import com.izpzp.mash.intf.InfoBaseDao;
import com.izpzp.mash.intf.NJ518PersonService;
import com.izpzp.mash.intf.dto.InfoBaseBean;
import com.izpzp.mash.intf.dto.InfoBaseExtBean;
import com.izpzp.mash.intf.dto.QueryResult;
import com.izpzp.mash.intf.dto.SearchInfoBaseBean;

/**
 * 个人服务<br> 
 * 个人服务
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class NJ518PersonServiceImpl implements NJ518PersonService {

    @Autowired
    InfoBaseDao infoBaseDao;
    
    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.NJ518PersonService#getMyInfoBaseList(com.izpzp.mash.intf.dto.SearchInfoBaseBean)
     */
    public QueryResult<InfoBaseExtBean> getMyInfoBaseList(SearchInfoBaseBean searchInfoBase) {
        QueryResult<InfoBaseExtBean> query = infoBaseDao.getInfoBaseExtList(searchInfoBase);
        return query;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.NJ518PersonService#saveInfo(com.izpzp.mash.intf.dto.InfoBaseBean)
     */
    public Map<String, Object> saveInfo(InfoBaseBean infoBase) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("succFlag", false);
        result.put("msg", "信息发布失败！");
        if(null != infoBase){
            //类目不为空且类目不能为博客文档
            String categoryCode = infoBase.getCategoryCode();
            if((StringUtils.isNotBlank(categoryCode) && !categoryCode.equals(NJ518Constants.BLOG_CATEGORY))){
                infoBase.setInfoTitle(this.checkContent(infoBase.getInfoTitle()));
                infoBase.setInfoValue(this.checkContent(infoBase.getInfoValue()));
                infoBase.setInfoDesc(this.checkContent(infoBase.getInfoDesc()));
                boolean flag = infoBaseDao.addInfoBase(infoBase);
                if(flag){
                    result.put("succFlag", true);
                    result.put("msg", "信息发布成功！");
                }
            }
        }
        return result;
    }
    
    /*
     * 过滤内容中的特殊字符 
     */
    private String checkContent(String content){
        String result = null;
        if(StringUtils.isNotBlank(content)){
            Pattern pattern = Pattern.compile("[http]{4}\\:\\/\\/[a-z]*(\\.[a-zA-Z]*)*(\\/([a-zA-Z]|[0-9])*)*\\s?");
            Matcher matcher = pattern.matcher(content);
            result = matcher.replaceAll("");
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.NJ518PersonService#updateInfo(com.izpzp.mash.intf.dto.InfoBaseBean)
     */
    public Map<String, Object> updateInfo(InfoBaseBean infoBase) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("succFlag", false);
        result.put("msg", "信息更新失败！");
        if(null != infoBase && null != infoBase.getInfoId()){
            //类目不为空且类目不能为博客文档
            String categoryCode = infoBase.getCategoryCode();
            if((StringUtils.isNotBlank(categoryCode) && !categoryCode.equals(NJ518Constants.BLOG_CATEGORY))){
                infoBase.setInfoTitle(this.checkContent(infoBase.getInfoTitle()));
                infoBase.setInfoValue(this.checkContent(infoBase.getInfoValue()));
                infoBase.setInfoDesc(this.checkContent(infoBase.getInfoDesc()));
                boolean flag = infoBaseDao.updateInfoBase(infoBase);
                if(flag){
                    result.put("succFlag", true);
                    result.put("msg", "信息更新成功！");
                }
            }
        }
        return result;
        
    }

    /* (non-Javadoc)
     * @see com.izpzp.mash.intf.NJ518PersonService#delInfo(com.izpzp.mash.intf.dto.InfoBaseBean)
     */
    public Map<String, Object> delInfo(InfoBaseBean infoBase) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("succFlag", false);
        result.put("msg", "信息删除失败！");
        if(null != infoBase 
                && null != infoBase.getInfoId() 
                && null != infoBase.getUserId()){
            boolean flag = infoBaseDao.delInfoBase(infoBase);
            if(flag){
                result.put("succFlag", true);
                result.put("msg", "信息删除成功！");
            }
        }
        return result;
    }

}
