package com.basic.userBusiness.controller;

import com.alibaba.fastjson.JSONObject;
import com.basic.pojo.user.User;
import com.basic.userBusiness.annotation.LoginRequired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @PostMapping("/test")
    @LoginRequired
    public Object login(@RequestBody User user) {

        return "访问成功";
    }
}
