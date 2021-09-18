package com.basic.goodsbusiness.controller;

import com.basic.goodsbusiness.command.CommandHelloWorld;
import com.basic.goodsbusiness.service.GoodsService;
import com.basic.goodsbusiness.service.StockServiceClient;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.script.Script;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Autowired
    RestHighLevelClient highLevelClient;
    @Autowired
    GoodsService goodsService;

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

    @PostMapping("create/{index}")
    public String createIndex(@PathVariable("index") String index) throws IOException {
        goodsService.createIndex();
        return "";
    }
    @PostMapping("bulk/{index}")
    public String bulkIndex(@PathVariable("index") String index) throws IOException {
        goodsService.bulkRequestTest();
        return "";
    }
    @PostMapping("update/{index}")
    public String updateIndex(@PathVariable("index") String index) throws IOException {
        goodsService.updateTest();
        return "";
    }
    @PostMapping("insertOrUpdate/{index}")
    public String insertOrUpdateIndex(@PathVariable("index") String index) throws IOException {
        goodsService.insertOrUpdateOne();
        return "";
    }
    @PostMapping("del/{index}")
    public String delIndex(@PathVariable("index") String index) throws IOException {
        goodsService.deleteByIdTest();
        return "";
    }
    @PostMapping("deleteByQuery/{index}")
    public String deleteByQueryIndex(@PathVariable("index") String index) throws IOException {
        goodsService.deleteByQueryRequestTest();
        return "";
    }
    @PostMapping("bulkDiff/{index}")
    public String bulkDiffndex(@PathVariable("index") String index) throws IOException {
        goodsService.bulkDiffRequestTest();
        return "";
    }
    @PostMapping("select/{index}")
    public String selectIndex(@PathVariable("index") String index) throws IOException {
        goodsService.selectByUserTest();
        return "";
    }
    //不行
    @PostMapping("bool/{index}")
    public String boolIndex(@PathVariable("index") String index) throws IOException {
        goodsService.boolQueryTest();
        return "";
    }





}
