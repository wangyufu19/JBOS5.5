package com.jbos.infrastructure.websecurity.auth;


import com.jbos.infrastructure.websecurity.exception.AuthenticationException;
import com.jbos.infrastructure.websecurity.exception.UserIncorrectException;

/**
 * Authentication
 * @author youfu.wang
 * @date 2019-10-28
 */
public abstract class Authentication {
    /**
     * 得到认证信息
     * @param username
     * @param password
     * @return
     */
    public abstract AuthenticationInfo getAuthenticationInfo(String username,String password) throws AuthenticationException;
}
