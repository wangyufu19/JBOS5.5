package com.jbos.interfaces.webservice;

import javax.jws.WebService;

@WebService(
        name="UserService",
        targetNamespace ="http://webservice.interfaces.jbos.com"
)
public interface UserService {
    public String getUserInfo(String username);
}
