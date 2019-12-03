package com.jbos.app.sys.pojo;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseEntity
 * @author youfu.wang
 * @date 2019-01-31
 */
public class BaseEntity implements Serializable{
    @TableField("ID")
    private String id;
    @TableField("IS_VALID")
    private int isValid;
    @TableField("CREATE_USER_ID")
    private String createUserId;
    @TableField("CREATE_DATE")
    private Date createDate;
    @TableField("UPDATE_USER_ID")
    private String updateUserId;
    @TableField("UPDATE_DATE")
    private Date updateDate;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public int getIsValid() {
        return isValid;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
}
