package com.haylion.common.auth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;


@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class SocialServiceException extends OAuth2Exception {

    public SocialServiceException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "social_exception";
    }

    @Override
    public int getHttpErrorCode() {
        return 423;
    }
}
