package com.haylion.common.notice.util;

import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.notice.constant.RetStubDetail;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;

import static com.haylion.common.notice.constant.NoticeContentEnum.FEEDBACK_NUMBER_NOTICE;
import static com.haylion.common.notice.constant.NoticeContentEnum.FEEDBACK_QUALITY_NOTICE;
import static com.haylion.common.notice.constant.NoticeContentEnum.ORDER_ADD_NOTICE;
import static com.haylion.common.notice.constant.NoticeContentEnum.ORDER_POSTPONE_NOTICE;
import static com.haylion.common.notice.constant.NoticeContentEnum.ORDER_WARNING_NOTICE;

/**
 * @author liyu
 * date 2021/4/7 19:39
 * description
 */
@Data
public class NoticeContentParser {

    private static HashMap<Integer, String> messageMap = new HashMap() {{
        put(ORDER_ADD_NOTICE.getContentType(), "收到{0}采购订单，请注意签收。");
        put(ORDER_POSTPONE_NOTICE.getContentType(), "{0}采购订单{1}物料已延期交付，请及时安排处理。");
        put(ORDER_WARNING_NOTICE.getContentType(), "{0}采购订单{1}物料即将延期，请及时安排处理。");
        put(FEEDBACK_QUALITY_NOTICE.getContentType(), "收到{0}采购订单物料{1}反馈用料质量问题。");
        put(FEEDBACK_NUMBER_NOTICE.getContentType(), " {0}采购订单物料{1}反馈用料质量问题已达本采购订单数量3%，请及时分析。");

    }};

    public String parser(String purchaseCode, String materialCode, Integer contentType) {
        String message = messageMap.get(contentType);
        if (StringUtils.isBlank(message)) {
            throw new ApplicationException(RetStubDetail.MESSAGE_TYPE_ERROR);
        }
        MessageFormat messageFormat = new MessageFormat(message, Locale.getDefault());
        String sourceContent = messageFormat.format(new Object[]{purchaseCode,materialCode});
        return sourceContent;
    }
}
