package com.jbos.app.sys.controller;

import com.jbos.app.sys.pojo.LoginInfo;
import com.jbos.app.sys.pojo.Menu;
import com.jbos.app.sys.service.MenuMgrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * FuncMgrController
 * @author youfu.wang
 * @date 2019-03-01
 */
@Controller
@RequestMapping("/menu")
public class MenuMgrController extends BaseController{
    @Autowired
    private MenuMgrService menuMgrService;
    /**
     * 查询用户菜单权限列表
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserMenuList", method = RequestMethod.GET)
    public Return getUserMenuList(String username) {
        List<Menu> menuList=null;
        LoginInfo loginInfo=this.getLoginInfo();
        if(loginInfo!=null){
            menuList=menuMgrService.getUserMenuList(loginInfo.getId(),loginInfo.getLoginName());
        }
        return Return.ok().put("menuList",menuList);
    }
}
