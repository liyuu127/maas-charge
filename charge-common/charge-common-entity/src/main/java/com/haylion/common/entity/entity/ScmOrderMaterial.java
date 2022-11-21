package com.haylion.common.entity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liyu
 * date 2022/9/27 14:38
 * description
 */
@Data
@Accessors(chain = true)
public class ScmOrderMaterial implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 物料编码
     */
    private String materialCode;

    /**
     * 物料名称
     */
    private String materialName;

    /**
     * 物料数量
     */
    private Double materialNum;

    /**
     * 状态（0-待签收，1-已签收，2-生产中，3-生产完成，4-发货完成）
     */
    private Integer state;

    /**
     * 下达时间
     */
    private LocalDateTime releaseTime;

    /**
     * 要求交期
     */
    private LocalDateTime requiredDeliveryTime;

    /**
     * 是否打印单品码（0-否，1-是）
     */
    private Integer printFlag;

    /**
     * 同步更新时间
     */
    private LocalDateTime syncUpdateTime;

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