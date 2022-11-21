package com.haylion.common.repository.mapper;

import com.haylion.common.entity.dto.order.OrderDeferDto;
import com.haylion.common.entity.dto.order.OrderInfoDto;
import com.haylion.common.repository.model.Sort;
import com.haylion.common.entity.dto.order.OrderListDto;
import com.haylion.common.entity.entity.ScmOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.haylion.common.entity.param.OrderListQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liyu
 * date 2022/9/27 14:38
 * description
 */
@Mapper
public interface ScmOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScmOrder record);

    int insertOrUpdate(ScmOrder record);

    int insertOrUpdateSelective(ScmOrder record);

    int insertSelective(ScmOrder record);

    ScmOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScmOrder record);

    int updateByPrimaryKey(ScmOrder record);

    int updateBatch(List<ScmOrder> list);

    int batchInsert(@Param("list") List<ScmOrder> list);

    List<OrderListDto> selectList(@Param("order") OrderListQueryParam orderListQueryParam, @Param("sorts") List<Sort> sorts);

    Optional<OrderInfoDto> getInfo(@Param("orderMaterialId") Integer orderMaterialId);

    Optional<ScmOrder> getByPurchaseCode(@Param("purchaseCode") String purchaseCode);

    List<OrderDeferDto> selectDeferOrder(@Param("currentDate") LocalDate currentDate, @Param("date")LocalDate date, @Param("contentType") Integer contentType);

    List<ScmOrder> getOrderInfoByPurchaseCode(@Param("purchaseCode") String purchaseCode, @Param("supplierCode") String supplierCode);
}