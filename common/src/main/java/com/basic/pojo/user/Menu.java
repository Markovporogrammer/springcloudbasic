package com.basic.pojo.user;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = 130350349649865335L;
    /**
     * 主键
     */
    private Integer id;

    /**
     * set leaf opened
     */
    private Boolean opened;
    /**
     * 权限控制使用
     */
    private String url;
    /**
     * 前端请求路径
     */
    private String path;
    /**
     * 组件名
     */
    private String component;
    /**
     * 组件名称
     */
    private String name;
    /**
     * 菜单图标
     */
    private String iconCls;
    /**
     * 是否保活：前端是否在内存中销毁
     */
    private Boolean keepAlive;
    /**
     * 是否需要认证
     */
    private Boolean requireAuth;
    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 父级名称
     */
    private String parentName;
    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * 子菜单
     */
    private List<Menu> children;

    /**
     * 哪些角色可以访问
     */
    private List<Roles> roles;

}