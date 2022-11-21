package com.haylion.common.entity.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScmQualityFeedbackFile {

    /**
     * 主键id
     */
    private Integer id;
    /**
     * 质量反馈id
     */
    private Integer qualityFeedbackId;
    /**
     * 文件url
     */
    private String fileUrl;
    /**
     * 文件名称
     */
    private String fileName;

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