package com.jbos.common.websecurity.session;

import com.jbos.app.sys.pojo.User;
import com.jbos.common.data.UserObject;
import com.jbos.common.utils.JsonUtils;
import com.jbos.common.websecurity.auth.AuthCookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * SessionManager
 * @author youfu.wang
 * @date 2019-10-28
 */
public class SessionManager {
    /**
     * 默认超时时间60分钟，单位：秒
     */
    public static final int DEFAULT_TIMEOUT=60*60;
    /**
     * 会话超时时间
     */
    public int sessionTimeout=DEFAULT_TIMEOUT;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private SessionCache sessionCache;
    /**
     * 启用缓存
     */
    private boolean enableCache=false;

    public static String getSessionKey(String key){
        return "session:"+key;
    }
    /**
     * 设置会话超时时间
     * @param sessionTimeout
     */
    public void setSessionTimeout(int sessionTimeout){
        this.sessionTimeout=sessionTimeout;
    }

    /**
     * 设置启用缓存
     * @param enableCache
     */
    public void setEnableCache(boolean enableCache){
        this.enableCache=enableCache;
    }

    /**
     * 设置HttpServletRequest
     * @param request
     */
    public void setRequest(HttpServletRequest request){
        this.request=request;
    }

    /**
     * 设置HttpServletResponse
     * @param response
     */
    public void setResponse(HttpServletResponse response){
        this.response=response;
    }

    /**
     * 设置SessionCache
     * @param sessionCache
     */
    public void setSessionCache(SessionCache sessionCache){
        this.sessionCache=sessionCache;
    }

    /**
     * 添加用户会话
     * @param userObject
     */
    public void addUserSession(UserObject userObject){
        if(userObject==null||"".equals(userObject.getUid())){
            return;
        }
        //启用缓存
        if(this.enableCache&&sessionCache!=null){
            //添加用户会话Cookie数据
            AuthCookie authCookie=new AuthCookie(request,response);
            authCookie.addCookieValue(AuthCookie.GSID,SessionManager.getSessionKey(userObject.getUid()));
            //添加用户会话缓存数据
            sessionCache.add(SessionManager.getSessionKey(userObject.getUid()), JsonUtils.toJson(userObject),sessionTimeout);
        }else{
            HttpSession session=request.getSession(false);
            if(session!=null){
                session.removeAttribute(session.getId());
                session.setAttribute(session.getId(),userObject);
            }
        }
    }

    /**
     * 删除用户会话
     */
    public void deleteUserSession(){
        //启用缓存
        if(this.enableCache&&sessionCache!=null){
            //删除用户会话Cookie数据
            AuthCookie authCookie=new AuthCookie(request,response);
            String gsidKey=authCookie.getCookieValue(AuthCookie.GSID);
            if(null==gsidKey||"".equals(gsidKey)){
                return;
            }
            authCookie.deleteCookieValue(AuthCookie.GSID);
            //删除用户会话缓存数据
            sessionCache.delete(gsidKey);
        }else{
            HttpSession session=request.getSession(false);
            if(session!=null){
                session.removeAttribute(session.getId());
            }
        }
    }

    /**
     * 得到用户会话对象
     * @return
     */
    public UserObject getUserObject(){
        UserObject userObject=null;
        //启用缓存
        if(this.enableCache&&sessionCache!=null){
            AuthCookie authCookie=new AuthCookie(request,response);
            String gsidKey=authCookie.getCookieValue(AuthCookie.GSID);
            if(null==gsidKey||"".equals(gsidKey)){
                return null;
            }
            Object sidValue=sessionCache.get(gsidKey);
            if(null==sidValue||"".equals(sidValue)){
                return null;
            }
            userObject=JsonUtils.fromJson(String.valueOf(sidValue),UserObject.class);
        }else{
            HttpSession session=request.getSession(false);
            if(session!=null){
                userObject=(UserObject)session.getAttribute(session.getId());
            }
        }
        return userObject;
    }

    /**
     * 用户会话超时
     * @return
     */
    public boolean isSessionTimeout(){
        UserObject userObject=this.getUserObject();
        if(userObject==null) {
            return true;
        }else{
            return false;
        }
    }
}

