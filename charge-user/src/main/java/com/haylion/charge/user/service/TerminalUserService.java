package com.haylion.charge.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.charge.user.pojo.form.UserForm;
import com.haylion.charge.user.pojo.vo.UserInfoVo;
import com.haylion.charge.user.utils.convert.UserConvert;
import com.haylion.common.entity.dto.UserDetailDto;
import com.haylion.common.entity.entity.ChargeMerchantUser;
import com.haylion.common.entity.entity.ChargeTerminalUser;
import com.haylion.common.repository.dto.TerminalUserListDto;
import com.haylion.common.repository.mapper.ChargeTerminalUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2022/11/25 15:17
 * description
 */
@Service
@AllArgsConstructor
public class TerminalUserService {

    public final ChargeTerminalUserMapper terminalUserMapper;
    public final UserService userService;
    public final RoleService roleService;

    public void insertTerminalUser(UserForm userForm) {
        ChargeTerminalUser terminalUser = UserConvert.INSTANCE.fromToTerminalUser(userForm);

        terminalUser.setId(null)
                .setApplyTime(LocalDateTime.now());
        terminalUserMapper.insert(terminalUser);
    }

    public PageInfo<TerminalUserListDto> selectList(String name, String username, String card, Integer[] states, String mobile, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);

        return new PageInfo<>(terminalUserMapper.selectListUser(username, mobile, name, card, states));
    }

    public UserInfoVo info(Integer userId) {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserT(userService.getUserById(userId));
        userInfoVo.setChargeTerminalUser(getUserByUserId(userId));
        userInfoVo.setRoleT(roleService.getRolesByUserId(userId));
        userInfoVo.setAuthorities(userService.getAuthoritiesByUserId(userId));
        return userInfoVo;
    }

    public ChargeTerminalUser getUserByUserId(Integer userId) {
        if (userId == null) {
            return null;
        }
        return terminalUserMapper.selectOneByUserId(userId);
    }
}
