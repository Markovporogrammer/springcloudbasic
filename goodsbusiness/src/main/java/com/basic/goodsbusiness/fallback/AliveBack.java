package com.basic.goodsbusiness.fallback;

import com.basic.api.StockApi;
import org.springframework.stereotype.Component;

@Component
public class AliveBack implements StockApi {


	@Override
	public String updateStock(String data) {
		return "aaa";
	}

	@Override
	public String hello() {
		return null;
	}
}
