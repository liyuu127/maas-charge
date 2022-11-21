package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.ScmOrder;
import com.haylion.common.entity.dto.QualityFeedbackFileDto;
import com.haylion.common.entity.dto.order.OrderMaterialDto;
import com.haylion.common.entity.entity.ScmOrderMaterial;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liyu
 * date 2022/9/27 14:38
 * description
 */
@Mapper
public interface ScmOrderMaterialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScmOrderMaterial record);

    int insertOrUpdate(ScmOrderMaterial record);

    int insertOrUpdateSelective(ScmOrderMaterial record);

    int insertSelective(ScmOrderMaterial record);

    ScmOrderMaterial selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScmOrderMaterial record);

    int updateByPrimaryKey(ScmOrderMaterial record);

    int updateBatch(List<ScmOrderMaterial> list);

    int batchInsert(@Param("list") List<ScmOrderMaterial> list);

    Optional<ScmOrderMaterial> getByIdForUpdate(@Param("orderMaterialId") Integer orderMaterialId);

    Optional<ScmOrderMaterial> getByOrderIdAndMaterialCode(@Param("orderId") Integer orderId, @Param("materialCode") String materialCode);

    List<ScmOrderMaterial> selectByOrderId(@Param("orderId") Integer orderId);

    ScmOrderMaterial selectById(@Param("orderMaterialId") Integer orderMaterialId);

    ScmOrder selectOrderById(@Param("orderMaterialId") Integer orderMaterialId);

    @MapKey("orderMaterialId")
    Map<String,OrderMaterialDto> selectOrderMaterialByIds(@Param("list")List<QualityFeedbackFileDto> list);
}