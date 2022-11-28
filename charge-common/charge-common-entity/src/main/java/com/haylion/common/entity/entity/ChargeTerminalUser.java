package com.haylion.common.entity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liyu
 * date 2022/11/25 14:20
 * description
 */
@Data
@Accessors(chain = true)
public class ChargeTerminalUser implements Serializable {
    public static final String COL_USER_ID = "user_id";
    public static final String COL_APPLY_TIME = "apply_time";
    public static final String COL_APPLY_CHANNEL = "apply_channel";
    public static final String COL_STATUS = "status";
    public static final String COL_DELETED = "deleted";
    private Integer id;

    private Integer userId;

    private LocalDateTime applyTime;

    /**
     * 申请渠道：{1:安卓app,2:IOSAPP,3:微信小程序,4:支付宝小程序}
     */
    private Integer applyChannel;

    /**
     * 账户状态：{1:正常，2:欠费}
     */
    private Integer status;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}