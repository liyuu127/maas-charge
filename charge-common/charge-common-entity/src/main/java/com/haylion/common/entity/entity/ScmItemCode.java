package com.haylion.common.entity.entity;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author  LaiXiaoPeng
 * @date  2022/9/30 11:41
 * @version 1.0
 */
/**
    * 单品码表
    */
@Data
@Accessors(chain = true)
public class ScmItemCode {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 订单物料id
    */
    private Integer orderMaterialId;

    /**
    * 采购单品码
    */
    private String purchaseItemCode;

    /**
    * 序号
    */
    private Integer serialNo;

    /**
    * 打印状态 0-未打印，1-已打印
    */
    private Integer printStatus;

    /**
    * 生产单品码规则id
    */
    private Integer ruleId;

    /**
    * 打印时间
    */
    private LocalDateTime printTime;

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
}