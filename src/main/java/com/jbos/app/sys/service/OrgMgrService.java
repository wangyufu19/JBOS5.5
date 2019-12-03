package com.jbos.app.sys.service;
import com.jbos.app.sys.pojo.Org;
import com.jbos.common.utils.PageObject;

import java.util.List;
import java.util.Map;

/**
 * OrgMgrService
 * @author youfu.wang
 * @date 2019-01-31
 */
public interface OrgMgrService {
    /**
     * 查询组织机构数据
     * @return
     */
    public List<Org> getOrgList();
    /**
     * 查询组织机构数据
     * @return
     */
    public Org getOrg(String orgId);
    /**
     * 保存组织机构数据
     * @param org
     */
    public void addOrg(Org org);
    /**
     * 更新组织机构数据
     * @param org
     */
    public void updateOrg(Org org);
    /**
     * 删除组织机构数据
     * @param orgs
     */
    public void deleteOrg(Org[] orgs);
}
