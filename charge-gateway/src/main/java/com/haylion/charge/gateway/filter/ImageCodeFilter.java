package com.haylion.charge.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.haylion.common.core.constant.SecurityConstant;
import com.haylion.common.core.exception.ValidateCodeException;
import com.haylion.common.redis.util.RedisUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import static com.haylion.common.core.constant.SecurityConstant.PREX_IMAGE_KEY;

/**
 * @Classname ImageCodeFilter
 * @Description 图形验证码验证
 */
@Slf4j
@Component
public class ImageCodeFilter extends AbstractGatewayFilterFactory {

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            // 不是登录请求，直接向下执行
            if (!StrUtil.containsAnyIgnoreCase(request.getURI().getPath(), SecurityConstant.OAUTH_TOKEN_URL)) {
                return chain.filter(exchange);
            }
            // 验证流程
            validateCode(request);
            return chain.filter(exchange);
        };
    }

    /**
     * 验证流程
     *
     * @param request
     */
    @SneakyThrows
    private void validateCode(ServerHttpRequest request) {

        MultiValueMap<String, String> queryParams = request.getQueryParams();
        // 验证码
        String code = queryParams.getFirst("code");
        // 随机标识
        String t = queryParams.getFirst("t");
        // 验证验证码流程
        if (StrUtil.isBlank(code)) {
            throw new ValidateCodeException("验证码不能为空");
        }
        // 从redis中获取之前保存的验证码跟前台传来的验证码进行匹配
        Object kaptcha = RedisUtil.get(PREX_IMAGE_KEY + t);
        if (kaptcha == null) {
            throw new ValidateCodeException("验证码已失效");
        }
        if (!code.toLowerCase().equals(kaptcha)) {
            throw new ValidateCodeException("验证码错误");
        }
    }
}
