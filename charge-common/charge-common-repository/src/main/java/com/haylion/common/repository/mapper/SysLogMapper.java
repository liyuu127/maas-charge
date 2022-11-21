package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liyu
 *  date 2022/4/14 17:10
 *  description 
 */
@Mapper
public interface SysLogMapper {
    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}