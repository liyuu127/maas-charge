package com.haylion.common.entity.dto.order;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/9/30 17:18
 */
@Data
public class ScmItemCodeDto {
    private Integer id;
    private String purchaseItemCode;
    private String purchaseCode;
    private Integer serialNumber;
    private String materialCode;
    private String materialName;
    private Integer printStatus;
    private String createBy;
    private LocalDateTime createAt;
}
