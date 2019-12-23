package com.jbos.app.sys.service;

import com.jbos.infrastructure.websecurity.auth.Authentication;
import com.jbos.infrastructure.websecurity.auth.AuthenticationInfo;
import com.jbos.infrastructure.websecurity.exception.AuthenticationException;
import com.jbos.infrastructure.websecurity.exception.UserIncorrectException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * UserAuthentication
 * @author youfu.wang
 * @date 2019-10-28
 */
@Component
public class UserAuthentication extends Authentication{
    @Autowired
    private UserAuthService userAuthService;

    @Override
    public AuthenticationInfo getAuthenticationInfo(String username, String password) throws AuthenticationException {
        //用户验证
        Map<String, Object> authMap=userAuthService.auth(username);
        if(authMap==null){
            throw new UserIncorrectException("对不起,用户或密码不正确！");
        }
        AuthenticationInfo authenticationInfo=new AuthenticationInfo(username,password);
        return authenticationInfo;
    }
}
