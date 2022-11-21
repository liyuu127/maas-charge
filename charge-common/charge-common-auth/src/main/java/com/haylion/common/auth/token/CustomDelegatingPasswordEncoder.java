package com.haylion.common.auth.token;

import com.haylion.common.core.constant.CommonConstant;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

/**
 * @author liyu
 * date 2021/8/9 19:00
 * description BCrypt定制
 */
public class CustomDelegatingPasswordEncoder implements PasswordEncoder {

    private static final String PREFIX = "{";
    private static final String SUFFIX = "}";
    private static DelegatingPasswordEncoder delegatingPasswordEncoder;


    public CustomDelegatingPasswordEncoder() {
        delegatingPasswordEncoder = (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Override
    public String encode(CharSequence rawPassword) {
        return delegatingPasswordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String prefixEncodedPassword) {
        String id = extractId(prefixEncodedPassword);
        if (Objects.equals(id, CommonConstant.BCRYPT)) {
            String storePassword = extractEncodedPassword(prefixEncodedPassword);
            if (Objects.equals(rawPassword, storePassword)) {
                return true;
            }
        }
        return delegatingPasswordEncoder.matches(rawPassword, prefixEncodedPassword);
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return delegatingPasswordEncoder.upgradeEncoding(encodedPassword);
    }

    private String extractId(String prefixEncodedPassword) {
        if (prefixEncodedPassword == null) {
            return null;
        }
        int start = prefixEncodedPassword.indexOf(PREFIX);
        if (start != 0) {
            return null;
        }
        int end = prefixEncodedPassword.indexOf(SUFFIX, start);
        if (end < 0) {
            return null;
        }
        return prefixEncodedPassword.substring(start + 1, end);
    }

    private String extractEncodedPassword(String prefixEncodedPassword) {
        int start = prefixEncodedPassword.indexOf(SUFFIX);
        return prefixEncodedPassword.substring(start + 1);
    }
}
