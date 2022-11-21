package com.haylion.common.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2021/4/7 12:48
 * description
 */
@Data
public class SiteNoticeDto {

    /**
     * 事件源id
     */
    private Integer sourceId;

    /**
     * 事件源类型
     */
    private Integer sourceType;

    /**
     * 内容类型
     */
    private Integer contentType;

    /**
     * 事件源的内容
     */
    private String sourceContent;

    private LocalDateTime remindTime;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private Integer noticeUserId;

    private Integer siteNoticeId;

    /**
     * 是否已读 1:未读；2：已读
     */
    private Integer state;

    private LocalDateTime readTime;
}
