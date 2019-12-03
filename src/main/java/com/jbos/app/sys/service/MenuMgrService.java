package com.jbos.app.sys.service;
import java.util.List;
import com.jbos.app.sys.pojo.Menu;

/**
 * MenuMgrService
 * @author youfu.wang
 * @date 2019-01-31
 */
public interface MenuMgrService {
    /**
     * 查询用户菜单权限列表
     * @param loginName
     * @return
     */
    public List<Menu> getUserMenuList(String userid,String loginName);
}
