package com.basic.goodsbusiness.controller;

import com.basic.goodsbusiness.service.StockServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        //传的data是加密数据
       return stockServiceClient.updateStock(data);
    }
}
