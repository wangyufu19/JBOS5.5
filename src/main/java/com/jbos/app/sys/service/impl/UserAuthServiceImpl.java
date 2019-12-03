package com.jbos.app.sys.service.impl;

import com.jbos.app.sys.pojo.LoginInfo;
import com.jbos.app.sys.mapper.UserMapper;
import com.jbos.app.sys.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * UserAuthServiceImpl
 * @author youfu.wang
 * @date 2019-01-31
 */
@Service("userAuthService")
public class UserAuthServiceImpl  implements UserAuthService {
	@Autowired
	private UserMapper userMapper;
	/**
	 * 得到用户信息
	 * @param username
	 * @return
	 */
	public LoginInfo auth(String username) {
		LoginInfo loginInfo=null;
		Map<String, Object> parameterObject=new HashMap<String, Object>();
		parameterObject.put("username",username);
		loginInfo=userMapper.auth(parameterObject);
		return loginInfo;
	}
}
