package com.basic.goodsbusiness.service;

import com.basic.api.StockApi;
import com.basic.goodsbusiness.fallback.AliveBack;
import com.basic.goodsbusiness.fallback.MyHystrixClientFallbackFactory;
import com.basic.goodsbusiness.fallback.StockFailBack;
import com.basic.goodsbusiness.fallback.WebError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author mzp
 * @date 2021/7/15 19:33
 */
@FeignClient(value="stock", fallbackFactory = MyHystrixClientFallbackFactory.class)
public interface StockServiceClient extends StockApi {
}
