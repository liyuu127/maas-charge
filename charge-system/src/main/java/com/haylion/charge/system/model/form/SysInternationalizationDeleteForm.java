package com.haylion.charge.system.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/5/5 17:24
 */
@Data
public class SysInternationalizationDeleteForm {
    @NotNull(message = "id can not be null")
    private Integer id;
}

