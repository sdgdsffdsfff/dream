/*
 * Copyright (C), 2002-2013, izpzp.com
 * FileName: FtpConfig.java
 * Date:     2013-2-25 下午2:56:18
 */
package com.izpzp.mash.ftp.intf;

/**
 * ftp配置
 */
public class FtpConfig {
    /**
     * ip
     */
    String ip;
    /**
     * 端口
     */
    int port;
    /**
     * 用户名
     */
    String userName;
    /**
     * 密码
     */
    String password;
    /**
     * 编码
     */
    String encoding;

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the encoding
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * @param encoding the encoding to set
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

}
