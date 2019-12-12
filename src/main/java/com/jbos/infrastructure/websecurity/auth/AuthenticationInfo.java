package com.jbos.infrastructure.websecurity.auth;
/**
 * AuthenticationInfo
 * @author youfu.wang
 * @date 2019-10-28
 */
public class AuthenticationInfo {
    private String username;

    private String password;

    /**
     * 构造方法
     * @param username
     * @param password
     */
    public AuthenticationInfo(String username, String password){
        this.username=username;
        this.password=password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
