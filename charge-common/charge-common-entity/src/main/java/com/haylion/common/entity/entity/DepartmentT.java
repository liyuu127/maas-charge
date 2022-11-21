package com.haylion.common.entity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author liyu
 * date 2022/4/12 15:59
 * description
 */
@Data
public class DepartmentT implements Serializable {
    /**
     * 部门表ID
     */
    private Integer id;

    /**
     * 公司ID
     */
    private Integer cId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 负责人姓名
     */
    private String resName;

    /**
     * 负责人手机号
     */
    private String resMobile;

    private String color;

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