package com.haylion.charge.user.pojo.form;

import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liyu
 * date 2022/4/12 15:59
 * description
 */
@Data
public class CompanyForm {
    /**
     * 单位表ID
     */
    @NotNull(message = "id can not be null", groups = {Update.class, Delete.class})
    private Integer id;

    /**
     * 单位名称
     */
    @NotBlank(message = "name can not be null", groups = {Add.class})
    private String name;

    /**
     * 单位类型: 1:作业单位、2:监理单位、3:业主单位
     */
    @NotNull(message = "type can not be null", groups = {Add.class})
    private Integer type;

    private String icon;

    private String color;

    /**
     * 描述
     */
    private String description;

    /**
     * 责任人名称
     */
    private String resName;

    /**
     * 责任人联系方式
     */
    private String resMobile;

    @NotBlank(message = "supplierCode can not be null", groups = {Add.class})
    private String supplierCode;

    /**
     * 是否内部单位
     */
    private Integer innerCompany;

    /**
     * 地址
     */
    private String address;

}