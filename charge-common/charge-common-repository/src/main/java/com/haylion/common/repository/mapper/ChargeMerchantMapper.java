package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.ChargeMerchant;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liyu
 * date 2022/11/25 17:54
 * description
 */
@Mapper
public interface ChargeMerchantMapper {
    int insert(ChargeMerchant record);

    int insertOrUpdate(ChargeMerchant record);

    int insertOrUpdateSelective(ChargeMerchant record);

    int insertSelective(ChargeMerchant record);

    ChargeMerchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChargeMerchant record);

    int updateByPrimaryKey(ChargeMerchant record);

    int updateBatch(List<ChargeMerchant> list);

    int batchInsert(@Param("list") List<ChargeMerchant> list);

    Optional<ChargeMerchant> selectByName(@Param("name") String name);

    Optional<ChargeMerchant> selectByCode(@Param("code") String code);

    List<ChargeMerchant> selectList(@Param("name") String name, @Param("types") Integer[] types, @Param("code") String code);
}