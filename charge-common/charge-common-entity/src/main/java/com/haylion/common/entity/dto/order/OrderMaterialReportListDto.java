package com.haylion.common.entity.dto.order;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2022/9/29 10:21
 * description
 */
@Data
public class OrderMaterialReportListDto {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 订单物料表id
     */
    private Integer orderMaterialId;

    /**
     * 报工数量
     */
    private Double reportingQuantity;

    /**
     * 备注
     */
    private String remark;

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
    
}
