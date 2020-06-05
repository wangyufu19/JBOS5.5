package com.jbos.app.sys.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jbos.app.sys.pojo.Func;
import com.jbos.app.sys.mapper.FuncMapper;
import com.jbos.app.sys.service.FuncMgrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FuncMgrServiceImpl
 * @author youfu.wang
 * @date 2019-01-31
 */
@Service("funcMgrService")
public class FuncMgrServiceImpl implements FuncMgrService {
    @Autowired
    private FuncMapper mapper;
    /**
     * 查询用户菜单权限列表
     * @param loginName
     * @return
     */
    public List<Func> getUserFuncList(String userid, String loginName){
        List<Func> menuList = new ArrayList<Func>();
        List<Func> menus=null;
        //得到根菜单
        menus=this.getFuncByParentId(Func.ROOTFUNC_ID);
        menuList=this.getMenuTree(menus);
        return menuList;
    }

    /**
     * 根据父ID查询菜单数据
     * @param parentId
     * @return
     */
    private List<Func> getFuncByParentId(String parentId){
        List<Func> menus=null;
        Map<String,Object> parameterObject=new HashMap<String,Object>();
        parameterObject.put("parentId",parentId);
        menus=mapper.getUserFuncList(parameterObject);
        return menus;
    }

    /**
     * 递归根据父ID查询菜单数据
     * @param menus
     * @return
     */
    private List<Func> getMenuTree(List<Func> menus){
        List<Func> subMenuList = new ArrayList<Func>();
        for(Func menu:menus){
            if(Func.FUNCTYPE_DIR.equals(menu.getFuncType())){
                menus=this.getFuncByParentId(menu.getId());
                menu.setList(this.getMenuTree(menus));
            }
            subMenuList.add(menu);
        }
        return subMenuList;
    }

}
