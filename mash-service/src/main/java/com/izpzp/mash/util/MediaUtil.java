/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: MediaUtil.java
 * Date:     2014-12-5 上午11:39:07
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.util;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.izpzp.mash.ftp.service.FtpUtilImpl;

/**
 * 媒体文件操作-上传下载<br> 
 * 媒体文件操作-上传下载
 *
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class MediaUtil {
    
    /*
     * 图片默认目录
     */
    private static final String IMG_COMMON_DIR = "ROOT/uploadImg";
    
    @Autowired
    FtpUtilImpl ftpUtilImpl;
    
    @Autowired
    PropertyConfigurer propertyConfiger;
    
    /**
     * 图片上传-通用
     */
    public String upLoadImg(byte[] bt, String imgName, String imgType){
        String result = null;
        //生成文件名
        String[] suffixArray = imgName.split("\\.");// 分解文件名
        String fileSuffix = suffixArray[suffixArray.length - 1];// 获取后缀名
        String fileName = String.valueOf(System.currentTimeMillis())
                + String.valueOf((new Random().nextInt(99999)))
                 + "." +  fileSuffix;
        //生成上传目录
        String imgDateDir = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String imgDir = IMG_COMMON_DIR + "/" + imgDateDir;
        boolean ftpFlag = false;
        if(null != bt){
            try {
                // 获取文件流
                ByteArrayInputStream bais = new ByteArrayInputStream(bt);
                // 上传logo图
                ftpFlag = ftpUtilImpl.upLoad(bais, imgDir,
                        fileName, "NGINX");
            } catch (Exception e) {
            }
        }
        if(ftpFlag){
            String imgHost = propertyConfiger.getProperty("imgRoot");
            result = imgHost + "/" + imgDir + "/" + fileName;
        }
        return result;
    }
}
