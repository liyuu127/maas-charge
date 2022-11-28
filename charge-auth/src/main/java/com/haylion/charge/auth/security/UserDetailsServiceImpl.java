package com.haylion.charge.auth.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haylion.common.core.constant.SecurityConstant;
import com.haylion.common.core.utils.HttpRequestDeviceUtils;
import com.haylion.common.entity.entity.UserT;
import com.haylion.common.entity.vo.UserPermissionVo;
import com.haylion.charge.auth.client.UserRemoteClient;
import com.haylion.common.auth.model.SecurityUser;
import com.haylion.common.core.model.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Set;

import static com.haylion.common.core.constant.CommonConstant.BCRYPT_WAPPER;


@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRemoteClient userRemoteClient;

    /**
     * 通过用户名查询用户
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Integer userTypeFromRequestAgent = getUserTypeFromRequestAgent();
        ResponseData responseData = userRemoteClient.selectLoginInfo(username, userTypeFromRequestAgent);

        log.info("username={}正在登录, userTypeFromRequestAgent={}", username, userTypeFromRequestAgent);
        if (!responseData.assertSuccess() || responseData.getData() == null) {
            log.info("登录用户：" + username + " 不存在.");
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        UserPermissionVo userPermission = JSON.parseObject(JSONObject.toJSONString(responseData.getData()), UserPermissionVo.class);
        Collection<? extends GrantedAuthority> authorities = getGrantedAuthorities(userPermission);
        return getSecurityUser(userPermission.getUserT(), authorities);
    }

    private Integer getUserTypeFromRequestAgent() {
        Integer userType = null;
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        HttpRequestDeviceUtils.Device device = HttpRequestDeviceUtils.parseDevice(request);
        if (device == HttpRequestDeviceUtils.Device.PC) {
            userType = SecurityConstant.USER_TYPE_PC;
        } else if (device == HttpRequestDeviceUtils.Device.MOBILE) {
            userType = SecurityConstant.USER_TYPE_MOBILE;
        }
        return userType;
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(UserPermissionVo userPermission) {
        Set<String> permissions = userPermission.getPermissions();
        if (permissions.isEmpty()) {
            throw new PreAuthenticatedCredentialsNotFoundException("用户未授权");
        }
        return AuthorityUtils.createAuthorityList(permissions.toArray(new String[0]));
    }

    private SecurityUser getSecurityUser(UserT user, Collection<? extends GrantedAuthority> authorities) {
        return SecurityUser.builder()
                .userId(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .password(BCRYPT_WAPPER + user.getPassword())
                .state(user.getState())
                .loginPermission(user.getLoginPermission())
                .authorities(authorities).build();
    }

    /**
     * 手机验证码登录
     *
     * @param mobile
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        //  通过手机号mobile去数据库里查找用户以及用户权限
        return loadUserByUsername(mobile);
    }

}
