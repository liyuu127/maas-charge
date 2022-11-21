package com.haylion.common.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author hqf
 * @Date 2022/9/30
 */
@Data
public class QualityFeedbackDto {

    /**
     * 采购订单id
     */
    private Integer orderId;
    /**
     * 订单物料id
     */
    private Integer orderMaterialId;
    /**
     * 采购单号
     */
    private String purchaseCode;
    /**
     * 物料编码
     */
    private String materialCode;
    /**
     * 物料名称
     */
    private String materialName;
    /**
     * 订单数量
     */
    private Double orderNum;
    /**
     * 反馈数量
     */
    private Double feedbackNum;
    /**
     * 反馈占比
     */
    private Double proportion;

    List<FeedbackInfoDto> qualityList;
}
