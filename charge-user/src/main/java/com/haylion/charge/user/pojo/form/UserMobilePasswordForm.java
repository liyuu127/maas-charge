package com.haylion.charge.user.pojo.form;

import com.haylion.charge.user.pojo.vail.MobilePasswordReset;
import com.haylion.charge.user.pojo.vail.MobileUpdate;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2021/5/25 10:09
 */
@Data
@Accessors(chain = true)
public class UserMobilePasswordForm {
    @NotBlank(message = "mobile can not be null or empty", groups = {MobilePasswordReset.class, MobileUpdate.class})
    private String mobile;
    @NotBlank(message = "code can not be null or empty", groups = {MobilePasswordReset.class, MobileUpdate.class})
    private String code;
    @NotNull(message = "password can not be null", groups = {MobilePasswordReset.class})
    private String password;
}
