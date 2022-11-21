package com.haylion.charge.system.model.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liyu
 * date 2022/4/14 14:23
 * description
 */
@Data
public class FileDeleteForm {
    @NotBlank(message = "fileUrl can not be null")
    private String fileUrl;
}
