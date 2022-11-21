package com.haylion.common.repository.mapper;

import com.haylion.common.entity.dto.order.OrderMaterialOpeListDto;
import com.haylion.common.entity.entity.ScmOrderMaterialOperation;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liyu
 *  date 2022/9/27 14:38
 *  description 
 */
@Mapper
public interface ScmOrderMaterialOperationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScmOrderMaterialOperation record);

    int insertOrUpdate(ScmOrderMaterialOperation record);

    int insertOrUpdateSelective(ScmOrderMaterialOperation record);

    int insertSelective(ScmOrderMaterialOperation record);

    ScmOrderMaterialOperation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScmOrderMaterialOperation record);

    int updateByPrimaryKey(ScmOrderMaterialOperation record);

    int updateBatch(List<ScmOrderMaterialOperation> list);

    int batchInsert(@Param("list") List<ScmOrderMaterialOperation> list);

    List<OrderMaterialOpeListDto> selectList(@Param("orderMaterialId")Integer orderMaterialId);
}