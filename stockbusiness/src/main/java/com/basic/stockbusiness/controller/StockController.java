package com.basic.stockbusiness.controller;

import com.basic.api.StockApi;
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
}
