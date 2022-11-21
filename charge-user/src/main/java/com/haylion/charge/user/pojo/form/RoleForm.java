package com.haylion.charge.user.pojo.form;

import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liyu
 * date 2022/4/7 14:27
 * description
 */
@Data
public class RoleForm {
    /**
     * 角色表ID
     */
    @NotNull(message = "id can not be null", groups = {Update.class, Delete.class})
    private Integer id;

    /**
     * 角色名
     */
    @NotBlank(message = "name can not be null", groups = {Add.class})
    private String name;

    /**
     * 角色编码
     */
    @NotBlank(message = "code can not be null", groups = {Add.class})
    private String code;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 图标
     */
    private String icon;

    /**
     * 颜色
     */
    private String color;


    List<Integer> resourceIdList;

}