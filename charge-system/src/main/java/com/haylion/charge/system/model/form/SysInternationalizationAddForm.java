package com.haylion.charge.system.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/5/5 16:48
 */
@Data
public class SysInternationalizationAddForm {
    @NotNull(message = "code can not be null")
    private String code;

    @NotNull(message = "value can not be null")
    private String value;
}
