package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.ColorDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 * date 2022/5/18 9:45
 * description
 */
@Mapper
public interface ColorDictMapper {
    int insert(ColorDict record);

    int insertSelective(ColorDict record);

    ColorDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ColorDict record);

    int updateByPrimaryKey(ColorDict record);

    boolean selectNameExists(@Param("name") String name, @Param("sourceType") Integer sourceType);

    ColorDict selectByNameAndSourceType(@Param("name")String name, @Param("sourceType")Integer sourceType);


    List<ColorDict> queryList(@Param("name") String name, @Param("sourceType") Integer sourceType);
}