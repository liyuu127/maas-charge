package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.UserRoleT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liyu
 * date 2022/4/8 11:49
 * description
 */
@Mapper
public interface UserRoleTMapper {
    int insert(UserRoleT record);

    int insertOrUpdate(UserRoleT record);

    int insertOrUpdateSelective(UserRoleT record);

    int insertSelective(UserRoleT record);

    UserRoleT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleT record);

    int updateByPrimaryKey(UserRoleT record);

    int deleteByUserId(@Param("userId") Integer userId);

    int deleteByRoleId(@Param("roleId") Integer roleId);
}