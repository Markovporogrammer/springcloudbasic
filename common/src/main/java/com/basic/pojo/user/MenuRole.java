package com.basic.pojo.user;

import java.io.Serializable;

public class MenuRole implements Serializable {
    private static final long serialVersionUID = 202505291281314640L;
    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 菜单id
     */
    private Integer menuId;
    /**
     * 角色id
     */
    private Integer roleId;

}