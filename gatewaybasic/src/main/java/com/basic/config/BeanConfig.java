package com.basic.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class BeanConfig {

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
    /**
     * 按照Path限流
     *
     * @return key
     */
    @Bean
    public KeyResolver pathKeyResolver() {
        return exchange -> Mono.just(
                exchange.getRequest()
                        .getPath()
                        .toString()
        );
    }

    /**
     * 用户的限流
     * @return
     */
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

//    /**
//     * 来源IP的限流
//     * @return
//     */
//    @Bean
//    public KeyResolver ipKeyResolver() {
//        return exchange -> Mono.just(
//                exchange.getRequest()
//                        .getHeaders()
//                        .getFirst("X-Forwarded-For")
//        );
}
