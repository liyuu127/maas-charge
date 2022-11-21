package com.haylion.charge.constant;

/**
 * @author liyu
 * date 2022/10/8 11:02
 * description
 */
public class RedisConstant {

    /**
     * 订单上次同步时间
     */
    public static final String PURCHASE_ORDER_SYNC_TIMESTAMP = "purchase:order:sync:time";
    public static final String PURCHASE_ORDER_SYNC_TIMESTAMP_LOCK = "purchase:order:sync:time:lock";

    public static final String QUALITY_FEEDBACK_SELECT_TIME = "quality:feedback:select:time";
}
