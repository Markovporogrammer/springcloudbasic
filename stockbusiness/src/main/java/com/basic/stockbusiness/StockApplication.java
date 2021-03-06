package com.basic.stockbusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@EnableDiscoveryClient
@EnableEurekaClient
@RestController
@SpringBootApplication
public class StockApplication {

    @RequestMapping("/home")
    public String home() {
        return "Hello world";
    }

    public static void main(String[] args) {

        SpringApplication.run(StockApplication.class, args);
    }
    @Autowired
    DiscoveryClient client;

    @RequestMapping("/")
    public String hello() {
        List<ServiceInstance> instances = client.getInstances("stock");
        ServiceInstance selectedInstance = instances
                .get(new Random().nextInt(instances.size()));
        return "Hello World: " + selectedInstance.getServiceId() + ":" + selectedInstance
                .getHost() + ":" + selectedInstance.getPort();
    }

}