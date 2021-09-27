package com.basic.userBusiness.mapper;


import com.basic.pojo.user.User;

public interface UserMapper {
    int add(User user);

    User findOne1(User user);
}
