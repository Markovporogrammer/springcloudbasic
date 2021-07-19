package com.basic.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author mzp
 * @date 2021/7/19 11:30
 */
public interface StockApi {
    @RequestMapping(value = "/{data}", method = GET)
    public String updateStock(@PathVariable String data);
    @RequestMapping(value = "/hello", method = GET)
    public String hello() ;
}
