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
public class ScmOrderMaterialOperation implements Serializable {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 订单物料表id
    */
    private Integer orderMaterialId;

    /**
    * 操作类型（0-订单下达，1-订单签收，2-启动生产，3-生产完成，4-发货完成）
    */
    private Integer operationType;

    /**
    * 描述
    */
    private String description;

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