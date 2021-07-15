package com.basic.goodsbusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@ComponentScan
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@SpringBootApplication
@EnableFeignClients
public class GoodsApplication {
    @RequestMapping("/")
    public String home() {
        return "按错";
    }

    public static void main(String[] args) {

        SpringApplication.run(GoodsApplication.class, args);
    }
}