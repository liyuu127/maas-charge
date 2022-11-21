package com.haylion.charge.user.pojo.form;

import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author liyu
 * date 2022/4/12 15:59
 * description
 */
@Data
public class DepartmentForm {
    /**
     * 部门表ID
     */
    @NotNull(groups = {Update.class, Delete.class})
    private Integer id;

    /**
     * 公司ID
     */
    @NotNull(groups = {Add.class})
    private Integer cId;

    /**
     * 部门名称
     */
    @NotNull(groups = {Add.class})
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 负责人姓名
     */
    private String resName;

    /**
     * 负责人手机号
     */
    private String resMobile;

    private String color;

    /**
     * 图标
     */
    private String icon;

}