package com.jbos.infrastructure.websecurity.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AuthCookie
 * @author youfu.wang
 * @date 2019-10-28
 */
public class AuthCookie {
    /**
     * 默认过期时长60分钟，单位：秒
     */
    public static final int DEFAULT_EXPIRE=60*60;
    public static final String GSID="gsid";
    /**
     * 过期时长
     */
    public int expire=DEFAULT_EXPIRE*24*365;

    private HttpServletRequest request;
    private HttpServletResponse response;

    /**
     * 构造方法
     * @param request
     * @param response
     */
    public AuthCookie(HttpServletRequest request,HttpServletResponse response){
        this.request=request;
        this.response=response;
    }

    /**
     * 设置过期时长
     * @param expire
     */
    public void setExpire(int expire){
        this.expire=expire;
    }

    /**
     * 添加Cookie值
     * @param key
     * @param value
     */
    public void addCookieValue(String key,String value){
        Cookie cookie=new Cookie(key,value);
        cookie.setPath("/");
        cookie.setMaxAge(expire);
        response.addCookie(cookie);
    }

    /**
     * 删除Cookie值
     * @param key
     */
    public void deleteCookieValue(String key){
        Cookie[] cookies=request.getCookies();
        if(cookies==null){
            return;
        }
        for(Cookie cookie:cookies){
            if(key.equals(cookie.getName())){
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
    }

    /**
     * 得到Cookie值
     * @param key
     * @return
     */
    public String getCookieValue(String key){
        String value="";
        Cookie[] cookies=request.getCookies();
        if(cookies==null){
            return value;
        }
        for(Cookie cookie:cookies){
            if(key.equals(cookie.getName())){
                value=cookie.getValue();
                break;
            }
        }
        return value;
    }
}
