package com.jbos.app.sys.controller;

import com.jbos.app.sys.pojo.Func;
import com.jbos.app.sys.service.FuncMgrService;
import com.jbos.common.data.UserObject;
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
public class FuncMgrController extends BaseController{
    @Autowired
    private FuncMgrService funcMgrService;
    /**
     * 查询用户功能权限列表
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserFuncList", method = RequestMethod.GET)
    public Return getUserFuncList(String username) {
        List<Func> funcList=null;
        UserObject userObject=this.getUserObject();
        if(userObject!=null){
            funcList=funcMgrService.getUserFuncList(userObject.getUid(),userObject.getUsername());
        }
        return Return.ok().put("funcList",funcList);
    }
}
