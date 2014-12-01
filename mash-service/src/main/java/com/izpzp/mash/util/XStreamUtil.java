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

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
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
    
    protected static String PREFIX_CDATA    = "<![CDATA[";   
    protected static String SUFFIX_CDATA    = "]]>";
    
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
    
    /**
     * 功能描述: <br>
     * beanToXml
     *
     * @param isAddCDATA
     * @param obj
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static XStream initXStream(boolean isAddCDATA){
        XStream xstream = null;
        if(isAddCDATA){   
            xstream =  new XStream(
               new XppDriver() {   
                  public HierarchicalStreamWriter createWriter(Writer out) {   
                     return new PrettyPrintWriter(out) {   
                     protected void writeText(QuickWriter writer, String text) {   
                                      if(text.startsWith(PREFIX_CDATA)    
                                         && text.endsWith(SUFFIX_CDATA)) {   
                                          writer.write(text);   
                                      }else{
                                          super.writeText(writer, text);   
                                      }   
                      }   
                    };   
                  };   
                }   
            );   
        }else{
            xstream = new XStream();   
        }   
     return xstream;   
    }
    
}
