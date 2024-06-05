package com.heima.article.filter;

import com.heima.utils.common.AppJwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@SuppressWarnings("all")
@Component
public class UserFilter implements Ordered, GlobalFilter {
    @Override
    public int getOrder() {
        return -1;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        System.out.println(request.getURI());

        // 登录，方行
        String value = request.getPath().pathWithinApplication().value();
        System.out.println(value);
        if(value.equals("/user/api/v1/login/login_auth") || value.equals("/user/api/v1/login/login_auth/"))
            return chain.filter(exchange);

        // 没token
        String token = request.getHeaders().getFirst("token");
//        String token = (String)exchange.getRequiredAttribute("token");
        if(StringUtils.isBlank(token)){
            return response.setComplete();
        }

        // 过期
        Claims body = AppJwtUtil.getClaimsBody(token);
        int i = AppJwtUtil.verifyToken(body);
        if(i > 0)
            return response.setComplete();

        // 放行
        String id = body.get("id").toString();
        System.out.println(id);
        return chain.filter(exchange);
    }
}
