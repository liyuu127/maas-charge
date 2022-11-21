package com.haylion.charge.user.service;


import com.haylion.common.repository.mapper.RoleResourceTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liyu
 * date 2021/1/17 17:06
 * description
 */
@Service
public class RoleResourceService {


    @Autowired
    RoleResourceTMapper roleResourceTMapper;


    public void insertUserRole(Integer roleId, @NotNull List<Integer> resourceIdList) {
        if (resourceIdList.isEmpty()) {
            return;
        }
        roleResourceTMapper.insertList(roleId, resourceIdList);

    }


    public void deleteUserRole(Integer roleId) {
        roleResourceTMapper.deleteByRoleId(roleId);
    }

    /**
     * 更新用户角色关联
     */
    public void updateUserRole(Integer roleId, List<Integer> resourceIdList) {
        deleteUserRole(roleId);
        if (resourceIdList != null && !resourceIdList.isEmpty()) {
            insertUserRole(roleId, resourceIdList);
        }
    }
}
