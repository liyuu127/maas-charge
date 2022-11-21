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
public class ScmOrderMaterialReport implements Serializable {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 订单物料表id
    */
    private Integer orderMaterialId;

    /**
    * 报工数量
    */
    private Double reportingQuantity;

    /**
    * 备注
    */
    private String remark;

    /**
    * 操作人
    */
    private String operator;

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