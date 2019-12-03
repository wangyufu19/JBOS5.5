package com.jbos.app.sys.pojo;
import java.io.Serializable;
import java.util.List;

/**
 * User
 * @author youfu.wang
 * @date 2019-01-31
 */
public class Menu extends BaseEntity implements Serializable {
    /**
     * 根菜单id
     */
    public static String ROOTMENU_ID="0";
    /**
     * 菜单类型0:目录;1:菜单
     */
    public static final String MENUTYPE_DIR="0";
    public static final String MENUTYPE_MENU="1";

    private String  parentId;

    private String menuCode;

    private String menuName;

    private String menuType;

    private String menuUrl;

    private String orderNo;

    private String ico;

    private List<?> list;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
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
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
