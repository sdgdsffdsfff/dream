/*
 * Copyright (C), 2002-2013, izpzp
 * FileName: HttpClientUtil.java
 * Date:     2013-3-27 上午00:00:00
 */
package com.izpzp.mash.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import com.izpzp.mash.intf.HttpClientResponseBean;

/**
 * 
 * http发送工具
 * 
 */
public final class HttpClientUtil {

    /**
     * 
     */
    private static PoolingClientConnectionManager pccm = null;

    /**
     * 
     */
    private static HttpParams params = null;

    /**
     * 
     */
    private static HttpClient httpClient = null;

    /**
     * 
     */
    private static int errorCount = 0;

    /**
     * 
     */
    private static final int ERROR_MAX_COUNT = 100;

    /**
     * 锁
     */
    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 
     * 初始化
     * 
     */
    public static HttpClient init() {
        try {
            lock.writeLock().lock();

            if (httpClient != null && errorCount < ERROR_MAX_COUNT) {
                return httpClient;
            }

            if (pccm != null) {
                pccm.shutdown();
            }

            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] arg0, String arg1) 
                        throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] arg0, String arg1) 
                        throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            // 设置访问协议
            SchemeRegistry schreg = new SchemeRegistry();
            schreg.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
            schreg.register(new Scheme("https", 443, ssf));

            pccm = new PoolingClientConnectionManager(schreg);
            pccm.setDefaultMaxPerRoute(2000); // 每个主机的最大并行链接数
            pccm.setMaxTotal(10000); // 客户端总并行链接最大数

            // 设置组件参数, HTTP协议的版本,1.1/1.0/0.9
            params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setUserAgent(params, "HttpComponents/1.1");
            HttpProtocolParams.setUseExpectContinue(params, true);

            // 设置连接超时时间
            int REQUEST_TIMEOUT = 30 * 1000; // 设置请求超时30秒钟
            int SO_TIMEOUT = 30 * 1000; // 设置等待数据超时时间30秒钟
            // HttpConnectionParams.setConnectionTimeout(params, REQUEST_TIMEOUT);
            // HttpConnectionParams.setSoTimeout(params, SO_TIMEOUT);
            params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, REQUEST_TIMEOUT);
            params.setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);
            httpClient = new DefaultHttpClient(pccm, params);
        } catch (Exception e) {
            httpClient = new DefaultHttpClient(params);
        } finally {
            lock.writeLock().unlock();
        }
        errorCount = 0;
        return httpClient;
    }

    /**
     * 
     * 发送http请求
     * 
     * @param url 请求地址
     * @param data 请求报文
     * @return 返回报文
     */
    public static String postData(String url, String data) {
        return postData(url, data, null, null, null, null, null);
    }

    /**
     * 
     * 发送http请求
     * 
     * @param url 请求地址
     * @param data 请求报文
     * @param contentType contentType
     * @return 返回报文
     */
    public static String postData(String url, String data, ContentType contentType) {
        return postData(url, data, null, null, null, null, contentType);
    }

    /**
     * 
     * 发送http请求
     * 
     * @param url 请求地址
     * @param data 请求报文
     * @param headers 请求头
     * @return 返回报文
     */
    public static String postData(String url, String data, Map<String, String> headers) {
        return postData(url, data, null, null, headers, null, null);
    }

    /**
     * 
     * 发送http请求
     * 
     * @param url 请求地址
     * @param formData form数据
     * @return 返回报文
     */
    public static String postData(String url, Map<String, String> formData) {
        return postData(url, null, formData, null, null, null, null);
    }

    /**
     * 
     * 发送http请求multipart/form-data
     * 
     * @param url 请求地址
     * @param multipartformData form数据
     * @return 返回报文
     */
    public static String postData(String url, List<FormBodyPart> multipartformData) {
        return postData(url, null, null, multipartformData, null, null, null);
    }

    /**
     * 
     * 发送http请求
     * 
     * @param url 请求地址
     * @param data 请求报文
     * @param cookie
     * @return 返回报文
     */
    public static String postData(String url, String data, String cookie) {
        return postData(url, data, null, null, null, cookie, null);
    }

    /**
     * 
     * 发送请求数据
     * 
     * @param url 请求地址
     * @param data 请求数据
     * @param formData form数据
     * @param multipartformData multipartform数据
     * @param headers 请求头
     * @param cookie cookie
     * @param contentType contentType
     * @return 返回报文
     */
    public static String postData(String url, String data, Map<String, String> formData,
            List<FormBodyPart> multipartformData, Map<String, String> headers, String cookie, ContentType contentType) {
        try {
            if (httpClient == null || errorCount > ERROR_MAX_COUNT) {
                httpClient = init();
            }
            // 发送请求
            lock.readLock().lock();
            HttpResponse response = getResponse(httpClient, url, data, formData, multipartformData, headers, cookie,
                    contentType, null);
            String result = readResponse(response.getEntity());

            return result;
        } catch (Exception e) {
            errorCount++;
        } finally {
            lock.readLock().unlock();
        }
        return null;
    }

    /**
     * 
     * 发送请求,获取响应头
     * 
     * @param url
     * @param data
     * @return
     */
    public static HttpClientResponseBean retriveHeaderCookieReq(String url, String data) {
        return retriveHeaderCookieReq(url, data, null, null, null, null, null);
    }

    /**
     * 
     * 发送请求,获取响应头
     * 
     * @param url
     * @param data
     * @param cookie
     * @return
     */
    public static HttpClientResponseBean retriveHeaderCookieReq(String url, String data, String cookie) {
        return retriveHeaderCookieReq(url, data, null, null, null, cookie, null);
    }

    /**
     * 
     * 发送请求,获取响应头
     * 
     * @param url
     * @param data
     * @param formData
     * @param multipartFormData
     * @param headers
     * @param cookie
     * @param contentType
     * @return
     */
    public static HttpClientResponseBean retriveHeaderCookieReq(String url, String data, Map<String, String> formData,
            List<FormBodyPart> multipartFormData, Map<String, String> headers, String cookie, ContentType contentType) {
        try {
            if (httpClient == null || errorCount > ERROR_MAX_COUNT) {
                httpClient = init();
            }
            // 创建一个CookieStore的本地实例
            BasicCookieStore cookieStore = new BasicCookieStore();
            // 创建一个本地HttpContext实例
            HttpContext localContext = new BasicHttpContext();
            // 将自定义的CookieStore实例绑定到http上下文对象中
            localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

            // 发送请求
            lock.readLock().lock();
            HttpResponse response = getResponse(httpClient, url, data, formData, multipartFormData, headers, cookie,
                    contentType, localContext);
            // 放入返回bean
            HttpClientResponseBean responseBean = new HttpClientResponseBean();
            responseBean.setHeaders(Arrays.asList(response.getAllHeaders()));
            responseBean.setCookies(cookieStore.getCookies());

            String result = readResponse(response.getEntity());
            // 返回结果
            responseBean.setResponse(result);
            return responseBean;
        } catch (Exception e) {
            errorCount++;
        } finally {
            lock.readLock().unlock();
        }
        return null;
    }

    /**
     * 
     * 获取响应
     * 
     * @param httpclient
     * @param url
     * @param data
     * @param formData
     * @param headers
     * @param cookie
     * @param localContext
     * @return
     */
    private static HttpResponse getResponse(HttpClient httpclient, String url, String data,
            Map<String, String> formData, List<FormBodyPart> multipartFormData, Map<String, String> headers,
            String cookie, ContentType contentType, HttpContext localContext) throws Exception {
        HttpPost httppost = new HttpPost(url);
        if (data != null) {
            StringEntity reqEntity = null;
            if (contentType == null) {
                reqEntity = new StringEntity(data, ContentType.create("text/html", Consts.UTF_8));
            } else {
                reqEntity = new StringEntity(data, contentType);
            }
            httppost.setEntity(reqEntity);
        } else if (formData != null) {
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : formData.entrySet()) {
                formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            if (null != formparams) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
                httppost.setEntity(entity);
            }
        } else if (multipartFormData != null) {
            MultipartEntity entity = new MultipartEntity();
            for (FormBodyPart formBodyPart : multipartFormData) {
                entity.addPart(formBodyPart);
            }
            httppost.setEntity(entity);
        }
        if (null != headers) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httppost.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (null != cookie) {
            httppost.addHeader("Cookie", cookie);
        }
        return httpclient.execute(httppost, localContext);

    }

    /**
     * 
     * 读取返回
     * 
     * @param resEntity
     * @return String 返回
     */
    private static String readResponse(HttpEntity resEntity) {
        StringBuffer res = new StringBuffer();
        BufferedReader reader = null;
        try {
            if (resEntity == null) {
                return null;
            }

            reader = new BufferedReader(new InputStreamReader(resEntity.getContent(), "utf-8"));
            String line = null;

            while ((line = reader.readLine()) != null) {
                res.append(line);
            }

        } catch (Exception e) {
        } finally {

            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }

        }
        return res.toString();
    }

    /**
     * 功能描述: <br>
     * 通过get方式获取资源 〈功能详细描述〉
     * 
     * @param url
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getData(String url, String cookie, String userAgent) {
        // 新建get获取类型
        HttpGet httpGet = new HttpGet(url);
        // 判断cookie是否为空，并进行设置
        if (StringUtils.isNotBlank(cookie)) {
            httpGet.addHeader("Cookie", cookie);
        }
        // 判断userAgent是否为空，并进行设置
        if (StringUtils.isNotBlank(userAgent)) {
            httpGet.addHeader("User-Agent", userAgent);
        }
        // 默认response 内容
        HttpResponse respone = null;
        // 默认返回值内容
        String res = null;
        try {
            if (httpClient == null || errorCount > ERROR_MAX_COUNT) {
                httpClient = init();
            }
            lock.readLock().lock();
            // 执行请求
            respone = httpClient.execute(httpGet);
            // 读取内容
            res = readResponse(respone.getEntity());
        } catch (Exception e) {
            // 出现异常返回空
            return null;
        } finally {
            lock.readLock().unlock();
        }
        return res;
    }
}
