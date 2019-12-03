package com.jbos.app.sys.service;

import com.jbos.app.sys.pojo.LoginInfo;

/**
 * UserAuthServiceImpl
 * @author youfu.wang
 * @date 2019-01-31
 */
public interface UserAuthService {
	/**
	 * 得到用户信息
	 * @param username
	 * @param password
	 * @return
	 */
	public LoginInfo auth(String username);

}
