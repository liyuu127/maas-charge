package com.haylion.common.entity.dto;

import com.haylion.common.entity.entity.ColorDict;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2022/4/12 15:59
 * description
 */
@Data
public class PositionDto {
    /**
     * 职位信息表ID
     */
    private Integer id;

    /**
     * 部门id
     */
    private Integer dId;
    private String dName;
    private Integer cId;
    private String cName;

    /**
     * 职位名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    private ColorDict colorDict;


    /**
     * 图标
     */
    private String icon;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;


}