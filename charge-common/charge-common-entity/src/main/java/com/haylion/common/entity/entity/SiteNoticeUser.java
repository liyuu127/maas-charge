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
public class SiteNoticeUser implements Serializable {
    private Integer id;

    private Integer siteNoticeId;

    private Integer userId;

    /**
    * 是否已读 1:未读；2：已读
    */
    private Integer state;

    private LocalDateTime readTime;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}