/*
 * Copyright (C), 2002-2013, izpzp.com
 * FileName: FtpConfiger.java
 * Date:     2013-2-25 下午2:56:18
 */
package com.izpzp.mash.ftp.service;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.Resource;

import com.izpzp.mash.ftp.intf.FtpConfig;



/**
 * ftp配置
 * 
 */
public class FtpConfiger {
    /**
     * 配置文件
     */
    private Resource resource;

    /**
     * 
     * 读取配置
     * 
     * @param in 配置
     * @return FTP配置
     */
    public Map<String, List<FtpConfig>> readConfig() {
        try {
            InputStream reader = resource.getInputStream();
            return readConfig(reader);
        } catch (IOException e) {
            throw new RuntimeException("ftpUtils出错.0001", e);
        }
    }

    /**
     * 
     * 读取配置
     * 
     * @param in 配置
     * @return FTP配置
     */
    public Map<String, List<FtpConfig>> readConfig(InputStream in) {
        try {
            Map<String, List<FtpConfig>> ftps = new HashMap<String, List<FtpConfig>>();
            // 解析XML
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(in);
            List<?> serverList = doc.getRootElement().elements("server");
            for (Object o : serverList) {
                Element e = (Element) o;
                String type = e.attribute("type").getText();
                String ip = e.element("ip").getTextTrim();
                int port = Integer.parseInt(e.element("port").getTextTrim());
                String userName = e.element("userName").getTextTrim();
                String password = e.element("password").getTextTrim();
                String encoding = e.element("encoding").getTextTrim();
                // 连接FTP
                FtpConfig ftpConfig = new FtpConfig();
                ftpConfig.setIp(ip);
                ftpConfig.setPort(port);
                ftpConfig.setUserName(userName);
                ftpConfig.setPassword(password);
                ftpConfig.setEncoding(encoding);
                List<FtpConfig> list = ftps.get(type);
                if (list == null) {
                    list = new ArrayList<FtpConfig>();
                    ftps.put(type, list);
                }
                list.add(ftpConfig);
            }
            return ftps;
        } catch (Exception e) {
            throw new RuntimeException("ftpUtils出错.0007", e);
        }
    }

    /**
     * @return the resource
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * @param resource the resource to set
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

}
