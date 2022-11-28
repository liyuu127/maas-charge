package com.haylion.charge.user.web;

import com.github.pagehelper.PageInfo;
import com.haylion.common.core.constant.SecurityConstant;
import com.haylion.common.entity.dto.UserDetailDto;
import com.haylion.common.entity.vo.UserPermissionVo;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import com.haylion.common.log.annotation.SysOperateLog;
import com.haylion.charge.user.pojo.form.UserForm;
import com.haylion.charge.user.pojo.form.UserMobilePasswordForm;
import com.haylion.charge.user.pojo.form.UserPasswordUpdateForm;
import com.haylion.charge.user.pojo.vail.MobilePasswordReset;
import com.haylion.charge.user.pojo.vail.MobileUpdate;
import com.haylion.charge.user.pojo.vail.Register;
import com.haylion.charge.user.pojo.vail.UserStateUpdate;
import com.haylion.charge.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.haylion.common.core.constant.SecurityConstant.USER_STATE_FREEZE;

/**
 * @author liyu
 * date 2022/4/7 15:06
 * description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 添加用户
     *
     * @param userForm
     * @return
     */
    @PostMapping("/insert")
    @PreAuthorize("hasAuthority('user:insert')")
    @SysOperateLog(description = "添加用户")
    public void insert(@Validated(Add.class) @RequestBody UserForm userForm) {
        userService.insertUser(userForm);
    }

    @PostMapping("/register")
    @SysOperateLog(description = "注册用户")
    public void Register(@Validated(Register.class) @RequestBody UserForm userForm) {
        userService.insertUser(userForm);
    }

    /**
     * 删除用户
     *
     * @return
     */
    @SysOperateLog(description = "删除人员")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('user:delete')")
    public void delete(@Validated(Delete.class) @RequestBody UserForm userForm) {
        userService.deleteUserById(userForm.getId());
    }

    /**
     * 修改用户信息
     */
    @PostMapping("/update")
    @SysOperateLog(description = "修改人员信息")
    @PreAuthorize("hasAuthority('user:update')")
    public void update(@Validated(Update.class) @RequestBody UserForm userForm) {
        userService.updateUser(userForm);
    }

    /**
     * 修改用户信息
     */
    @PostMapping("/state/update")
    @SysOperateLog(description = "审核人员信息")
    @PreAuthorize("hasAuthority('user:state:update')")
    public void stateUpdate(@Validated(UserStateUpdate.class) @RequestBody UserForm userForm) {
        userService.updateUserState(userForm.getId(), userForm.getState());
    }

    @PostMapping("/logout")
    @SysOperateLog(description = "登出")
    public void logout() {
        userService.logout();
    }

    /**
     * 查询人员详情
     *
     * @return
     */
    @SysOperateLog(description = "查询人员详情")
    @GetMapping("/info")
    @PreAuthorize("hasAuthority('user:select')")
    public UserDetailDto info(@RequestParam(value = "userId", required = false) Integer userId) {
        return userService.info(userId == null ? SecurityUtil.getUser().getUserId() : userId);
    }

    @PostMapping("/password/update")
    @SysOperateLog(description = "修改密码")
    @PreAuthorize("hasAuthority('user:password')")
    public void updatePassword(@RequestBody UserPasswordUpdateForm passwordUpdate) {
        userService.updatePassword(SecurityUtil.getUser().getUserId(), passwordUpdate.getPassword(), passwordUpdate.getUpdatedPassword());
    }

    @GetMapping("/list")
    @SysOperateLog(description = "查询人员列表")
    @PreAuthorize("hasAuthority('user:list')")
    public PageInfo<UserDetailDto> selectList(@RequestParam(value = "name", required = false) String name,
                                              @RequestParam(value = "username", required = false) String username,
                                              @RequestParam(value = "card", required = false) String card,
                                              @RequestParam(value = "mobile", required = false) String mobile,
                                              @RequestParam(value = "states", required = false) Integer[] states,
                                              @RequestParam(value = "cId", required = false) Integer cId,
                                              @RequestParam(value = "dId", required = false) Integer dId,
                                              @RequestParam(value = "pId", required = false) Integer pId,
                                              @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return userService.selectList(name, username, card, states, mobile, cId, dId, pId, currentPage, pageSize);
    }

    @SysOperateLog(description = "查询权限code")
    @GetMapping("/permissionCode")
    public UserPermissionVo selectPermissionCodeByUsername(@RequestParam(value = "username", required = true) String username) {
        return userService.userPermission(username);
    }

    @SysOperateLog(description = "登录权限查询")
    @GetMapping("/login/info")
    public UserPermissionVo selectLoginInfo(@RequestParam(value = "username", required = true) String username,
                                            @RequestParam(value = "userType", required = false) Integer userType) {
        return userService.selectLoginInfo(username, userType);
    }

    @SysOperateLog(description = "密码重置")
    @PostMapping(value = "/password/reset")
    public void passwordReset(@RequestBody @Validated(MobilePasswordReset.class) UserMobilePasswordForm userMobilePasswordForm) {
        userService.passwordReset(userMobilePasswordForm.getMobile(), userMobilePasswordForm.getCode(), userMobilePasswordForm.getPassword());
    }

    /**
     * 更新手机号
     *
     * @return
     */
    @SysOperateLog(description = "修改账号手机号")
    @PreAuthorize("hasAuthority('user:phone:update')")
    @PostMapping("/phone/update")
    public void changePhone(@RequestBody @Validated(MobileUpdate.class) UserMobilePasswordForm userMobilePasswordForm) {
        userService.updatePhone(SecurityUtil.getUser().getUserId(), userMobilePasswordForm.getMobile(), userMobilePasswordForm.getCode());
    }
}
