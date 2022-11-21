package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.DepartmentT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 * date 2022/4/12 15:59
 * description
 */
@Mapper
public interface DepartmentTMapper {
    int insert(DepartmentT record);

    int insertSelective(DepartmentT record);

    DepartmentT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DepartmentT record);

    int updateByPrimaryKey(DepartmentT record);

    int insertOrUpdate(DepartmentT record);

    int insertOrUpdateSelective(DepartmentT record);

    List<DepartmentT> selectList(@Param("name") String name, @Param("cId") Integer cId, @Param("resName") String resName);

    DepartmentT selectByNameAndCId(@Param("name") String name, @Param("cId") Integer cId);

    boolean selectExistByCId(@Param("cId") Integer cId);

}