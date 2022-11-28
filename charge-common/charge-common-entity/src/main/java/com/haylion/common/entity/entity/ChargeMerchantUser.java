package com.haylion.common.entity.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author liyu
 * date 2022/11/25 14:20
 * description
 */
@Data
public class ChargeMerchantUser implements Serializable {
    public static final String COL_USER_ID = "user_id";
    public static final String COL_MERCHANT_ID = "merchant_id";
    public static final String COL_DELETED = "deleted";
    private Integer id;

    private Integer userId;

    private Integer merchantId;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}