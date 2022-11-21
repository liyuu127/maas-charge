package com.haylion.common.entity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liyu
 *  date 2022/4/7 14:27
 *  description 
 */
@Data
@Accessors(chain = true)
public class SysInternationalization implements Serializable {
    /**
    * id
    */
    private Integer id;

    /**
    * 编码
    */
    private String code;

    /**
    * 值
    */
    private String value;

    /**
    * 状态 0-未启用，1-启用
    */
    private Integer status;

    /**
    * 创建时间
    */
    private LocalDateTime createTime;

    /**
    * 更新时间
    */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}