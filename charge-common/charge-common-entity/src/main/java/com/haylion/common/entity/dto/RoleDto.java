package com.haylion.common.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2022/4/7 14:27
 * description
 */
@Data
public class RoleDto {
    /**
     * 角色表ID
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 图标
     */
    private String icon;

    /**
     * 颜色
     */
    private String color;

    private LocalDateTime createTime;

    private String createBy;

    private LocalDateTime updateTime;

    private String updateBy;
    /**
     * 权限聚合字符串
     */
    private String resources;

}