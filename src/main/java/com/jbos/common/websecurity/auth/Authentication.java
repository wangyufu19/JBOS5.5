package com.jbos.common.websecurity.auth;

import com.jbos.common.data.UserObject;

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
    public abstract UserObject getAuthenticationInfo(String username,String password);
}
