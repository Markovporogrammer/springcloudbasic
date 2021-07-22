package com.basic.stockbusiness.controller;

import com.basic.api.StockApi;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzp
 * @date 2021/7/15 19:36
 */
@RestController
public class StockController implements StockApi {

    @Override
    public String updateStock(String data) {
        return "ans";
    }

    @Override
    public String hello() {
        return "true";
    }
    @RequestMapping(value = "/hello1")
    public String hello1(){
        System.out.println("8771===hello1:===");
        return "hello1";
    }
}
