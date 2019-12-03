package com.jbos.app.sys.pojo;



/**
 * LoginInfo
 * @author youfu.wang
 * @date 2019-01-31
 */

public class LoginInfo extends BaseEntity{
	public static final String ADMINUSER="admin";

	private String loginName;

	private String username;

	private String password;	
	private String salt;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

}
