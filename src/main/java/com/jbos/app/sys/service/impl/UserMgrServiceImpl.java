package com.jbos.app.sys.service.impl;
import java.util.Map;

import com.jbos.app.sys.pojo.User;
import com.jbos.app.sys.service.UserMgrService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserMgrServiceImpl
 * @author youfu.wang
 * @date 2019-01-31
 */
@Service("userMgrService")
public class UserMgrServiceImpl implements UserMgrService {
	/**
	 * 查询用户数据列表
	 * @param params
	 * @return
	 */
	public void getUserList(Map<String, Object> params) {
//		 Page<User> page=null;
//		 page= this.selectPage(
//				 new PageQuery<User>(params).getPage(),
//	             new EntityWrapper<User>());
//		 return new PageObject(page);
		return;
	}
	/**
	 * 更新用户信息
	 * @param user
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void updateUserInfo(User user){

	}
}
