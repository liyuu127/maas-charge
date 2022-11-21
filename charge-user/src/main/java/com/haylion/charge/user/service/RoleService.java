package com.haylion.charge.user.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.dto.RoleDetailDto;
import com.haylion.common.entity.dto.RoleDto;
import com.haylion.common.entity.entity.RoleT;
import com.haylion.common.auth.util.SecurityUtil;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.repository.mapper.RoleTMapper;
import com.haylion.charge.user.constant.RetStubDetail;
import com.haylion.charge.user.pojo.form.RoleForm;
import com.haylion.charge.user.utils.convert.RoleConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2021/1/17 17:06
 * description
 */
@Service
public class RoleService {

    @Autowired
    RoleTMapper roleTMapper;
    @Autowired
    RoleResourceService roleResourceService;
    @Autowired
    UserRoleService userRoleService;


    public PageInfo<RoleDto> selectList(String name, String code, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(roleTMapper.selectList(name, code));
    }

    public RoleDetailDto info(Integer id) {
        return roleTMapper.queryInfo(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void add(RoleForm roleForm) {
        var role = roleTMapper.selectByNameOrCode(roleForm.getName(), roleForm.getCode());
        if (role != null) {
            throw new ApplicationException(RetStubDetail.ROLE_NAME_OR_CODE_EXIST);
        }
        role = RoleConvert.INSTANCE.formToEntity(roleForm);
        role.setCreateBy(SecurityUtil.getUsername());
        role.setCreateTime(LocalDateTime.now());
        roleTMapper.insert(role);
        roleResourceService.updateUserRole(role.getId(), roleForm.getResourceIdList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(RoleForm roleForm) {
        RoleT role = null;
        if (roleForm.getName() != null || roleForm.getCode() != null) {
            role = roleTMapper.selectByNameOrCode(roleForm.getName(), roleForm.getCode());
        }
        if (role != null && !role.getId().equals(roleForm.getId())) {
            throw new ApplicationException(RetStubDetail.ROLE_NAME_OR_CODE_EXIST);
        }
        role = RoleConvert.INSTANCE.formToEntity(roleForm);
        role.setUpdateBy(SecurityUtil.getUsername());
        role.setUpdateTime(LocalDateTime.now());
        roleTMapper.updateByPrimaryKeySelective(role);
        roleResourceService.updateUserRole(role.getId(), roleForm.getResourceIdList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(RoleForm roleForm) {
        Integer roleId = roleForm.getId();
        roleTMapper.deleteById(roleId);
        roleResourceService.deleteUserRole(roleId);
        userRoleService.deleteUserRoleByRoleId(roleId);
    }
}
