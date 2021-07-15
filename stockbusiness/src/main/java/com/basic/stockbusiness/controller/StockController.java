package com.basic.stockbusiness.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author mzp
 * @date 2021/7/15 19:36
 */
@RestController
public class StockController {

    @RequestMapping(value = "/{data}", method = GET)
    String updateStock(@PathVariable String data){
        //解密这个数据
        return data;
    }
}
