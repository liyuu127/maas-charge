package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.LookupChildT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 *  date 2022/4/7 14:27
 *  description 
 */
@Mapper
public interface LookupChildTMapper {
    int insert(LookupChildT record);

    int insertSelective(LookupChildT record);

    LookupChildT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LookupChildT record);

    int updateByPrimaryKey(LookupChildT record);

    void delete(Integer id);

    void deleteByPid(Integer pid);

    int countByValueAndPid(@Param("value") String value, @Param("pid") Integer pid, @Param("id") Integer id);

    List<LookupChildT> listLookupChildByPid(Integer pid);

    List<LookupChildT> listLookupChildByPvalue(String value);

    String selectMaxOrdersByPid(@Param("pId") Integer pId);

    LookupChildT selectByParentValueAndKey(@Param("parentValue")String parentValue, @Param("key")String key);
}