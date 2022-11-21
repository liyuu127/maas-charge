package com.haylion.common.repository.mapper;

import com.haylion.common.entity.dto.order.OrderMaterialReportListDto;
import com.haylion.common.entity.entity.ScmOrderMaterialReport;

import java.util.List;
import java.util.Set;

import com.haylion.common.repository.model.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liyu
 * date 2022/9/27 14:38
 * description
 */
@Mapper
public interface ScmOrderMaterialReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScmOrderMaterialReport record);

    int insertOrUpdate(ScmOrderMaterialReport record);

    int insertOrUpdateSelective(ScmOrderMaterialReport record);

    int insertSelective(ScmOrderMaterialReport record);

    ScmOrderMaterialReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScmOrderMaterialReport record);

    int updateByPrimaryKey(ScmOrderMaterialReport record);

    int updateBatch(List<ScmOrderMaterialReport> list);

    int batchInsert(@Param("list") List<ScmOrderMaterialReport> list);

    List<OrderMaterialReportListDto> selectList(@Param("materialId") Integer materialId, @Param("sorts") Set<Sort> sorts);

    Double sumReportById(@Param("materialId") Integer orderMaterialId);

}