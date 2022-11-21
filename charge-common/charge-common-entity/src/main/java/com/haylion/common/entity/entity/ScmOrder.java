package com.haylion.common.entity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liyu
 *  date 2022/9/27 14:38
 *  description 
 */
@Data
@Accessors(chain = true)
public class ScmOrder implements Serializable {
    /**
    * id
    */
    private Integer id;

    /**
    * 采购单号
    */
    private String purchaseCode;

    private Integer state;

    /**
    * 供应商代号
    */
    private String supplierCode;

    /**
    * 供应商名称
    */
    private String supplierName;

    /**
    * 来源状态
    */
    private Integer sourceState;

    /**
    * 创建时间
    */
    private LocalDateTime createAt;

    /**
    * 更新时间
    */
    private LocalDateTime updateAt;

    /**
    * 创建者
    */
    private String createBy;

    /**
    * 更新者
    */
    private String updateBy;

    /**
    * 是否删除(0-否，1-是)
    */
    private Integer deleted;

    private static final long serialVersionUID = 1L;
}