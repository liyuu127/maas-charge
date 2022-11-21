package com.haylion.common.entity.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liyu
 *  date 2021/4/6 18:53
 *  description 
 */
@Data
@Accessors(chain = true)
public class SiteNoticeSource implements Serializable {
    private Integer id;

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

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}