package com.jbos.app.sys.mapper;
import com.jbos.app.sys.pojo.Func;
import java.util.List;
import java.util.Map;

/**
 * FuncMapper
 * @author youfu.wang
 * @date 2019-01-31
 */
public interface FuncMapper {
    /**
     * 查询用户功能权限列表
     * @param parameterObject
     * @return
     */
    public List<Func> getUserFuncList(Map<String,Object> parameterObject);
}
