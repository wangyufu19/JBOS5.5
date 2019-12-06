package com.jbos.app.sys.service.impl;

import com.jbos.app.sys.mapper.UserMapper;
import com.jbos.app.sys.service.UserAuthService;
import com.jbos.common.data.UserObject;
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
	 * 用户认证
	 * @param username
	 * @return
	 */
	public Map<String, Object> auth(String username) {
		Map<String, Object> dataMap=null;
		Map<String, Object> parameterObject=new HashMap<String, Object>();
		parameterObject.put("username",username);
		dataMap=userMapper.auth(parameterObject);
		return dataMap;
	}
	/**
	 * 查询用户信息
	 * @param username
	 * @return
	 */
	public UserObject getUserInfo(String username){
		UserObject userObject=new UserObject();
		Map<String, Object> dataMap=null;
		Map<String, Object> parameterObject=new HashMap<String, Object>();
		parameterObject.put("username",username);
		dataMap=userMapper.getUserInfo(parameterObject);
		if(dataMap!=null){
			userObject.setUid(String.valueOf(dataMap.get("ID")));
			userObject.setLoginName(String.valueOf(dataMap.get("LOGIN_NAME")));
			userObject.setUsername(String.valueOf(dataMap.get("USER_NAME")));
			userObject.setUserStatus(String.valueOf(dataMap.get("USER_STATUS")));
			userObject.setOrgId(String.valueOf(dataMap.get("ORG_ID")));
			userObject.setDepId(String.valueOf(dataMap.get("DEP_ID")));
		}
		return userObject;
	}
}
