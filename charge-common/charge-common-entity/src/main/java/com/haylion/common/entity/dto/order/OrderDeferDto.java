package com.haylion.common.entity.dto.order;

import lombok.Data;

/**
 * @Description
 * @Author hqf
 * @Date 2022/10/8
 */
@Data
public class OrderDeferDto {
    /**
     * 订单id
     */
    private Integer id;
    /**
     * 订单物料id
     */
    private Integer orderMaterialId;
    /**
     * 采购订单号
     */
    private String purchaseCode;
    /**
     * 供应商代码
     */
    private String supplierCode;
    /**
     * 物料编号
     */
    private String materialCode;
}
