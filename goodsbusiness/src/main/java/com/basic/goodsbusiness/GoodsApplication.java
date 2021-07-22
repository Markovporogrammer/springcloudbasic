package com.basic.goodsbusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard//监控工具
public class GoodsApplication {
//    @RequestMapping("/")
//    public String home() {
//        return "按错";
//    }

    public static void main(String[] args) {

        SpringApplication.run(GoodsApplication.class, args);
    }
//    @Bean
//    public RestTemplate restTemplate(){ return new RestTemplate();
//    }
//    @Bean
//    public IRule myRule(){
//        //return new RetryRule();从试
//        //return new RoundRobinRule(); 轮询 //可以用自增实现 然后取余节点数
//        return new RandomRule();//随机处理
//    }
}