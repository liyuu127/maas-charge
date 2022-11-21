package com.haylion.common.entity.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2022/5/18 9:45
 * description
 */
@Data
public class PositionT implements Serializable {
    /**
     * 职位信息表ID
     */
    private Integer id;

    /**
     * 部门id
     */
    private Integer dId;

    /**
     * 职位名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    private Integer colorId;

    /**
     * 图标
     */
    private String icon;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}