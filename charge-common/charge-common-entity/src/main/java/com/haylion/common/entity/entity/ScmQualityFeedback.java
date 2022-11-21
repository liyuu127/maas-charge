package com.haylion.common.entity.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScmQualityFeedback {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 订单物料id
     */
    private Integer orderMaterialId;
    /**
     * 单品码
     */
    private String purchaseItemCode;
    /**
     * 品质说明
     */
    private String qualityDescription;
    /**
     * 图片链接
     */
    private String pictureUrl;
    /**
     * 反馈时间
     */
    private LocalDateTime feedbackTime;
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