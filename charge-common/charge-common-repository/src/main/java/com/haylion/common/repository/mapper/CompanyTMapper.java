package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.CompanyT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 * date 2022/4/12 15:59
 * description
 */
@Mapper
public interface CompanyTMapper {
    int insert(CompanyT record);

    int insertSelective(CompanyT record);

    CompanyT selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyT record);

    int updateByPrimaryKey(CompanyT record);

    List<CompanyT> selectList(@Param("name") String name,
                              @Param("type") Integer[] type,
                              @Param("resName") String resName,
                              @Param("supplierCode") String supplierCode,
                              @Param("innerCompany") Integer innerCompany);

    CompanyT selectByName(@Param("name") String name);
    CompanyT selectBySupplierCode(@Param("supplierCode") String supplierCode);
}