package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.RoleResourceT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liyu
 * date 2022/4/7 14:27
 * description
 */
@Mapper
public interface RoleResourceTMapper {
    int insert(RoleResourceT record);

    int insertSelective(RoleResourceT record);

    RoleResourceT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleResourceT record);

    int updateByPrimaryKey(RoleResourceT record);

    int insertList(@Param("roleId") Integer roleId, @Param("resourceIdList") List<Integer> resourceIdList);

    int deleteByRoleId(@NotNull @Param("roleId") Integer roleId);
}