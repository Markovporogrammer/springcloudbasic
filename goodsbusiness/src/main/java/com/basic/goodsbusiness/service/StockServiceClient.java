package com.basic.goodsbusiness.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author mzp
 * @date 2021/7/15 19:33
 */
@FeignClient("stock")
public interface StockServiceClient {

    @RequestMapping(value = "/{data}", method = GET)
    String updateStock(@PathVariable String data);
}
