/*
 * Copyright (C), 2002-2014, izpzp.com
 * FileName: WeiXin.java
 * Author:   izpzp
 * Date:     2014-11-17 下午12:01:24
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izpzp.mash.controller.WriteHtmlUtils;
import com.izpzp.mash.weixin.intf.WeiXinService;
import com.izpzp.mash.weixin.service.WeiXinUtil;


/**
 * 微信请求<br> 
 * 微信请求接口
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class WeiXinController {
    
    @Autowired
    WeiXinService weiXinService;
    
    /**
     * 功能描述: <br>
     * 接收微信请求数据
     * @throws IOException 
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("weixin/{mpId}")
    public void accept(HttpServletRequest request, 
            HttpServletResponse response, 
            @PathVariable Integer mpId, 
            String signature, String timestamp, String nonce, String echostr) throws IOException{
        String html = "fail";
        /*
         * signature:微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
         * timestamp:时间戳
         * nonce:随机数
         * echostr:随机字符串 - 若为第一次则这个字段不为空，则返回原样数据（echostr）;若为空，则认为是发送消息
         */
        //从数据库中获取 Token
        String token = null;
        if(null != mpId){
            //通过mpId查询出要验证的公共账号的token
            token = weiXinService.getAccountToken(mpId);
        }
        if(StringUtils.isNotBlank(token)){
            //校验
            boolean checkResult = WeiXinUtil.checkSignature(signature, token, timestamp, nonce);
            //校验成功
            if(checkResult){
                if(StringUtils.isNotBlank(echostr)){
                    //echostr字段不为空则直接返回该字段的值
                    html = echostr;
                }else{
                    //echostr字段为空则继续处理返回空串
                    String xml = getPostXml(request);
                    html = weiXinService.acceptMsg(xml);
                }
            }
        }
        WriteHtmlUtils.write(html, response);
    }
    
    /*
     * 从请求中获取post的数据
     */
    private String getPostXml(HttpServletRequest request) throws IOException{
        StringBuffer sb = new StringBuffer();
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String s = "";
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        String xml = sb.toString(); //次即为接收到微信端发送过来的xml数据
        return xml;
    }
    
}
