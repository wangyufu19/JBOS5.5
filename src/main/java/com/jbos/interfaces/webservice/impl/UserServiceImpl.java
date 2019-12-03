package com.jbos.interfaces.webservice.impl;

import com.jbos.interfaces.webservice.UserService;

import javax.jws.WebService;

@WebService(
        name="UserService",
        targetNamespace ="http://webservice.interfaces.jbos.com/",
        endpointInterface = "com.jbos.interfaces.webservice.UserService"
)
public class UserServiceImpl implements UserService{
    @Override
    public String getUserInfo(String username) {
        return "user";
    }
}
