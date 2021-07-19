package com.basic.goodsbusiness.fallback;


import com.basic.api.StockApi;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

@Component
public class WebError implements FallbackFactory<StockApi> {

	@Override
	public StockApi create(Throwable cause) {
		// TODO Auto-generated method stub
		return new StockApi() {


			@Override
			public String updateStock(String data) {
				// TODO Auto-generated method stub
				System.out.println(cause);
				if(cause instanceof HttpServerErrorException.InternalServerError) {
					System.out.println("InternalServerError");
					return "远程服务报错";
				}else if(cause instanceof RuntimeException) {

					return "请求时异常：" + cause;
				}else {
					return "都算不上";
				}
			}

			@Override
			public String hello() {
				return null;
			}


		};
	}

}
