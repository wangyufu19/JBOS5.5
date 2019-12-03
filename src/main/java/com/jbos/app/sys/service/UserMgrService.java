package com.jbos.app.sys.service;

import java.util.Map;
import com.jbos.app.sys.pojo.User;

/**
 * UserMgrService
 * @author youfu.wang
 * @date 2019-01-31
 */
public interface UserMgrService {
	/**
	 * 查询用户数据列表
	 * @param params
	 * @return
	 */
	public void getUserList(Map<String, Object> params);

	/**
	 * 更新用户信息
	 * @param user
	 */
	public void updateUserInfo(User user);
}
