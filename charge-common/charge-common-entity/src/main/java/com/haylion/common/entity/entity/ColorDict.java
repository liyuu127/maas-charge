package com.haylion.common.entity.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @author liyu
 * date 2022/5/18 9:45
 * description
 */
@Data
public class ColorDict implements Serializable {
    private Integer id;

    /**
     * 颜色名称
     */
    private String name;

    /**
     * 颜色RGB值
     */
    private String value;

    private Integer deleted;

    /**
     * 1:职位
     */
    private Integer sourceType;

    private static final long serialVersionUID = 1L;
}