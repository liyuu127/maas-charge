package com.haylion.charge.user.service;


import com.haylion.common.entity.entity.UserRoleT;
import com.haylion.common.repository.mapper.UserRoleTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyu
 * date 2021/1/17 17:06
 * description
 */
@Service
public class UserRoleService {


    @Autowired
    UserRoleTMapper userRoleTMapper;


    /**
     * 添加一个用户角色关联
     */
    public void insertUserRole(Integer userId, Integer roleId) {
        UserRoleT userRoleT = new UserRoleT();
        userRoleT.setUserId(userId);
        userRoleT.setRoleId(roleId);
        userRoleTMapper.insert(userRoleT);

    }


    /**
     * 逻辑删除用户
     *
     * @param userId
     */
    public void deleteUserRoleByUserId(Integer userId) {
        userRoleTMapper.deleteByUserId(userId);
    }

    public void deleteUserRoleByRoleId(Integer roleId) {
        userRoleTMapper.deleteByRoleId(roleId);
    }

    /**
     * 更新用户角色关联
     */
    public void updateUserRole(Integer userId, Integer roleId) {
        UserRoleT userRoleT = new UserRoleT();
        userRoleT.setUserId(userId);
        userRoleT.setRoleId(roleId);
        userRoleTMapper.insertOrUpdateSelective(userRoleT);
    }
}
