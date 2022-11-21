package com.haylion.common.entity.dto;

import com.haylion.common.entity.entity.ScmQualityFeedbackFile;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class FeedbackInfoDto {
    /**
     * 主键id
     */
    private Integer feedbackId;
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
     * 反馈时间
     */
    private LocalDateTime feedbackTime;

    /**
     * 图片链接集合
     */
    private List<ScmQualityFeedbackFile> pictureUrlList;
}