package com.basic.goodsbusiness.service;

import com.basic.api.StockApi;
import com.basic.goodsbusiness.fallback.MyHystrixClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author mzp
 * @date 2021/7/15 19:33
 */
@FeignClient(value="stock", fallbackFactory = MyHystrixClientFallbackFactory.class)
public interface StockServiceClient extends StockApi {
}
