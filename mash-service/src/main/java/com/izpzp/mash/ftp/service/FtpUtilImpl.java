/*
 * Copyright (C), 2002-2013, izpzp.com
 * FileName: FtpUtilImpl.java
 * Date:     2013-2-25 下午2:56:18
 */
package com.izpzp.mash.ftp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.izpzp.mash.ftp.intf.FtpConfig;


/**
 * ftp工具
 */
@Component
public class FtpUtilImpl {

    /**
     * 路径分隔符
     */
    private static final String DIR_SEPARATOR = "/";

    /**
     * ftp配置
     */
    @Autowired
    private FtpConfiger ftpConfiger;

    /**
     * ftp配置
     */
    private Map<String, List<FtpConfig>> ftps = null;

    /**
     * {@inheritDoc}
     */
    public boolean upLoad(InputStream in, String path, String fileName, String type) {
        boolean flag = false;
        File tempFile = null;
        try {
            tempFile = File.createTempFile("ftp", null);
            OutputStream out = new FileOutputStream(tempFile);
            Util.copyStream(in, out, Util.DEFAULT_COPY_BUFFER_SIZE, CopyStreamEvent.UNKNOWN_STREAM_SIZE, null, false);
            out.close();
        } catch (Exception e) {
            throw new RuntimeException("ftpUtil出现异常.0004", e);
        }
        flag = upLoad(tempFile, path, fileName, type);
        boolean delFlag = tempFile.delete();
        if (!delFlag) {
        }
        return flag;

    }

    /**
     * {@inheritDoc}
     */
    public boolean upLoad(File file, String path, String fileName, String type) {
        List<FtpConfig> ftpConfigList = getConfig(type);
        boolean flag = true;
        try {
            for (FtpConfig ftpConfig : ftpConfigList) {
                flag = upLoad(ftpConfig, new FileInputStream(file), path, fileName);
                if (!flag) {
                    return false;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("ftpUtil出现异常.0008", e);
        }
        return flag;
    }

    /**
     * 
     * 上传文件
     * 
     * @param ftpConfig ftp配置
     * @param in 上传文件流
     * @param path 文件路径
     * @return boolean 上传是否成功
     * @throws IOException
     */
    private boolean upLoad(FtpConfig ftpConfig, InputStream in, String path, String fileName) throws IOException {
        String localPath = path;
        if (!localPath.endsWith(DIR_SEPARATOR)) {
            localPath = localPath + DIR_SEPARATOR;
        }
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding(ftpConfig.getEncoding());
        ftpClient.connect(ftpConfig.getIp(),ftpConfig.getPort());
        ftpClient.login(ftpConfig.getUserName(), ftpConfig.getPassword());
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        boolean ftpFlag = false;
        try {
            mkdir(ftpClient, localPath);
            ftpFlag = ftpClient.storeFile(fileName, in);
        } finally {
            in.close();
            if (ftpClient.isConnected()) {
                ftpClient.disconnect();
            }
        }
        return ftpFlag;

    }

    private void mkdir(FTPClient ftpClient, String path) throws IOException {
        if (!ftpClient.changeWorkingDirectory(path)) {
            int start = 0;
            int end = 0;
            // 相对路径是否以“/”开头
            if (path.startsWith(DIR_SEPARATOR)) {
                start = 1;

            } else {
                start = 0;

            }
            // 获取从start下标开始出现的第一个"/"的下标
            end = path.indexOf(DIR_SEPARATOR, start);
            while (true) {
                String subDirectory = path.substring(start, end);
                // 当前目录不存在
                if (!ftpClient.changeWorkingDirectory(subDirectory)) {
                    // 创建目录成功（makeDirectory创建成功会返回true）
                    if (ftpClient.makeDirectory(subDirectory)) {
                        // 指向当前新创建的目录
                        ftpClient.changeWorkingDirectory(subDirectory);
                    } else {
                        break;
                    }
                }
                // 设置下级目录起始和结束下标
                start = end + 1;
                end = path.indexOf(DIR_SEPARATOR, start);
                // 已是最后一级目录
                if (end <= start) {
                    break;
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, File> downLoad(String host, String remote, String local, String type, boolean delete) {
        List<FtpConfig> ftpConfigList = getConfig(type);
        Map<String, File> map = null;
        try {
            for (FtpConfig ftpConfig : ftpConfigList) {
                if (ftpConfig.getIp().equals(host)) {
                    map = downLoad(ftpConfig, remote, local, delete);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("ftpUtil出现异常.0008", e);
        }
        return map;
    }

    /**
     * 
     * 下载文件
     * 
     * @param ftpConfig ftp配置
     * @param remote 远程目录
     * @param remote 本地目录
     * @param delete 是否需要删除
     * @return 是否下载成功
     * @throws IOException
     */
    private Map<String, File> downLoad(FtpConfig ftpConfig, String remote, String local, boolean delete)
            throws IOException {
        Map<String, File> fileMap = new HashMap<String, File>();
        boolean tempFlag = false;
        if (local == null) {
            tempFlag = true;
        } else {
            File dir = new File(local);
            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    throw new RuntimeException("ftpUtil出现异常.0008");
                }
            }
        }

        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding(ftpConfig.getEncoding());
        ftpClient.connect(ftpConfig.getIp(),ftpConfig.getPort());
        ftpClient.login(ftpConfig.getUserName(), ftpConfig.getPassword());
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

        try {
            FTPFile[] files = listFiles(ftpClient, remote);
            for (FTPFile ftpFile : files) {
                if (ftpFile.isFile()) {
                    String fileName = ftpFile.getName();
                    File file = null;
                    if (tempFlag) {
                        file = File.createTempFile("uimgDownload", null);
                    } else {
                        file = new File(local + fileName);
                    }
                    boolean success = false;
                    success = downLoadSingleFile(ftpClient, fileName, file);
                    if (success) {
                        fileMap.put(fileName, file);
                        if (delete) {
                            ftpClient.deleteFile(fileName);
                        }
                    }
                }
            }
        } finally {
            if (ftpClient.isConnected()) {
                ftpClient.disconnect();
            }
        }
        return fileMap;

    }

    private boolean downLoadSingleFile(FTPClient ftpClient, String remote, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        boolean ftpFlag = false;
        try {
            ftpFlag = ftpClient.retrieveFile(remote, os);
        } finally {
            os.close();

        }
        return ftpFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean removeDir(String remote, String type) {
        List<FtpConfig> ftpConfigList = getConfig(type);
        boolean flag = true;
        try {
            for (FtpConfig ftpConfig : ftpConfigList) {
                flag = removeDir(ftpConfig, remote);
                if (!flag) {
                    return false;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("ftpUtil出现异常.0008", e);
        }
        return flag;
    }

    /**
     * 
     * 删除文件夹
     * 
     * @param ftpConfig ftp配置
     * @param remote 远程位置
     * @return 是否删除成功
     * @throws IOException
     */
    private boolean removeDir(FtpConfig ftpConfig, String remote) throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding(ftpConfig.getEncoding());
        ftpClient.connect(ftpConfig.getIp(),ftpConfig.getPort());
        ftpClient.login(ftpConfig.getUserName(), ftpConfig.getPassword());
        boolean ftpFlag = true;
        try {
            FTPFile[] files = listFiles(ftpClient, remote);
            for (FTPFile file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    ftpFlag = ftpClient.deleteFile(fileName);
                    if (!ftpFlag) {
                        return ftpFlag;
                    }
                }
            }
        } finally {
            if (ftpClient.isConnected()) {
                ftpClient.disconnect();
            }
        }
        return ftpFlag;
    }

    private FTPFile[] listFiles(FTPClient ftpClient, String remote) throws IOException {
        String[] dirs = remote.split(DIR_SEPARATOR);
        for (String dir : dirs) {
            if (!dir.equals("")) {
                boolean dirFlag = ftpClient.changeWorkingDirectory(dir);
                if (!dirFlag) {
                    if (remote.endsWith(dir)) {
                        return ftpClient.listFiles(dir);
                    }
                }
            }

        }
        return ftpClient.listFiles();
    }

    /**
     * {@inheritDoc}
     */
    public List<FtpConfig> getConfig(String type) {
        if (ftps == null) {
            ftps = ftpConfiger.readConfig();
        }
        List<FtpConfig> ftpConfigList = ftps.get(type);
        if (ftpConfigList == null || ftpConfigList.isEmpty()) {
            throw new RuntimeException("ftpUtil出现异常.0013");
        }
        return ftpConfigList;
    }

    /**
     * @return the ftps
     */
    public Map<String, List<FtpConfig>> getFtps() {
        return ftps;
    }

    /**
     * @param ftps the ftps to set
     */
    public void setFtps(Map<String, List<FtpConfig>> ftps) {
        this.ftps = ftps;
    }

}
