/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: MediaController.java
 * Date:     2014-12-4 下午4:49:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.admin.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.izpzp.mash.controller.WriteHtmlUtils;
import com.izpzp.mash.util.MediaUtil;

/**
 * 媒体文件操作<br> 
 * 媒体文件操作-上传
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RequestMapping("admin")
@Controller
public class MediaController {
    
    @Autowired
    MediaUtil mediaUtil;
    
    /**
     * 功能描述: <br>
     * 图片上传
     *
     * @param actLogoImg
     * @return
     * @throws IOException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/imgUpload")
    public void imgUpload(HttpServletResponse response,
            MultipartFile img) throws IOException{
        Map<String, Object> result = new HashMap<String, Object>();
        // 新建输出流
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // 拷贝
        try {
            IOUtils.copy(img.getInputStream(), os);
            String imgUrl = mediaUtil.upLoadImg(os.toByteArray(), img.getOriginalFilename(), img.getContentType());
            if(StringUtils.isNotBlank(imgUrl)){
                result.put("succFlag", true);
                result.put("msg", "图片上传成功！");
                result.put("imgUrl", imgUrl);
            }else{
                result.put("succFlag", false);
                result.put("msg", "图片上传失败！");
            }
        } catch (IOException e) {
            result.put("succFlag", false);
            result.put("msg", "图片上传失败！");
        }
        WriteHtmlUtils.write(new Gson().toJson(result), response);
    }
    
}
