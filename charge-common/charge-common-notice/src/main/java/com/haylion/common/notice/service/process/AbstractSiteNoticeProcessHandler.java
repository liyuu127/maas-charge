package com.haylion.common.notice.service.process;

import com.haylion.common.entity.entity.SiteNoticeSource;
import com.haylion.common.notice.model.AbstractNotice;

import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2021/4/7 10:25
 * description
 */
public abstract class AbstractSiteNoticeProcessHandler<T> implements SiteNoticeProcessHandler<T> {

    public SiteNoticeSource convertSiteNoticeSource(AbstractNotice abstractNotice) {
        if (abstractNotice == null) {
            return null;
        }
        SiteNoticeSource siteNoticeSource = new SiteNoticeSource();
        siteNoticeSource.setSourceId(abstractNotice.getSourceId());
        siteNoticeSource.setSourceType(abstractNotice.getSourceType());
        siteNoticeSource.setContentType(abstractNotice.getContentType());
        siteNoticeSource.setSourceContent(abstractNotice.getSourceContent());
        siteNoticeSource.setRemindTime(abstractNotice.getRemindTime());
        siteNoticeSource.setCreateTime(LocalDateTime.now());
        return siteNoticeSource;
    }
}
