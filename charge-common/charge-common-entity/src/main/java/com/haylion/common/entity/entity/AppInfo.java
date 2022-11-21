package com.haylion.common.entity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liyu
 *  date 2022/4/7 14:27
 *  description 
 */
@Data
@Accessors(chain = true)
public class AppInfo implements Serializable {
    private Integer id;

    /**
    * app标识 [暂不使用]
    */
    private Integer appFlag;

    /**
    * app类型 1-用户端(Android) 2-用户端(IOS) 3-运营端(Android) 4-PC端(Windows)
    */
    private Integer appType;

    /**
    * 版本号
    */
    private Integer versionNumber;

    /**
    * 版本名称
    */
    private String versionName;

    /**
    * 强制更新说明
    */
    private String forcedUpdatedInstructions;

    /**
    * 更新说明
    */
    private String updatedInstructions;

    /**
    * 最低版本
    */
    private Integer minVersionNumber;

    /**
    * 下载地址
    */
    private String uploadUrl;

    /**
    * 创建时间
    */
    private LocalDateTime createdAt;

    /**
    * 上次更新时间
    */
    private LocalDateTime updatedAt;

    /**
    * 是否删除: 0-未删除 1-已删除
    */
    private Integer deleted;

    /**
    * 是否是当前生效版本 0-否 1-是
    */
    private Integer valid;

    private static final long serialVersionUID = 1L;
}