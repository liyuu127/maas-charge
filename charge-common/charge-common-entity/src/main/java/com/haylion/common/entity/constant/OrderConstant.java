package com.haylion.common.entity.constant;

/**
 * @author liyu
 * date 2022/9/27 17:47
 * description
 */
public class OrderConstant {

    /**
     * 是否延期 0:否,1:是
     */
    public static final int ORDER_DEFER_NO = 0;
    public static final int ORDER_DEFER_YES = 1;

    /**
     * 订单物料状态
     */
    public static final int ORDER_MATERIAL_STATE_RECEIVE = 0;
    public static final int ORDER_MATERIAL_STATE_SIGN = 1;
    public static final int ORDER_MATERIAL_STATE_PRODUCT_START = 2;
    public static final int ORDER_MATERIAL_STATE_PRODUCT_COMPLETE = 3;
    public static final int ORDER_MATERIAL_STATE_DELIVERY_COMPLETE = 4;

}
