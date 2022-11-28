package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.ChargeMerchantUser;

import java.util.List;

import com.haylion.common.repository.dto.MerchantUserListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liyu
 * date 2022/11/25 14:20
 * description
 */
@Mapper
public interface ChargeMerchantUserMapper {
    int insert(ChargeMerchantUser record);

    int insertOrUpdate(ChargeMerchantUser record);

    int insertOrUpdateSelective(ChargeMerchantUser record);

    int insertSelective(ChargeMerchantUser record);

    ChargeMerchantUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChargeMerchantUser record);

    int updateByPrimaryKey(ChargeMerchantUser record);

    int updateBatch(List<ChargeMerchantUser> list);

    int batchInsert(@Param("list") List<ChargeMerchantUser> list);

    List<MerchantUserListDto> selectListUser(@Param("username") String username,
                                             @Param("mobile") String mobile,
                                             @Param("name") String name,
                                             @Param("merchantId") Integer merchantId,
                                             @Param("card") String card,
                                             @Param("states") Integer[] states);

    boolean selectExistByMerchantId(@Param("merchantId") Integer merchantId);

    ChargeMerchantUser selectOneByUserId(@Param("userId") Integer userId);
}