/*
 * Copyright (C), 2002-2013, izpzp.com
 * FileName: ComtBeanUtils.java
 * Author:   niuzhiheng
 * Date:     2013-3-15 上午10:01:02
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Bean相关拷贝操作<br> 
 *
 * @author 12090707
 */
public class BeanUtil {
    /**
     * <b>对象对应属性拷贝 </b><br>
     * 
     * @param destObj 目标对象
     * @param origObj 源对象
     */
    public static void copyProperties(Object destObj, Object origObj) {
        try {
            if (null != origObj && null != destObj) {
                PropertyUtils.copyProperties(destObj, origObj);
            }
        } catch (IllegalAccessException e) {  
        } catch (InvocationTargetException e) {
        } catch (NoSuchMethodException e) {
        }
    }

    /**
     * <b>对象对应属性拷贝</b><br>
     * 按照目标对象类型实例化目标对象，并将源对象的属性拷贝到目标对象
     * 
     * @param clazz 目标对象类型
     * @param origObj 源对象
     * @return 目标对象
     */
    public static <T> T copyProperties(Class<T> clazz, Object origObj) {
        try {
            T destObj = clazz.newInstance();
            PropertyUtils.copyProperties(destObj, origObj);
            return destObj;
        } catch (InvocationTargetException e) {
            
        } catch (NoSuchMethodException e) {
            
        } catch (InstantiationException e) {
            
            
        } catch (IllegalAccessException e) {
            
        }
        return null;
    }

    /**
     * 
     * <b>对象对应属性拷贝 </b><br>
     * 从Map中把属性值copy到目标对象中
     * 
     * @param destObj 目标对象
     * @param properties 属性Map
     */
    public static void copyProperties(Object destObj, Map<String, ?> properties) {
        try {
            if (null != properties && null != destObj) {
                org.apache.commons.beanutils.BeanUtils.populate(destObj, properties);
            }
        } catch (IllegalAccessException e) {
            
        } catch (InvocationTargetException e) {
            
        }
    }

    /**
     * <b>拷贝对象中的非空属性到map中</b><br>
     * 拷贝对象中的非空属性到map中，键为属性名，值为属性值
     * 
     * @param param 目标map
     * @param obj 待拷贝对象
     */
    public static void copyNotnullProperties(Map<String, Object> param, Object obj) {
        BeanInfo beanInfo;
        try {
            // 类似反射得到obj对象的属性描述
            beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

            // 循环遍历，将属性名-属性值键值对放到map中
            for (PropertyDescriptor pd : pds) {
                Method methodGetX = pd.getReadMethod();
                Object retVal = methodGetX.invoke(obj);
                String pdType = pd.getPropertyType().getSimpleName();

                // 属性为Class的不保存
                if (!"Class".equals(pdType) && null != retVal) {
                    if ("String".equals(pdType)) {
                        // 如果属性值不为空，则放到map中
                        if (!"".equals(retVal.toString().trim())) {
                            param.put(pd.getName(), retVal.toString().trim());
                        }
                    } else {
                        param.put(pd.getName(), retVal);
                    }
                }
            }
        } catch (IntrospectionException e) {
            
        } catch (IllegalArgumentException e) {
            
        } catch (IllegalAccessException e) {
            
        } catch (InvocationTargetException e) {
            
        }
    }
    
    /**
     * 
     * 功能描述: <br>
     * 拷贝对象中的所有属性到map中，键为属性名，值为属性值
     *
     * @param obj
     * @return map
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> describe(Object obj) {
        Map<String, Object> param = null;
        try {
            param = org.apache.commons.beanutils.BeanUtils.describe(obj);
            param.remove("class");
        } catch (IllegalAccessException e) {
            
        } catch (InvocationTargetException e) {
            
        } catch (NoSuchMethodException e) {
            
        }
        
        return param;
    }
    
    /**
     * 功能描述: <br>
     * 将bean转为map
     * 
     * @param obj
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Map<String, Object> transBeanToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    if (value != null) {
                        map.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            map = null;
        }
        return map;
    }
}
