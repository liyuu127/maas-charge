package com.haylion.common.entity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liyu
 * date 2022/11/25 17:54
 * description
 */
@Data
@Accessors(chain = true)
public class ChargeMerchant implements Serializable {
    private Integer id;

    /**
     * 运营商编号
     */
    private String code;

    /**
     * 运营商名
     */
    private String name;

    /**
     * 运营商类型
     */
    private Integer type;

    private String mobile;

    /**
     * 法人代表
     */
    private String legalRepresentative;

    /**
     * 营业执照号
     */
    private String businessLicenceNumber;

    /**
     * 银行
     */
    private String bankName;

    /**
     * 银行账号名
     */
    private String bankAccount;

    /**
     * 银行账号
     */
    private String bankAccountNumber;

    private String remark;

    private LocalDateTime createTime;

    private String createUser;

    private LocalDateTime updateTime;

    private String updateUser;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}