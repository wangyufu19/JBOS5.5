package com.jbos.app.sys.mapper;
import com.jbos.app.sys.pojo.Menu;
import java.util.List;
import java.util.Map;

/**
 * MenuMapper
 * @author youfu.wang
 * @date 2019-01-31
 */
public interface MenuMapper {
    /**
     * 查询用户菜单权限列表
     * @param parameterObject
     * @return
     */
    public List<Menu> getUserMenuList(Map<String,Object> parameterObject);
}
