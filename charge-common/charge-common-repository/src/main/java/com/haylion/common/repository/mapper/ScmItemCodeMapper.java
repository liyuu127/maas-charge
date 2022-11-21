package com.haylion.common.repository.mapper;

import com.haylion.common.core.model.Condition;
import com.haylion.common.entity.dto.order.ScmItemCodeDto;
import com.haylion.common.entity.entity.ScmItemCode;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

/**
 * @author  LaiXiaoPeng
 * @date  2022/9/30 11:41
 * @version 1.0
 */
public interface ScmItemCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScmItemCode record);

    int insertSelective(ScmItemCode record);

    ScmItemCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScmItemCode record);

    int updateByPrimaryKey(ScmItemCode record);

    int updateBatchSelective(List<ScmItemCode> list);

    int batchInsert(@Param("list") List<ScmItemCode> list);

    List<ScmItemCodeDto> selectListByOrderNameAndMaterialCode(@Param("purchaseCode") String purchaseCode,
                                                              @Param("materialCode") String materialCode,
                                                              @Param("createStart") String createStart,
                                                              @Param("createEnd")String createEnd,
                                                              @Param("serialNumberStart")Integer serialNumberStart,
                                                              @Param("serialNumberEnd")Integer serialNumberEnd);

    Integer selectMaxSerialNoByConditions(@Param("conditions") List<Condition> conditions);

    @MapKey("purchaseItemCode")
    Map<String,ScmItemCode> selectListByPurchaseItemCode(@Param("purchaseItemCodeList") List<String> purchaseItemCodeList);

    void batchUpdatePrintStatusByIds(@Param("printStatus") Integer printStatus, @Param("ids") List<Integer> ids);
}