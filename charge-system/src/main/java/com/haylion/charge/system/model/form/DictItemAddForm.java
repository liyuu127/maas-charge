package com.haylion.charge.system.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2022/4/18 9:53
 */
@Data
public class DictItemAddForm {
    @NotNull(message = "name can not be null")
    private String name;
    private Integer parentId;
}
