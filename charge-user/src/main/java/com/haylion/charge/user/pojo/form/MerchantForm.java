package com.haylion.charge.user.pojo.form;

import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2022/4/12 15:59
 * description
 */
@Data
public class MerchantForm {
    /**
     * id
     */
    @NotNull(message = "id can not be null", groups = {Update.class, Delete.class})
    private Integer id;

    /**
     * 运营商编号
     */
    @NotBlank(message = "code can not be null", groups = {Add.class})
    private String code;

    /**
     * 运营商名
     */
    @NotBlank(message = "name can not be null", groups = {Add.class})
    private String name;

    /**
     * 运营商类型
     */
    @NotNull(message = "type can not be null", groups = {Add.class})
    private Integer type;

    @NotBlank(message = "mobile can not be null", groups = {Add.class})
    private String mobile;

    /**
     * 银行
     */
    @NotBlank(message = "bankName can not be null", groups = {Add.class})
    private String bankName;

    /**
     * 银行账号名
     */
    @NotBlank(message = "bankAccount can not be null", groups = {Add.class})
    private String bankAccount;

    /**
     * 银行账号
     */
    @NotBlank(message = "bankAccountNumber can not be null", groups = {Add.class})
    private String bankAccountNumber;

    /**
     * 营业执照号
     */
    @NotBlank(message = "businessLicenceNumber can not be null", groups = {Add.class})
    private String businessLicenceNumber;

    /**
     * 法人代表
     */
    private String legalRepresentative;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    private String remark;
}