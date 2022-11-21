package com.haylion.common.auth.token;

import com.haylion.common.auth.model.SecurityUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

import static com.haylion.common.core.constant.CommonConstant.BCRYPT_WAPPER;

/**
 * @Description 解析jwt并将信息放入Authentication
 */
public class UserAuthenticationConverter extends DefaultUserAuthenticationConverter {

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if (map.containsKey(USERNAME)) {
            Collection<? extends GrantedAuthority> authorities = getAuthorities(map);
            SecurityUser user = getSecurityUser(map);
            return new UsernamePasswordAuthenticationToken(user, "N/A", authorities);
        }
        return null;
    }


    /**
     * 获取权限信息
     *
     * @param map
     * @return
     */
    private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
        Object authorities = map.get(AUTHORITIES);
        if (authorities instanceof String) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
        }
        if (authorities instanceof Collection) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
                    .collectionToCommaDelimitedString((Collection<?>) authorities));
        }
        throw new IllegalArgumentException("Authorities must be either a String or a Collection");
    }


    private SecurityUser getSecurityUser(Map<String, ?> map) {
        String username = (String) map.get(USERNAME);
        Integer userId = (Integer) map.get("userId");
        String name = (String) map.get("name");
//        String password = (String) map.get("password");
        Integer state = (Integer) map.get("state");
        Integer loginPermission = (Integer) map.get("loginPermission");
        return SecurityUser.builder()
                .userId(userId)
                .name(name)
                .username(username)
//                .password(BCRYPT_WAPPER + password)
                .state(state)
                .loginPermission(loginPermission).build();
    }

}
