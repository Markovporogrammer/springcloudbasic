package com.basic.pojo.user;

import com.basic.pojo.BasicPojo;
import lombok.Data;

@Data
public class Roles extends BasicPojo {

    Integer id;

    /**
     * 角色描述
     */
    String roleName;

    /**
     * 绝世额描述
     */
    String roleDesc;

    /**
     * 角色有效期
     */
    String roleExpire;

    /**
     * 是否删除
     */
    int isDeleted;
}
