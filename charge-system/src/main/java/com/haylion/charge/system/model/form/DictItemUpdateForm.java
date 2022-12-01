package com.haylion.charge.system.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/4/18 14:29
 */
@Data
public class DictItemUpdateForm {
    @NotNull(message = "id can not be null")
    private Integer id;
    @NotNull(message = "name can not be null")
    private String name;
}
