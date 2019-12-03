package com.jbos.app.sys.mapper;
import java.util.List;
import java.util.Map;

import com.jbos.app.sys.pojo.LoginInfo;
import com.jbos.app.sys.pojo.User;

/**
 * UserMapper
 * @author youfu.wang
 * @date 2019-01-31
 */
public interface UserMapper{
	/**
	 * 用户认证
	 * @param username
	 * @return
	 */
	public LoginInfo auth(Map<String, Object> parameterObject);
	/**
	 * 得到用户信息
	 * @param parameterObject
	 * @return
	 */
	public User getUserInfo(Map<String, Object> parameterObject);
	/**
	 * 得到用户信息列表
	 * @return
	 */
	public List<User> getUserList();
}
