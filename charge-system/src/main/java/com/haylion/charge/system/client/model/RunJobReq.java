package com.haylion.charge.system.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liyu
 * date 2022/10/19 17:17
 * description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunJobReq {
    // 任务ID
    @NotNull(message = "jobId can not be null")
    private Integer jobId;
    // 任务标识
    @NotBlank(message = "executorHandler can not be null")
    private String executorHandler;
    // 任务参数
    private String executorParams;
    // 任务阻塞策略，可选值参考 com.xxl.job.core.enums.ExecutorBlockStrategyEnum
    private String executorBlockStrategy;
    // 任务超时时间，单位秒，大于零时生效
    private Integer executorTimeout;
    // 本次调度日志ID
    private Integer logId;
    // 本次调度日志时间
    private Long logDateTime;
    // 任务模式，可选值参考 com.xxl.job.core.glue.GlueTypeEnum
    @NotBlank(message = "glueType can not be null")
    private String glueType;
    // GLUE脚本代码
    private String glueSource;
    // GLUE脚本更新时间，用于判定脚本是否变更以及是否需要刷新
    private Long glueUpdatetime;
    // 分片参数：当前分片
    private Integer broadcastIndex;
    // 分片参数：总分片
    private Integer broadcastTotal;
}
