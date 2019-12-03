package com.jbos.app.sys.mapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jbos.app.sys.pojo.Org;

/**
 * OrgMapper
 * @author youfu.wang
 * @date 2019-01-31
 */
public interface OrgMapper{
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
     * @param id
     */
    public void deleteOrg(String id);
}
