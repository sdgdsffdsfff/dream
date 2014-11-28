package com.izpzp.mash.intf;

import java.util.List;

import org.apache.http.Header;
import org.apache.http.cookie.Cookie;

/**
 * 〈一句话功能简述〉<br>
 * 
 */
public class HttpClientResponseBean {

    private String response;
    private List<Header> headers;
    private List<Cookie> cookies;

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return the headers
     */
    public List<Header> getHeaders() {
        return headers;
    }

    /**
     * @param headers the headers to set
     */
    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    /**
     * @return the cookies
     */
    public List<Cookie> getCookies() {
        return cookies;
    }

    /**
     * @param cookies the cookies to set
     */
    public void setCookies(List<Cookie> cookies) {
        this.cookies = cookies;
    }

}
