package com.jbos.app.sys.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jbos.app.sys.pojo.Menu;
import com.jbos.app.sys.mapper.MenuMapper;
import com.jbos.app.sys.service.MenuMgrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MenuMgrServiceImpl
 * @author youfu.wang
 * @date 2019-01-31
 */
@Service("menuMgrService")
public class MenuMgrServiceImpl  implements MenuMgrService{
    @Autowired
    private MenuMapper mapper;
    /**
     * 查询用户菜单权限列表
     * @param loginName
     * @return
     */
    public List<Menu> getUserMenuList(String userid,String loginName){
        List<Menu> menuList = new ArrayList<Menu>();
        List<Menu> menus=null;
        //得到根菜单
        menus=this.getMenuByParentId(Menu.ROOTMENU_ID);
        menuList=this.getMenuTree(menus);
        return menuList;
    }

    /**
     * 根据父ID查询菜单数据
     * @param parentId
     * @return
     */
    private List<Menu> getMenuByParentId(String parentId){
        List<Menu> menus=null;
        Map<String,Object> parameterObject=new HashMap<String,Object>();
        parameterObject.put("parentId",parentId);
        menus=mapper.getUserMenuList(parameterObject);
        return menus;
    }

    /**
     * 递归根据父ID查询菜单数据
     * @param menus
     * @return
     */
    private List<Menu> getMenuTree(List<Menu> menus){
        List<Menu> subMenuList = new ArrayList<Menu>();
        for(Menu menu:menus){
            if(Menu.MENUTYPE_DIR.equals(menu.getMenuType())){
                menus=this.getMenuByParentId(menu.getId());
                menu.setList(this.getMenuTree(menus));
            }
            subMenuList.add(menu);
        }
        return subMenuList;
    }

}
