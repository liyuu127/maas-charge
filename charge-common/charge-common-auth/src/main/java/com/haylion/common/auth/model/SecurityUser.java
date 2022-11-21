package com.haylion.common.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static com.haylion.common.core.constant.SecurityConstant.USER_STATE_FREEZE;
import static com.haylion.common.core.constant.SecurityConstant.USER_STATE_NORMAL;

/**
 * @Description 用户手机号和账号密码 身份权限认证类 登陆身份认证
 **/
@Setter
@Getter
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class SecurityUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String name;
    private String username;//登录用户名
    private String password;//登录密码
    private Integer state;
    private Integer loginPermission;
    private Collection<? extends GrantedAuthority> authorities;



    /**
     * 返回分配给用户的角色列表
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * 账户是否未过期,过期无法验证
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return USER_STATE_FREEZE != this.state;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return this.state == USER_STATE_NORMAL;
    }
}
