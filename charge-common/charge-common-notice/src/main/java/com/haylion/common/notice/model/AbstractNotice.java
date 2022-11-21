package com.haylion.common.notice.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2021/4/7 8:53
 * description
 */
@Data
public abstract class AbstractNotice {
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
     * 实现类去手动填充
     */
    private String sourceContent;
    private LocalDateTime remindTime;

    public AbstractNotice(Integer sourceId, Integer sourceType, Integer contentType, LocalDateTime remindTime) {
        this.sourceId = sourceId;
        this.sourceType = sourceType;
        this.contentType = contentType;
        this.remindTime = remindTime;
    }

    public AbstractNotice(Integer sourceId, Integer sourceType, Integer contentType) {
        this.sourceId = sourceId;
        this.sourceType = sourceType;
        this.contentType = contentType;
        this.remindTime = LocalDateTime.now();
    }

}
