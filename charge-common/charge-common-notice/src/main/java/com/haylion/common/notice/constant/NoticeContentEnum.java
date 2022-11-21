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
public enum NoticeContentEnum {

    ORDER_ADD_NOTICE(0,"orderNotice"), // 新订单
    ORDER_POSTPONE_NOTICE(1,"orderNotice"), // 订单延期
    ORDER_WARNING_NOTICE(2,"orderNotice"), // 订单预警
    FEEDBACK_QUALITY_NOTICE(3,"feedbackNotice"), // 质量反馈
    FEEDBACK_NUMBER_NOTICE(4,"feedbackNotice"), // 质量反馈数量告警
    ;



    private int contentType;
    private String value;

    public static NoticeContentEnum contentTypeOf(int contentType) {
        for (NoticeContentEnum noticeContentEnum : NoticeContentEnum.values()) {
            if (Objects.equals(noticeContentEnum.getContentType(), contentType)) {
                return noticeContentEnum;
            }
        }
        throw new ApplicationException(SysStubInfo.DEFAULT_FAIL);
    }

    public static String contentTypeOfValue(int contentType) {
        for (NoticeContentEnum noticeContentEnum : NoticeContentEnum.values()) {
            if (Objects.equals(noticeContentEnum.getContentType(), contentType)) {
                return noticeContentEnum.getValue();
            }
        }
        throw new ApplicationException(SysStubInfo.DEFAULT_FAIL);
    }
}
