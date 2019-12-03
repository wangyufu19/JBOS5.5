package com.jbos.app.sys.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbos.app.sys.pojo.LoginInfo;
import com.jbos.common.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import java.util.List;
import java.util.Map;

/**
 * BaseController
 * @author youfu.wang
 * @date 2019-01-31
 */
public class BaseController {

	protected LoginInfo getLoginInfo() {
		return (LoginInfo) SecurityUtils.getSubject().getPrincipal();
	}
	protected Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	/**
	 * 开始分页
	 * @param page
	 */
	public void doStargPage(Map<String, Object> page){
		int pageNum=Integer.parseInt(StringUtils.replaceNull(page.get("page")));
		int pageSize=Integer.parseInt(StringUtils.replaceNull(page.get("limit")));
		PageHelper.startPage(pageNum,pageSize);
	}

	/**
	 * 完成分页
	 * @param ret
	 * @param datas
	 */
	public void doFinishPage(Return ret, List datas){
		PageInfo pageInfo=new PageInfo(datas);
		ret.put("page",pageInfo);
	}
}
