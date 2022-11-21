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
public class LookupChildT implements Serializable {
    /**
    * ID
    */
    private Integer id;

    /**
    * 上级ID
    */
    private Integer pid;

    /**
    * value值
    */
    private String value;

    /**
    * 名称
    */
    private String name;

    /**
    * 描述
    */
    private String description;

    /**
    * 内部排序
    */
    private Integer orders;

    /**
    * 状态
    */
    private Integer status;

    /**
    * 属性1
    */
    private String attr1;

    /**
    * 属性2
    */
    private String attr2;

    /**
    * 属性3
    */
    private String attr3;

    /**
    * 属性4
    */
    private String attr4;

    /**
    * 创建者
    */
    private String createBy;

    /**
    * 更新者
    */
    private String updateBy;

    /**
    * 创建日期
    */
    private LocalDateTime createTime;

    /**
    * 更新时间
    */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}