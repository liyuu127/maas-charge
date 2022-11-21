package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.SiteNoticeSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 *  date 2021/4/6 18:53
 *  description 
 */
@Mapper
public interface SiteNoticeSourceMapper {
    int insertSelective(SiteNoticeSource record);

    SiteNoticeSource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SiteNoticeSource record);

    int batchInsert(@Param("list") List<SiteNoticeSource> list);

    int insertOrUpdate(SiteNoticeSource record);

    int insertOrUpdateSelective(SiteNoticeSource record);
}