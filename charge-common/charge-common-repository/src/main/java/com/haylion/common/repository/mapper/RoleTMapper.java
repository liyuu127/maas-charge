package com.haylion.common.repository.mapper;

import com.haylion.common.entity.dto.RoleDetailDto;
import com.haylion.common.entity.dto.RoleDto;
import com.haylion.common.entity.entity.RoleT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 * date 2022/4/7 14:27
 * description
 */
@Mapper
public interface RoleTMapper {
    int insert(RoleT record);

    int insertSelective(RoleT record);

    RoleT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleT record);

    int updateByPrimaryKey(RoleT record);

    List<RoleDto> selectList(@Param("name") String name, @Param("code") String code);

    RoleDetailDto queryInfo(int id);

    RoleT selectByNameOrCode(@Param("name") String name, @Param("code") String code);

    void deleteById(Integer id);
}