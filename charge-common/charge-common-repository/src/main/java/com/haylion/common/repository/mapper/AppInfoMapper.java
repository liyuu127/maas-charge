package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.AppInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyu
 *  date 2022/4/7 14:27
 *  description 
 */
@Mapper
public interface AppInfoMapper {

    int updateBatch(List<AppInfo> list);

    int batchInsert(@Param("list") List<AppInfo> list);

    int insertOrUpdate(AppInfo record);

    int insertOrUpdateSelective(AppInfo record);

    int insertSelective(AppInfo appInfo);

    List<AppInfo> selectAppInfoList(@Param("type") Byte type,@Param("versionNumber") Integer versionNumber,@Param("versionName") String versionName);

    void validCurrent(@Param("id") Integer id);

    void invalidOld(@Param("id") Integer id, @Param("appType") Integer appType);

    AppInfo selectLatestVersionAppInfo(@Param("appType") Byte appType);

    AppInfo selectById(@Param("id") Integer id);
}