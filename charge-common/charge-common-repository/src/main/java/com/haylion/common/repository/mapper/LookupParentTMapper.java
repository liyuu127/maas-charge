package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.LookupParentT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 * date 2022/4/7 14:27
 * description
 */
@Mapper
public interface LookupParentTMapper {
    int insert(LookupParentT record);

    int insertSelective(LookupParentT record);

    LookupParentT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LookupParentT record);

    int updateByPrimaryKey(LookupParentT record);

    List<LookupParentT> list(@Param("value") String value, @Param("name") String name);

    void delete(Integer id);

    int countByValue(@Param("value") String value, @Param("id") Integer id);

    LookupParentT selectByValue(@Param("value") String value);

    LookupParentT getInfo(@Param("value") String value);
}