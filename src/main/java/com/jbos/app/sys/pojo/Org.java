package com.jbos.app.sys.pojo;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * Org
 * @author youfu.wang
 * @date 2019-01-31
 */
@TableName("JBOS_ORG")
public class Org extends BaseEntity{
    /**
     * 根机构id
     */
    public static String ROOTORG_ID="0";
    @TableField("PARENT_ID")
    private String  parentId;
    @TableField("ORG_CODE")
    private String orgCode;
    @TableField("ORG_NAME")
    private String orgName;
    @TableField("ORG_TYPE")
    private String orgType;
    @TableField("LINK_NAME")
    private String linkName;
    @TableField("ORG_DESC")
    private String orgDesc;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }
}
