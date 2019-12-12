package com.jbos.infrastructure.websecurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jbos.infrastructure.websecurity.auth.Authentication;
import com.jbos.infrastructure.websecurity.auth.AuthenticationInfo;
import com.jbos.infrastructure.websecurity.exception.AuthenticationException;
import com.jbos.infrastructure.websecurity.session.SessionManager;

/**
 * WebSecurityManager
 * @author youfu.wang
 * @date 2019-10-28
 */
public class WebSecurityManager {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private SessionManager sessionManager;
    private Authentication authentication;

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

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    /**
     * 登录
     * @param username
     * @param password
     */
    public void login(String username,String password) throws AuthenticationException {
        AuthenticationInfo authenticationInfo=null;
        if(this.authentication!=null){
            authenticationInfo=this.authentication.getAuthenticationInfo(username,password);
        }
        if(this.sessionManager!=null&&authenticationInfo!=null){
            this.sessionManager.setRequest(request);
            this.sessionManager.setResponse(response);
            this.sessionManager.addSessionAuthenticationInfo(authenticationInfo);
        }
    }

    /**
     * 登出
     */
    public void logout(){
        if(this.sessionManager!=null){
            this.sessionManager.setRequest(request);
            this.sessionManager.setResponse(response);
            this.sessionManager.deleteSessionAuthenticationInfo();
        }
    }
}
