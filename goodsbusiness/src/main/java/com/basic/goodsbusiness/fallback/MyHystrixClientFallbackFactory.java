package com.basic.goodsbusiness.fallback;

import com.basic.goodsbusiness.service.StockServiceClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyHystrixClientFallbackFactory implements FallbackFactory<StockServiceClient> {
    @Override
    public StockServiceClient create(Throwable throwable) {
        System.out.println(throwable);
        return new StockServiceClient() {

            @Override
            public String updateStock(String data) {

                return "我异常了";
            }

            @Override
            public String hello() {
                return null;
            }
        };
    }
}