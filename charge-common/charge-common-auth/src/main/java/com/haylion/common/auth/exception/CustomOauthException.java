package com.haylion.common.auth.exception;

import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;


public class CustomOauthException extends OAuth2Exception {

    @Getter
    private String errorCode;

    public CustomOauthException(String msg) {
        super(msg);
    }

    public CustomOauthException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }
}
