package com.haylion.charge.auth.authentication.mobile;

import com.haylion.common.auth.exception.ValidateCodeException;
import com.haylion.common.core.constant.RedisConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.haylion.common.core.constant.SecurityConstant.*;

/**
 * @Classname SmsCodeFilter
 * @Description 短信验证码过滤器
 */
@Slf4j
@Component
public class SmsCodeFilter extends OncePerRequestFilter {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    private Set<String> urls = new HashSet<>();

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        // 这里配置需要拦截的地址
        urls.add(MOBILE_LOGIN_URL);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean action = false;
        for (String url : urls) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                action = true;
                break;
            }
        }
        if (action) {
            try {
                validate(request);
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void validate(HttpServletRequest request) {
        //短信验证码
        String smsCode = obtainSmsCode(request);
        log.info("从参数获取到的验证码:{}", smsCode);
        // 手机号
        String mobile = obtainMobile(request);
        log.info("从参数获取到的手机号:{}", mobile);
        String redisCode = redisTemplate.opsForValue().get(RedisConstant.USER_VERIFICATION_CODE_PREFIX + mobile);
        if (smsCode == null || smsCode.isEmpty()) {
            throw new ValidateCodeException("短信验证码不能为空");
        }
        if (redisCode == null) {
            throw new ValidateCodeException("验证码已失效");
        }
        if (!StringUtils.equals(smsCode, redisCode)) {
            throw new ValidateCodeException("短信验证码错误");
        }
        redisTemplate.delete(RedisConstant.USER_VERIFICATION_CODE_PREFIX + mobile);
    }

    /**
     * 获取验证码
     *
     * @param request
     * @return
     */
    private String obtainSmsCode(HttpServletRequest request) {
        return request.getParameter(CODE_KEY);
    }

    /**
     * 获取手机号
     *
     * @param request
     * @return
     */
    private String obtainMobile(HttpServletRequest request) {
        return request.getParameter(PHONE_KEY);
    }

}
