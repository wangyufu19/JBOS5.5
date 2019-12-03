package com.jbos.app.sys.controller;
import com.jbos.app.sys.pojo.Org;
import com.jbos.app.sys.service.OrgMgrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/* OrgMgrController
 * @author youfu.wang
 * @date 2019-03-01
 */
@Slf4j
@Controller
@RequestMapping("/org")
public class OrgMgrController extends BaseController{

    @Autowired
    private OrgMgrService orgMgrService;
    /**
     * 得到组织机构页面
     * @return
     */
    @RequestMapping("/getOrgPage")
    public String getOrgPage(){
        return "org";
    }

    /**
     * 查询组织机构数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/getOrgList")
    public Return getOrgList(@RequestParam Map<String, Object> params){
        Return ret=Return.ok();
        try{
            this.doStargPage(params);
            List<Org> orgs=orgMgrService.getOrgList();
            this.doFinishPage(ret,orgs);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            Return.error(Return.RETCODE_FAILURE,Return.RETMSGFAILURE);
        }
        return ret;
    }
    /**
     * 查询组织机构数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/getOrg")
    public Return getOrg(@RequestParam String orgId){
        Org org=orgMgrService.getOrg(orgId);
        return  Return.ok().put("org",org);
    }
    /**
     * 保存组织机构数据
     * @param org
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveOrg", method = RequestMethod.POST)
    public Return saveOrg(@RequestBody Org org){
        orgMgrService.addOrg(org);
        return  Return.ok();
    }
    /**
     * 保存组织机构数据
     * @param org
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateOrg", method = RequestMethod.POST)
    public Return updateOrg(@RequestBody Org org){
        orgMgrService.updateOrg(org);
        return  Return.ok();
    }
    /**
     * 保存组织机构数据
     * @param orgs
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOrg", method = RequestMethod.POST)
    public Return deleteOrg(@RequestBody Org[] orgs){
        Return ret=Return.ok();
        try{
            orgMgrService.deleteOrg(orgs);
        }catch(Exception e){
            log.error(Return.RETMSGFAILURE,e);
            Return.error(Return.RETCODE_FAILURE,Return.RETMSGFAILURE);
        }
        return ret;
    }

}
