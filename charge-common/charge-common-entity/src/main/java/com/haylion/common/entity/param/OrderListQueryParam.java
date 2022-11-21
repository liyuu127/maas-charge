package com.haylion.common.entity.param;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyu
 * date 2022/9/27 15:19
 * description
 */
@Data
@Builder
public class OrderListQueryParam {
    /**
     * 供应商代号
     */
    private String supplierCode;
    /**
     * 供应商
     */
    private String supplierName;
    /**
     * 采购单号
     */
    private String purchaseCode;
    private List<String> purchaseCodeEqList;

    /**
     * 物料编码
     */
    private String materialCode;


    /**
     * 物料名称
     */
    private String materialName;


    /**
     * 状态（0-待签收，1-已签收，2-生产中，3-生产完成，4-发货完成）
     */
    private List<Integer> state;

    /**
     * 下达时间
     */
    private LocalDateTime releaseTimeS;
    private LocalDateTime releaseTimeE;

    /**
     * 要求交期
     */
    private LocalDateTime requiredDeliveryTimeS;
    private LocalDateTime requiredDeliveryTimeE;


    /**
     * 是否延期 0-否，1-是
     */
    private Integer defer;
    /**
     * 是否单品码 0-否，1-是
     */
    private Integer itemCode;

    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 每页的数量
     */
    private Integer pageSize;

}
