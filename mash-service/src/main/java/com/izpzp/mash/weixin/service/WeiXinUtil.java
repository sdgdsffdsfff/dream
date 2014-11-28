/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: WeiXinUtil.java
 * Author:   13075787
 * Date:     2014-11-17 下午3:03:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.izpzp.mash.weixin.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * WeiXinUtil<br> 
 * WeiXinUtil
 *
 * @author izpzp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WeiXinUtil {
    
    /**
     * 功能描述: <br>
     * 验证
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static boolean checkSignature(String signature, String token, String timestamp, String nonce){
        String[] ArrTmp = {token, timestamp, nonce};
        Arrays.sort(ArrTmp);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ArrTmp.length; i++) {
            sb.append(ArrTmp[i]);
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");//选择SHA-1，也可以选择MD5
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = md.digest(sb.toString().getBytes());
        String mySignature = byte2hex(digest);
        if(null != signature && signature.equals(mySignature)){
            //校验通过
            return true;
        }else{
            //校验不通过
            return false;
        }
    }
    
    /*
     * 转换
     */
    private static String byte2hex(byte[] b) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < b.length; i++) {
            tmp = (Integer.toHexString(b[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
    
}
