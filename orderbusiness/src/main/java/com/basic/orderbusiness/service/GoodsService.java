package com.basic.orderbusiness.service;

import com.basic.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mzp
 * @date 2021/7/16 14:54
 */
@FeignClient("goods")
public interface GoodsService {

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id);
}
