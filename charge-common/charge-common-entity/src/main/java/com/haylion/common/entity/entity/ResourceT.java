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
public class ResourceT implements Serializable {
    private Integer id;

    /**
    * 权限名
    */
    private String name;

    /**
    * 父级ID
    */
    private Integer pId;

    /**
    * 类型0菜单1子菜单2tab3功能
    */
    private Integer type;

    /**
    * 权限组
    */
    private String group;

    /**
    * 权限编码
    */
    private String code;

    /**
    * 方法
    */
    private String method;

    /**
    * 路径
    */
    private String path;

    /**
    * 备注
    */
    private String note;

    /**
    * 是否可用0可用1不可用
    */
    private Integer status;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}