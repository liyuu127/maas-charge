package com.haylion.common.entity.dto.order;

import lombok.Data;

/**
 * @Description
 * @Author hqf
 * @Date 2022/10/13
 */
@Data
public class OrderMaterialDto {

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 采购订单号
     */
    private String purchaseCode;

    /**
     * 供应商编号
     */
    private String supplierCode;

    /**
     * 订单物料id
     */
    private Integer orderMaterialId;

    /**
     * 物料编码
     */
    private String materialCode;
}
