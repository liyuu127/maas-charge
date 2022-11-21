package com.haylion.common.entity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author liyu
 * date 2022/4/12 15:59
 * description
 */
@Data
public class CompanyT implements Serializable {
    /**
     * 单位表ID
     */
    private Integer id;

    /**
     * 单位名称
     */
    private String name;

    /**
     * 单位类型: 1:作业单位、2:监理单位、3:业主单位
     */
    private Integer type;

    private String icon;

    private String color;

    /**
     * 描述
     */
    private String description;

    /**
     * 责任人名称
     */
    private String resName;

    /**
     * 责任人联系方式
     */
    private String resMobile;

    /**
     * 是否内部单位
     */
    private Integer innerCompany;

    /**
     * 地址
     */
    private String address;
    /**
     * 供应商code
     */
    private String supplierCode;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}