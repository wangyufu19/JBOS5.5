package com.jbos.app.sys.service.impl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jbos.app.sys.pojo.Org;
import com.jbos.app.sys.mapper.OrgMapper;
import com.jbos.app.sys.service.OrgMgrService;
import com.jbos.common.utils.PageObject;
import com.jbos.common.utils.PageQuery;
import com.jbos.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * OrgMgrService
 * @author youfu.wang
 * @date 2019-01-31
 */
@Service("orgMgrService")
public class OrgMgrServiceImpl implements OrgMgrService{
    @Autowired
    private OrgMapper orgMapper;
    /**
     * 查询组织机构数据
     * @return
     */
    public List<Org> getOrgList(){
        List<Org> orgList=null;
        orgList=orgMapper.getOrgList();
        return orgList;
    }
    /**
     * 查询组织机构数据
     * @return
     */
    public Org getOrg(String orgId){
        Org org=null;
        org=orgMapper.getOrg(orgId);
        return org;
    }
    /**
     * 保存组织机构数据
     * @param org
     */
    public void addOrg(Org org){
        org.setId(StringUtils.getUUID());
        orgMapper.addOrg(org);
    }
    /**
     * 更新组织机构数据
     * @param org
     */
    public void updateOrg(Org org){
        orgMapper.updateOrg(org);
    }
    /**
     * 删除组织机构数据
     * @param orgs
     */
    //@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void deleteOrg(Org[] orgs){
        if(orgs==null){
            return;
        }
        for(int i=0;i<orgs.length;i++){
            orgMapper.deleteOrg(orgs[i].getId());
        }
    }
}
