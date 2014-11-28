/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: WriteHtmlUtils.java
 * Author:   13060148
 * Date:     2014-4-10 下午4:55:24
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * 将流输出到页面
 * 
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WriteHtmlUtils {
    /** 默认类型 */
    private final static String contentType = "text/html; charset=UTF-8";

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param html html文本
     * @param response
     * @throws IOException
     */
    public static void write(String html, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Language", "zh-CN");
        //强制不缓存
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType(contentType);
        response.getWriter().print(html);
        response.getWriter().flush();
    }

}
