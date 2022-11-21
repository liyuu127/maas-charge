package com.haylion.common.notice.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haylion.common.entity.dto.SiteNoticeDto;
import com.haylion.common.repository.mapper.SiteNoticeUserMapper;
import com.haylion.common.notice.constant.NoticeContentEnum;
import com.haylion.common.notice.constant.SiteNoticeConstant;
import com.haylion.common.notice.model.AbstractNotice;
import com.haylion.common.notice.service.process.SiteNoticeProcessHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyu
 * date 2021/4/6 19:01
 * description
 */
@Service
@Slf4j
public class SiteNoticeService {
    @Autowired
    private SiteNoticeUserMapper siteNoticeUserMapper;
    @Autowired
    private final Map<String, SiteNoticeProcessHandler> noticeProcessHandlerMap = new ConcurrentHashMap<>();

    public SiteNoticeService(Map<String, SiteNoticeProcessHandler> noticeProcessHandlerMap) {
        noticeProcessHandlerMap.forEach(this.noticeProcessHandlerMap::put);
    }

    /**
     * 保存消息
     * @param abstractNotice
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveSiteNotice(AbstractNotice abstractNotice) {
        noticeProcessHandlerMap.get(NoticeContentEnum.contentTypeOfValue(abstractNotice.getContentType()))
                .saveSiteNotice(abstractNotice);
    }

    /**
     * 分页查询消息
     *
     * @param userId
     * @param state
     * @param startTime
     * @param endTime
     * @param page
     * @param size
     * @return
     */
    public PageInfo<SiteNoticeDto> selectList(Integer userId, Integer state, Collection<Integer> sourceTypeCollection, Collection<Integer> contentTypeCollection, LocalDateTime startTime, LocalDateTime endTime, Integer page, Integer size) {
        PageInfo<SiteNoticeDto> siteNoticeDtoPageInfo = PageHelper.startPage(page, size).
                doSelectPageInfo(() -> siteNoticeUserMapper.selectByUserIdAndStateAndReadTimeBetween(userId, state, sourceTypeCollection, contentTypeCollection, startTime, endTime));

        return siteNoticeDtoPageInfo;
    }

    /**
     * 删除消息
     *
     * @param noticeUserIds
     */
    public void delete(Integer[] noticeUserIds) {
        if (noticeUserIds == null || noticeUserIds.length < 1) {
            return;
        }
        siteNoticeUserMapper.deletedByIdIn(Arrays.asList(noticeUserIds));
    }

    /**
     * 阅读指定消息
     *
     * @param noticeUserIds
     */
    public void read(Integer[] noticeUserIds) {
        if (noticeUserIds == null || noticeUserIds.length < 1) {
            return;
        }
        siteNoticeUserMapper.updateStateByIdInAndUserId(SiteNoticeConstant.READ_STATE_READ, Arrays.asList(noticeUserIds), null);
    }

    /**
     * 阅读所有消息
     *
     * @param userId
     */
    public void readAll(Integer userId) {
        siteNoticeUserMapper.updateStateByIdInAndUserId(SiteNoticeConstant.READ_STATE_READ, null, userId);
    }

    /**
     * 查询消息数量
     *
     * @param userId
     * @param state
     * @param startTime
     * @param endTime
     * @return
     */
    public long queryCount(Integer userId, Integer state, LocalDateTime startTime, LocalDateTime endTime) {
        long noticeCount = siteNoticeUserMapper.selectCountByUserIdAndStateAndReadTimeBetween(userId, state, startTime, endTime);
        return noticeCount;
    }

}
