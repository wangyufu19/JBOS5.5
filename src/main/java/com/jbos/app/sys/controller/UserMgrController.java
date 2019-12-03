package com.jbos.app.sys.controller;
import java.util.HashMap;
import java.util.Map;

import com.jbos.app.sys.pojo.LoginInfo;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jbos.app.sys.service.UserMgrService;

/**
 * 用户管理控制器类
 * @author youfu.wang
 * @date 2019-03-01
 */
@Controller
@RequestMapping("/user")
public class UserMgrController extends  BaseController{
    @Autowired
    private UserMgrService userMgrService;

    /**
     * 得到用户登录信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserLoginInfo")
    public Return getUserLoginInfo(){
        LoginInfo loginInfo=this.getLoginInfo();
        return Return.ok().put("user",loginInfo);
    }
    /**
     * 查询用户数据列表
     * @param params
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserList")
    public Return getUserList(Map<String, Object> params){
        Map<String, Object> retDatas=new HashMap<String, Object>();
        return Return.ok().put("retDatas", retDatas);
    }
}
