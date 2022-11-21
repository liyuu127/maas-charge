package com.haylion.common.entity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author liyu
 *  date 2022/4/7 14:27
 *  description 
 */
@Data
public class ProjectT implements Serializable {
    /**
    * 项目介绍表ID
    */
    private Integer id;

    /**
    * 标题
    */
    private String title;

    /**
    * 背景图片
    */
    private String img;

    /**
    * 内容
    */
    private String content;

    private String createBy;

    private String updateBy;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}