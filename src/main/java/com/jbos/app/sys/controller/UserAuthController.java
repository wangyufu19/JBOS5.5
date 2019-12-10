package com.jbos.app.sys.controller;

import javax.servlet.http.HttpServletRequest;

import com.jbos.app.sys.service.UserMgrService;
import com.jbos.common.shiro.ShiroUtils;
import com.jbos.common.spring.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 用户认证控制器类
 * @author youfu.wang
 * @date 2019-01-29
 */
@Controller
@RequestMapping("/websecurity")
@Slf4j
public class UserAuthController extends BaseController{

	@Autowired
	private UserMgrService userMgrService;
	/**
	 * 得到登录页面
	 * @return
	 */
	@RequestMapping("/getLogin")
	public String getLogin(HttpServletRequest request) {
		log.info("******RedisTemplate: "+ SpringContextHolder.getApplicationContext().getBean("redisTemplate"));
		return "login";
	}

	/**
	 * 用户登录
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Return login(String username, String password) {
		try{
			Subject subject = ShiroUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);			
		}catch (UnknownAccountException e) {			
			return Return.error("账号或密码不正确");
		}catch (IncorrectCredentialsException e) {			
			return Return.error("账号或密码不正确");
		}catch (LockedAccountException e) {			
			return Return.error("账号已被锁定,请联系管理员");
		}catch (AuthenticationException e) {			
			return Return.error("账户验证失败");
		}
		return Return.ok();
	}
}
