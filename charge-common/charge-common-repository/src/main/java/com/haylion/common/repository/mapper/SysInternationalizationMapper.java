package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.SysInternationalization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 *  date 2022/4/7 14:27
 *  description 
 */
@Mapper
public interface SysInternationalizationMapper {
    int insert(SysInternationalization record);

    int insertSelective(SysInternationalization record);

    SysInternationalization selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysInternationalization record);

    int updateByPrimaryKey(SysInternationalization record);

    List<SysInternationalization> selectAllInUse();

    List<SysInternationalization> selectListByConditions(@Param("code")String code,@Param("value")String value);

    List<SysInternationalization> varyIdAndCode(@Param("id")Integer id,@Param("code")String code);

    void deleteById(@Param("id") Integer id);
}