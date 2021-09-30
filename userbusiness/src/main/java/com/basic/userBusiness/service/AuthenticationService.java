package com.basic.userBusiness.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.basic.pojo.user.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationService {
    public String getToken(User user) {
        String token = "";
        Date date = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        try {
            token = JWT.create()
                    .withExpiresAt(date)//设置有效期
                    .withAudience(user.getId().toString())          // 将 user id 保存到 token 里面
                    .sign(Algorithm.HMAC256(user.getPassword()));   // 以 password 作为 token 的密钥
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return token;
    }

}