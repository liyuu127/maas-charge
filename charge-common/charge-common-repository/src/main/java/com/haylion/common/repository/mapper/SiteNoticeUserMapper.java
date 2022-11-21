package com.haylion.common.repository.mapper;

import com.haylion.common.entity.dto.SiteNoticeDto;
import com.haylion.common.entity.entity.SiteNoticeUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * @author liyu
 * date 2021/4/6 18:53
 * description
 */
@Mapper
public interface SiteNoticeUserMapper {
    int insertSelective(SiteNoticeUser record);

    SiteNoticeUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SiteNoticeUser record);

    int batchInsert(@Param("list") List<SiteNoticeUser> list);

    int batchInsertByUserId(@Param("userIdCollection") Collection<Integer> userIdCollection, @Param("siteNoticeId") Integer siteNoticeId, @Param("state") Integer state);

    int insertOrUpdate(SiteNoticeUser record);

    int insertOrUpdateSelective(SiteNoticeUser record);

    List<SiteNoticeDto> selectByUserIdAndStateAndReadTimeBetween(@Param("userId") Integer userId,
                                                                 @Param("state") Integer state,
                                                                 @Param("sourceTypeCollection") Collection<Integer> sourceTypeCollection,
                                                                 @Param("contentTypeCollection") Collection<Integer> contentTypeCollection,
                                                                 @Param("startRemindTime") LocalDateTime startRemindTime,
                                                                 @Param("endRemindTime") LocalDateTime endRemindTime);

    long selectCountByUserIdAndStateAndReadTimeBetween(@Param("userId") Integer userId,
                                                       @Param("state") Integer state,
                                                       @Param("startRemindTime") LocalDateTime startRemindTime,
                                                       @Param("endRemindTime") LocalDateTime endRemindTime);


    int deletedByIdIn(@Param("idCollection") Collection<Integer> idCollection);

	int updateStateByIdInAndUserId(@Param("updatedState") Integer updatedState,
                                   @Param("idCollection") Collection<Integer> idCollection,
                                   @Param("userId") Integer userId);


}