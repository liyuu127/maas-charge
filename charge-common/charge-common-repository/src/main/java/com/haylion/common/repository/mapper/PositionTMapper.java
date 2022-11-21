package com.haylion.common.repository.mapper;

import com.haylion.common.entity.dto.PositionDto;
import com.haylion.common.entity.dto.PositionInfoDto;
import com.haylion.common.entity.entity.PositionT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 * date 2022/5/18 9:45
 * description
 */
@Mapper
public interface PositionTMapper {
    int insert(PositionT record);

    int insertSelective(PositionT record);

    PositionT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PositionT record);

    int updateByPrimaryKey(PositionT record);

    List<PositionDto> selectList(@Param("name") String name, @Param("dId") Integer dId, @Param("cId") Integer cId);

    PositionT selectByNameAndDId(@Param("name") String name, @Param("dId") Integer dId);

    Boolean selectPositionExitByDId(@Param("dId") Integer dId);

    PositionInfoDto selectInfo(@Param("id") Integer id);
}