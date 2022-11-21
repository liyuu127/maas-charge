package com.haylion.common.notice.service.process;

import com.haylion.common.notice.model.AbstractNotice;

/**
 * @author liyu
 * date 2021/4/7 10:06
 * description
 * t extends{@link AbstractNotice}
 */

public interface SiteNoticeProcessHandler<T> {

    public void saveSiteNotice(T t);
}
