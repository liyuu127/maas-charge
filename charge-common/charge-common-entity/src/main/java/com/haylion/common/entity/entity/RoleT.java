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
public class RoleT implements Serializable {
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

    private static final long serialVersionUID = 1L;
}