package com.basic.userBusiness.controller;

import com.alibaba.fastjson.JSONObject;
import com.basic.pojo.user.User;
import com.basic.userBusiness.service.AuthenticationService;
import com.basic.userBusiness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationApi {
    private AuthenticationService authenticationService;
    private UserService userService;

    @Autowired
    public AuthenticationApi(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }


    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        User userInDataBase = userService.findByName(user.getName());
        JSONObject jsonObject = new JSONObject();
        if (userInDataBase == null) {
            jsonObject.put("error", "用户不存在");
        } else if (!userService.comparePassword(user, userInDataBase)) {
            jsonObject.put("error", "密码不正确");
        } else {
            String token = authenticationService.getToken(userInDataBase);
            jsonObject.put("token", token);
        }
        return jsonObject;
    }
    @PostMapping("/register")
    public Object register(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        User userInDataBase = userService.findByName(user.getName());
        if (Objects.nonNull(userInDataBase)) {
            jsonObject.put("error", "用户名已存在");
            return jsonObject;
        }
        User u = userService.add(user);
        jsonObject.put("id", u.getId());
        return jsonObject;
    }
}