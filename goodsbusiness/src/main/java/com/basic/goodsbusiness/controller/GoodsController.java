package com.basic.goodsbusiness.controller;

import com.basic.goodsbusiness.command.CommandHelloWorld;
import com.basic.goodsbusiness.service.StockServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author mzp
 * @date 2021/7/15 19:39
 */
@RestController
public class GoodsController {

    @Autowired
    StockServiceClient stockServiceClient;

    @RequestMapping(value = "/getStock/{data}" , method = GET)
    public String getStock(@PathVariable String data){
//        Future<String> s = new CommandHelloWorld("Bob").queue();
//        Observable<String> s = new CommandHelloWorld("Bob").observe();
//        System.out.println(1/0);
        //传的data是加密数据
       return stockServiceClient.updateStock(data);
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        System.out.println("hello:");
        return stockServiceClient.hello();
    }
    @RequestMapping(value = "/hello1")
    public String hello1(String red){
        System.out.println("8770----hello1:==="+red);
        return "hello1";
    }
    @RequestMapping(value = "/sayHello")
    public String sayHello(){

        return "sayHello";
    }
}
