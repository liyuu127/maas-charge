package com.haylion.charge.user.pojo.form;

import com.haylion.common.core.validated.Add;
import com.haylion.common.core.validated.Delete;
import com.haylion.common.core.validated.Update;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liyu
 * date 2022/5/18 9:45
 * description
 */
@Data
public class ColorDictForm {
    @NotNull(message = "id can not be null", groups = {Update.class, Delete.class})
    private Integer id;

    /**
     * 颜色名称
     */
    @NotBlank(message = "name can not be null", groups = {Add.class})
    private String name;

    /**
     * 颜色RGB值
     */
    @NotBlank(message = "value can not be null", groups = {Add.class})
    private String value;


    /**
     * 1:职位
     */
    @NotNull(message = "sourceType can not be null", groups = {Add.class})
    private Integer sourceType;

}