package com.haylion.charge.user.pojo.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @author liyu
 * date 2021/5/14 9:15
 * description
 */
@Data
public class UserPasswordUpdateForm {
    @Range(min = 6, max = 16)
    @NotBlank
    private String password;

    @Range(min = 6, max = 16)
    private String updatedPassword;

}
