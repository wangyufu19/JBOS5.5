package com.jbos.common.shiro;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jbos.app.sys.pojo.LoginInfo;
import com.jbos.app.sys.service.UserAuthService;
/**
 * 用户认证
 * @author youfu.wang
 * @date 2019-01-31
 */
@Component
public class UserRealm extends AuthorizingRealm {
	@Autowired
	private UserAuthService userAuthService;
	/**
	 * 授权
	 * @param principals
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("==================doGetAuthorizationInfo");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<String> permissions = new ArrayList<String>();
		info.addStringPermissions(permissions);
		return info;
	}
	/**
	 * 认证
	 * @param authtoken
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authtoken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authtoken;
		LoginInfo loginInfo=null;
		loginInfo=userAuthService.auth(token.getUsername());
		if(loginInfo==null) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginInfo, loginInfo.getPassword(), ByteSource.Util.bytes(loginInfo.getSalt()), getName());
		return info;
	}

	/**
	 * @param credentialsMatcher
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
		shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
		shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
		super.setCredentialsMatcher(shaCredentialsMatcher);
	}
}
