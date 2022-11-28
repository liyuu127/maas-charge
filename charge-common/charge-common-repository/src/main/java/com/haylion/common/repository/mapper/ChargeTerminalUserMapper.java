package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.ChargeTerminalUser;
import com.haylion.common.repository.dto.TerminalUserListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 * date 2022/11/25 14:20
 * description
 */
@Mapper
public interface ChargeTerminalUserMapper {
    int insert(ChargeTerminalUser record);

    int insertOrUpdate(ChargeTerminalUser record);

    int insertOrUpdateSelective(ChargeTerminalUser record);

    int insertSelective(ChargeTerminalUser record);

    ChargeTerminalUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChargeTerminalUser record);

    int updateByPrimaryKey(ChargeTerminalUser record);

    int updateBatch(List<ChargeTerminalUser> list);

    int batchInsert(@Param("list") List<ChargeTerminalUser> list);

    List<TerminalUserListDto> selectListUser(@Param("username") String username,
                                             @Param("mobile") String mobile,
                                             @Param("name") String name,
                                             @Param("card") String card,
                                             @Param("states") Integer[] states);

    ChargeTerminalUser selectOneByUserId(@Param("userId") Integer userId);
}