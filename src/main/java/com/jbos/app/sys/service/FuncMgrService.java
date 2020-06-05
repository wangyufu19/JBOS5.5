package com.jbos.app.sys.service;
import java.util.List;
import com.jbos.app.sys.pojo.Func;

/**
 * FuncMgrService
 * @author youfu.wang
 * @date 2019-01-31
 */
public interface FuncMgrService {
    /**
     * 查询用户功能权限列表
     * @param loginName
     * @return
     */
    public List<Func> getUserFuncList(String userid, String loginName);
}
