package com.haylion.charge.user.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Objects;
import com.haylion.charge.user.constant.RetStubDetail;
import com.haylion.charge.user.constant.UserConstant;
import com.haylion.charge.user.pojo.form.UserForm;
import com.haylion.charge.user.utils.RegexUtil;
import com.haylion.charge.user.utils.WebUtil;
import com.haylion.charge.user.utils.convert.UserConvert;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.core.constant.CommonConstant;
import com.haylion.common.core.constant.SecurityConstant;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.core.utils.HttpRequestDeviceUtils;
import com.haylion.common.entity.dto.UserDetailDto;
import com.haylion.common.entity.entity.RoleT;
import com.haylion.common.entity.entity.UserT;
import com.haylion.common.entity.vo.UserPermissionVo;
import com.haylion.common.repository.mapper.UserTMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.haylion.charge.user.constant.RetStubDetail.OLD_PASSWORD_ERROR;
import static com.haylion.charge.user.constant.UserConstant.USER_TYPE_MOBILE;
import static com.haylion.charge.user.constant.UserConstant.USER_TYPE_PC;
import static com.haylion.common.core.constant.CommonConstant.BCRYPT_REGE;
import static com.haylion.common.core.constant.RedisConstant.USER_VERIFICATION_CODE_PREFIX;

/**
 * @author liyu
 * date 2021/1/17 17:06
 * description
 */
@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserTMapper userTMapper;
    private final StringRedisTemplate stringRedisTemplate;
    private final TokenStore tokenStore;

    private final UserRoleService userRoleService;

    private final TerminalUserService terminalUserService;
    private final MerchantUserService merchantUserService;


    /**
     * 通过用户名查询用户包括角色权限等
     *
     * @param username 用户名
     * @return ResponseData
     */
    public UserPermissionVo userPermission(String username) {
        var userT = Optional
                .ofNullable(userTMapper.selectByLowerUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("登录用户：" + username + " 不存在"));

        return populateUserPermissionVo(userT);

    }

    /**
     * 添加一个新用户
     *
     * @param userForm
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertUser(UserForm userForm) {
        checkUserUniqueField(userForm);

        //初始化用户信息
        var userT = UserConvert.INSTANCE.formToEntity(userForm);
        saveUser(userT);

        //add business user
        if (USER_TYPE_MOBILE == userForm.getUserType()) {
            terminalUserService.insertTerminalUser(userForm);
        } else if (USER_TYPE_PC == userForm.getUserType()) {
            merchantUserService.insertMerchantUser(userForm);
        }

        //添加角色信息
        if (userForm.getRoleId() != null && !Objects.equal(userForm.getRoleId(), UserConstant.USER_ROLE_NULL)) {
            userRoleService.insertUserRole(userT.getId(), userForm.getRoleId());
        }
    }

    private void saveUser(UserT userT) {
        String password = StringUtils.isBlank(userT.getPassword()) ? userT.getMobile().substring(5, 11) : userT.getPassword();
        userT.setPassword(new BCryptPasswordEncoder().encode(password))
                .setState(SecurityConstant.USER_STATE_PENDING_AUDIT)
                .setCreateBy(SecurityUtil.getUsername())
                .setCreateTime(LocalDateTime.now());
        userTMapper.insertSelective(userT);
    }


    /**
     * 逻辑删除用户
     *
     * @param userId
     */
    public void deleteUserById(Integer userId) {
        var userT = new UserT()
                .setId(userId)
                .setDeleted(CommonConstant.DELETED_YES);
        userTMapper.updateByPrimaryKeySelective(userT);
    }

    /**
     * 更新用户
     *
     * @param userForm
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserForm userForm) {
        if (userTMapper.selectByPrimaryKey(userForm.getId()) == null) {
            throw new ApplicationException(RetStubDetail.USER_NOUT_FOUND);
        }
        //查询修改后的手机或用户名是否相同
        checkUserUniqueField(userForm);
        //更新用户信息
        var userT = UserConvert.INSTANCE.formToEntity(userForm);
        userT.setUpdateTime(LocalDateTime.now())
                .setUpdateBy(SecurityUtil.getUsername());
        userTMapper.updateByPrimaryKeySelective(userT);
        //更新角色信息
        if (userForm.getRoleId() != null && Objects.equal(userForm.getRoleId(), UserConstant.USER_ROLE_NULL)) {
            userRoleService.deleteUserRoleByUserId(userT.getId());
        } else if (userForm.getRoleId() != null) {
            userRoleService.updateUserRole(userForm.getId(), userForm.getRoleId());
        }

    }

    private void checkUserUniqueField(UserForm userForm) {
        if (StringUtils.isNotBlank(userForm.getMobile())) {
            userTMapper.selectByLowerUsernameOrMobileWithUserType(null, userForm.getMobile(), userForm.getUserType())
                    .ifPresent(userT -> {
                        if (userForm.getId() != null && !userT.getId().equals(userForm.getId())) {
                            throw new ApplicationException(RetStubDetail.TEL_EXIST);
                        }
                    });
        }

        if (StringUtils.isNotBlank(userForm.getUsername())) {
            userTMapper.selectByLowerUsernameOrMobileWithUserType(userForm.getUsername(), null, userForm.getUserType())
                    .ifPresent(userT -> {
                        if (userForm.getId() != null && !userT.getId().equals(userForm.getId())) {
                            throw new ApplicationException(RetStubDetail.USERNAME_EXIST);
                        }
                    });
        }
    }

    public UserDetailDto info(Integer userId) {
        var userDetail = userTMapper.getUserDetail(userId);
        userDetail.setPermissions(userTMapper.selectResourceCodeByUserId(userId));
        return userDetail;
    }

    public PageInfo<UserDetailDto> selectList(String name, String username, String card, Integer[] states, String
            mobile, Integer cId, Integer dId, Integer pId, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(userTMapper.selectList(name, username, card, states, mobile, cId, dId, pId));
    }

    public void updatePassword(Integer id, String password, String updatedPassword) {
        var user = userTMapper.selectByPrimaryKey(id);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches(password, user.getPassword().replaceAll(BCRYPT_REGE, ""));
        if (!matches) {
            throw new ApplicationException(OLD_PASSWORD_ERROR);
        }
        userTMapper.updatePassword(id, passwordEncoder.encode(updatedPassword));
    }

    public void passwordReset(String mobile, String code, String password) {
        userCodeVerify(mobile, code);
        String newPassword = new BCryptPasswordEncoder().encode(password);
        userTMapper.updatePasswordByMobile(mobile, newPassword);
    }

    public void updatePhone(Integer userId, String mobile, String code) {
        userCodeVerify(mobile, code);
        var user = new UserT();
        user.setId(userId).setMobile(mobile).setUpdateTime(LocalDateTime.now());
        userTMapper.updateByPrimaryKeySelective(user);

    }

    /**
     * 验证用户验证码是否正确
     *
     * @param prefix 前缀 mobile or userId
     * @param code   用户输入验证码
     */
    private void userCodeVerify(String prefix, String code) {
        String key = USER_VERIFICATION_CODE_PREFIX + prefix;
        String verificationCode = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(verificationCode) || !verificationCode.equals(code)) {
            throw new ApplicationException(RetStubDetail.CODE_ERROR_OR_INVALID);
        }
        stringRedisTemplate.delete(key);
    }

    public void updateUserState(Integer id, Integer state) {
        var user = new UserT();
        user.setId(id)
                .setState(state)
                .setUpdateTime(LocalDateTime.now())
                .setUpdateBy(SecurityUtil.getUsername());
        userTMapper.updateByPrimaryKeySelective(user);
    }

    public boolean selectUserExitByPId(Integer pId) {
        return userTMapper.selectUserExitByPId(pId);
    }

    public UserPermissionVo selectLoginInfo(String username, Integer userType) {
        Optional<UserT> userTOptional;
        if (RegexUtil.isMobileNumber(username)) {
            log.info("{}通过手机号登录", username);
            userTOptional = userTMapper.selectByLowerUsernameOrMobileWithUserType(null, username, userType);
        } else {
            log.info("{}通过用户名登录", username);
            userTOptional = userTMapper.selectByLowerUsernameOrMobileWithUserType(username, null, userType);
        }
        UserT userT = userTOptional.orElseThrow(() -> new UsernameNotFoundException("登录用户：" + username + " 不存在"));
        return populateUserPermissionVo(userT);
    }


    private UserPermissionVo populateUserPermissionVo(UserT userT) {
        Set<String> permissions = new HashSet<>(userTMapper.selectResourceCodeByUserId(userT.getId()));
        Set<String> roles = userTMapper.selectRoleCodesByUserId(userT.getId()).stream().map(role -> "ROLE_" + role).collect(Collectors.toSet());
        permissions.addAll(roles);
        return new UserPermissionVo()
                .setUserT(userT)
                .setPermissions(permissions)
                .setRoles(roles);
    }

    public void logout() {
        HttpServletRequest request = WebUtil.getCurrentRequest();
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            String tokenValue = authHeader.replace("Bearer", "").trim();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
            tokenStore.removeAccessToken(accessToken);
        }
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

    public UserT getUserById(Integer userId) {
        if (userId == null) {
            return null;
        }
        return userTMapper.selectByPrimaryKey(userId);
    }

    public List<String> getAuthoritiesByUserId(Integer userId) {
        if (userId == null) {
            return null;
        }
        return userTMapper.selectResourceCodeByUserId(userId);
    }

}
