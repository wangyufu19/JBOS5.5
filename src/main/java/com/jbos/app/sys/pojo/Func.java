package com.jbos.app.sys.pojo;
import java.io.Serializable;
import java.util.List;

/**
 * Func
 * @author youfu.wang
 * @date 2019-01-31
 */
public class Func extends BaseEntity implements Serializable {
    /**
     * 根功能id
     */
    public static String ROOTFUNC_ID="0";
    /**
     * 功能i类型0:目录;1:功能i
     */
    public static final String FUNCTYPE_DIR="0";
    public static final String FUNCTYPE_FUNC="1";

    private String  parentId;

    private String funcCode;

    private String funcName;

    private String funcType;

    private String funcUrl;

    private String orderNo;

    private String ico;

    private List<?> list;


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncType() {
        return funcType;
    }

    public void setFuncType(String funcType) {
        this.funcType = funcType;
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
