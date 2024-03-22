package com.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class OAuthResourceFilter implements WebFilter {

    private Logger logger = LoggerFactory.getLogger(OAuthResourceFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        // not a recommended option for prod for upper environments
        logger.info("AUTH header value {}", exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION));
        return chain.filter(exchange);
    }
}