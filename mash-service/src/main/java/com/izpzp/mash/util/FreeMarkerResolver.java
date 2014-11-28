/*
 * Copyright (C), 2002-2013, izpzp
 * FileName: FreeMarkerResolver.java
 * Author:   12070644@cnsuning.com
 * Date:     2014-3-10 上午00:00:00
 */
package com.izpzp.mash.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;

/**
 * FreeMarkerResolver
 * 
 */
@Component
public class FreeMarkerResolver {
    /**
     * freemarker配置
     */
    @Autowired
    FreeMarkerConfigurer freemarkerConfig;

    /**
     * 将模板解析成页面
     */
    public String resolve(String templateName, Object map) {
        String htmlText = null;
        try {
            Template tpl = freemarkerConfig.getConfiguration().getTemplate(templateName, "UTF-8");
            htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, map);
        } catch (Exception e) {
            htmlText = "";
            // TODO
        }
        return htmlText;
    }
    
}
