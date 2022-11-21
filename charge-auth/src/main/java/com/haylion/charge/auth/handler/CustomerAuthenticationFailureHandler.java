package com.haylion.charge.auth.handler;


import com.haylion.common.auth.exception.ValidateCodeException;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.core.model.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname FebsAuthenticationFailureHandler
 * @Description 认证失败处理器0
 */
@Component
public class CustomerAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        String message;
        if (exception instanceof ValidateCodeException) {
            message = exception.getMessage();
        } else {
            message = "认证失败，请联系网站管理员";
        }
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        SecurityUtil.writeJavaScript(ResponseData.error(message), response);
    }
}


