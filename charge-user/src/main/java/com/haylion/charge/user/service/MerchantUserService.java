package com.haylion.charge.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.charge.user.pojo.form.UserForm;
import com.haylion.charge.user.pojo.vo.UserInfoVo;
import com.haylion.charge.user.utils.convert.UserConvert;
import com.haylion.common.entity.dto.UserDetailDto;
import com.haylion.common.entity.entity.ChargeMerchant;
import com.haylion.common.entity.entity.ChargeMerchantUser;
import com.haylion.common.entity.entity.ChargeTerminalUser;
import com.haylion.common.repository.dto.MerchantUserListDto;
import com.haylion.common.repository.dto.TerminalUserListDto;
import com.haylion.common.repository.mapper.ChargeMerchantUserMapper;
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
public class MerchantUserService {

    public final ChargeMerchantUserMapper merchantUserMapper;
    public final UserService userService;
    public final RoleService roleService;

    public void insertMerchantUser(UserForm userForm) {
        ChargeMerchantUser merchantUser = UserConvert.INSTANCE.fromToMerchantUser(userForm);

        merchantUser.setId(null);
        merchantUserMapper.insert(merchantUser);
    }


    public boolean existByMerchantId(Integer merchantId) {
        if (merchantId == null) {
            return false;
        }
        return merchantUserMapper.selectExistByMerchantId(merchantId);
    }

    public PageInfo<MerchantUserListDto> selectList(String name, String username, String card, Integer[] states, String mobile, Integer merchantId, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(merchantUserMapper.selectListUser(username, mobile, name, merchantId, card, states));
    }

    public UserInfoVo info(Integer userId) {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserT(userService.getUserById(userId));
        userInfoVo.setChargeMerchantUser(getUserByUserId(userId));
        userInfoVo.setRoleT(roleService.getRolesByUserId(userId));
        userInfoVo.setAuthorities(userService.getAuthoritiesByUserId(userId));
        return userInfoVo;
    }

    public ChargeMerchantUser getUserByUserId(Integer userId) {
        if (userId == null) {
            return null;
        }
        return merchantUserMapper.selectOneByUserId(userId);
    }
}
