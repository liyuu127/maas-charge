package com.haylion.common.auth.util;

import com.alibaba.fastjson.JSON;
import com.haylion.common.auth.model.SecurityUser;
import lombok.experimental.UtilityClass;
import org.apache.commons.compress.utils.CharsetNames;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * @Classname SecurityUtil
 * @Description 安全服务工具类
 */
@UtilityClass
public class SecurityUtil {

    public void writeJavaScript(Object o, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding(CharsetNames.UTF_8);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(JSON.toJSONString(o));
        printWriter.flush();
    }

    /**
     * 获取Authentication
     */
    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public Collection<? extends GrantedAuthority> getGrantedAuthority() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    /**
     * 获取用户
     *
     * @param authentication
     * @return PigxUser
     * <p>
     * 获取当前用户的全部信息 EnablePigxResourceServer true
     * 获取当前用户的用户名 EnablePigxResourceServer false
     */
    public SecurityUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof SecurityUser) {
            return (SecurityUser) principal;
        }
        return null;
    }

    /**
     * 获取用户
     */
    public SecurityUser getUser() {
        Authentication authentication = getAuthentication();
        return getUser(authentication);
    }


    /**
     * 获取用户名称
     *
     * @return username
     */
    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getName();
    }

    public String getSupplierCode() {
        SecurityUser user = getUser();
        if (user == null) {
            return null;
        }
        return user.getSupplierCode();
    }

    /**
     * 获取用户id
     *
     * @return
     */
    public Integer getUserId() {
        SecurityUser user = getUser();
        if (user == null) {
            return null;
        }
        return user.getUserId();
    }

    public boolean validatePass(String newPass, String passwordEncoderOldPass) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(newPass, passwordEncoderOldPass);
    }

}
