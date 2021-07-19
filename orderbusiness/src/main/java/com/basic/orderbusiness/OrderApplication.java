package com.basic.orderbusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@SpringBootApplication
@EnableFeignClients
public class OrderApplication {
    @RequestMapping("/")
    public String home() {
        return "按错";
    }

    public static void main(String[] args) {

        SpringApplication.run(OrderApplication.class, args);
    }
}