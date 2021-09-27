package com.basic.pojo.user;

import com.basic.pojo.BasicPojo;
import lombok.Data;

/**
 * @author mzp
 * @date 2021/7/16 14:57
 */
@Data
public class User extends BasicPojo {
    Integer id;
    String name;
    String password;
}
