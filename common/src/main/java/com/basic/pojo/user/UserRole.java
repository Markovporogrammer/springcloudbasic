package com.basic.pojo.user;

import com.basic.pojo.BasicPojo;
import lombok.Data;

@Data
public class UserRole extends BasicPojo {

    Integer id;

    Integer userId;

    Integer roleId;

    int isDeleted;
}
