package com.haylion.common.repository.mapper;

import com.haylion.common.entity.entity.SysOauthClientDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liyu
 *  date 2022/4/7 14:27
 *  description 
 */
@Mapper
public interface SysOauthClientDetailsMapper {
    int insert(SysOauthClientDetails record);

    int insertSelective(SysOauthClientDetails record);

    SysOauthClientDetails selectByPrimaryKey(String clientId);

    int updateByPrimaryKeySelective(SysOauthClientDetails record);

    int updateByPrimaryKey(SysOauthClientDetails record);
}