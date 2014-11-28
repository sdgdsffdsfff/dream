/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: ZPXStream.java
 * Author:   13075787
 * Date:     2014-11-17 下午1:55:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;

/**
 * XStreamUtil<br> 
 * XStreamUtil
 *
 * @author 13075787
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class XStreamUtil {
    
    /**
     * 功能描述: <br>
     * 将字符串xml转换为bean
     *
     * @param xml
     * @param cla
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @SuppressWarnings("rawtypes")
    public static Object xmlToBean(String xml, Class cla){
        XStream xStream = new XStream(){/* (non-Javadoc)
         * @see com.thoughtworks.xstream.XStream#wrapMapper(com.thoughtworks.xstream.mapper.MapperWrapper)
         */
        @Override
        protected MapperWrapper wrapMapper(MapperWrapper next) {
            return new MapperWrapper(next){/* (non-Javadoc)
             * @see com.thoughtworks.xstream.mapper.MapperWrapper#shouldSerializeMember(java.lang.Class, java.lang.String)
             */
            @Override
            public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                if (definedIn == Object.class) {
                    try {
                        return this.realClass(fieldName) != null;
                    } catch (Exception e) {
                        return false;
                    }
                }else{
                    return super.shouldSerializeMember(definedIn, fieldName);
                }
            }};
        }};
        xStream.processAnnotations(cla);
        Object reobj = xStream.fromXML(xml);
        return reobj;
    }
    
}
