package com.jbos.app.sys.service;
import com.jbos.common.data.UserObject;

import java.util.Map;

/**
 * UserAuthServiceImpl
 * @author youfu.wang
 * @date 2019-01-31
 */
public interface UserAuthService {
	/**
	 * 用户认证
	 * @param username
	 * @return
	 */
	public Map<String, Object> auth(String username);
	/**
	 * 查询用户信息
	 * @param username
	 * @return
	 */
	public UserObject getUserInfo(String username);

}
