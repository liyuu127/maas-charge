package com.haylion.common.notice.model;

import com.haylion.common.notice.util.NoticeContentParser;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @Description
 * @Author hqf
 * @Date 2022/9/29
 **/
@Data
public class OrderNotice extends AbstractNotice {
//    private Set<Integer> userIdSet;
    private String supplierCode;
    private String purchaseCode;
    private String materialCode;
    private NoticeContentParser noticeContentParser = new NoticeContentParser();

    public OrderNotice(Integer sourceId, Integer sourceType, Integer contentType, LocalDateTime remindTime, String supplierCode,String purchaseCode,String materialCode) {
        super(sourceId, sourceType, contentType, remindTime);
        this.supplierCode = supplierCode;
        this.materialCode = materialCode;
        this.purchaseCode = purchaseCode;
        this.setSourceContent(noticeContentParser.parser(this.purchaseCode,this.materialCode,contentType));
    }
}
