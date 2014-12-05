package com.izpzp.mash.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * 加载系统参数 在系统启动时从配置文件中加载系统参数到内存中
 * 
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

    private static Map<String, Object> ctxPropertiesMap = new HashMap<String, Object>();

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) {
        super.processProperties(beanFactoryToProcess, props);
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    /**
     * 功能描述: <br>
     * getProperty
     *
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public String getProperty(String key) {
        Object value = ctxPropertiesMap.get(key);
        if (value != null) {
            return value.toString();
        }
        return null;
    }

    /**
     * 功能描述: <br>
     * getContextProperty
     *
     * @param name
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Object getContextProperty(String name) {
        return ctxPropertiesMap.get(name);
    }
}