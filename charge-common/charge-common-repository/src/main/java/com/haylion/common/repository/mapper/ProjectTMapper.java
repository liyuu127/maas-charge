package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.ProjectT;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liyu
 *  date 2022/4/7 14:27
 *  description 
 */
@Mapper
public interface ProjectTMapper {
    int insert(ProjectT record);

    int insertSelective(ProjectT record);

    ProjectT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectT record);

    int updateByPrimaryKey(ProjectT record);
}