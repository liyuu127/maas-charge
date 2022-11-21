package com.haylion.common.notice.constant;

import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.core.exception.SysStubInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author liyu
 * date 2021/4/7 9:33
 * description
 */
@Getter
@AllArgsConstructor
public enum NoticeSourceEnum {

    ORDER_NOTICE(1,"orderNotice"),
    FEEDBACK_NOTICE(2,"feedbackNotice"),
    ;

    private int sourceType;
    private String value;

    public static NoticeSourceEnum sourceTypeOf(int sourceType) {
        for (NoticeSourceEnum noticeEnum : NoticeSourceEnum.values()) {
            if (Objects.equals(noticeEnum.getSourceType(), sourceType)) {
                return noticeEnum;
            }
        }
        throw new ApplicationException(SysStubInfo.DEFAULT_FAIL);
    }

    public static String sourceTypeOfValue(int sourceType) {
        for (NoticeSourceEnum noticeEnum : NoticeSourceEnum.values()) {
            if (Objects.equals(noticeEnum.getSourceType(), sourceType)) {
                return noticeEnum.getValue();
            }
        }
        throw new ApplicationException(SysStubInfo.DEFAULT_FAIL);
    }
}
