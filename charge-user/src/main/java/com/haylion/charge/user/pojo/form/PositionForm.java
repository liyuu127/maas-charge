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
public class PositionForm {
    /**
     * 职位信息表ID
     */
    @NotNull(groups = {Update.class, Delete.class})
    private Integer id;

    /**
     * 部门id
     */
    @NotNull(groups = {Add.class})
    private Integer dId;

    /**
     * 职位名称
     */
    @NotNull(groups = {Add.class})
    private String name;

    /**
     * 描述
     */
    private String description;

    private Integer colorId;

    /**
     * 图标
     */
    private String icon;

}