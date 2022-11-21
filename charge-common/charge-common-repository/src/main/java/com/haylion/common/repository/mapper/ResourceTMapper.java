package com.haylion.common.repository.mapper;

import com.haylion.common.entity.dto.ResourceDto;
import com.haylion.common.entity.entity.ResourceT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 * date 2022/4/7 14:27
 * description
 */
@Mapper
public interface ResourceTMapper {
    int insert(ResourceT record);

    int insertSelective(ResourceT record);

    ResourceT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourceT record);

    int updateByPrimaryKey(ResourceT record);

    List<ResourceDto> selectList(@Param("userId") Integer userId,
                                 @Param("name") String name,
                                 @Param("pId") Integer pId,
                                 @Param("status") Integer status,
                                 @Param("group") String group);

    List<ResourceDto> selectAll();

}