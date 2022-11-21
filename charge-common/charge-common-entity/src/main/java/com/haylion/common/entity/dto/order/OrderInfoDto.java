package com.haylion.common.entity.dto.order;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2022/9/27 14:52
 * description
 */
@Data
public class OrderInfoDto {

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 主键id
     */
    private Integer orderMaterialId;

    /**
     * 采购单号
     */
    private String purchaseCode;

    private String supplierName;
    private String supplierCode;

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
     * 完成数量
     */
    private Double completedQuantity;

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

}
