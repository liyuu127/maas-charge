package com.haylion.common.entity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author liyu
 *  date 2022/4/14 17:10
 *  description 
 */
@Data
public class SysLog implements Serializable {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 操作IP
    */
    private String requestIp;

    /**
    * 操作类型 1 操作记录2异常记录
    */
    private Integer type;

    /**
    * 操作人
    */
    private String userName;

    /**
    * 操作描述
    */
    private String description;

    /**
    * 请求方法
    */
    private String actionMethod;

    private String actionUrl;

    /**
    * 请求参数
    */
    private String params;

    /**
    * 浏览器
    */
    private String ua;

    /**
    * 类路径
    */
    private String classPath;

    /**
    * 请求方法
    */
    private String requestMethod;

    /**
    * 操作类型
    */
    private Integer operateType;

    /**
    * 开始时间
    */
    private LocalDateTime startTime;

    /**
    * 完成时间
    */
    private LocalDateTime finishTime;

    /**
    * 消耗时间
    */
    private Long consumingTime;

    /**
    * 异常详情信息
    */
    private String exDesc;

    /**
    * 异常描述
    */
    private String exDetail;

    /**
    * 租户id
    */
    private Integer tenantId;

    private static final long serialVersionUID = 1L;
}