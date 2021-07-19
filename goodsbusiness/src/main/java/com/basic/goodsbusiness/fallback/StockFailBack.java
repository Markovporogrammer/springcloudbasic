package com.basic.goodsbusiness.fallback;

import com.basic.goodsbusiness.service.StockServiceClient;
import org.springframework.stereotype.Component;

/**
 * @author mzp
 * @date 2021/7/19 16:19
 */
@Component
public class StockFailBack implements StockServiceClient {
    @Override
    public String updateStock(String data) {
        return "服务fail";
    }

    @Override
    public String hello() {
        return "fail";
    }
}
