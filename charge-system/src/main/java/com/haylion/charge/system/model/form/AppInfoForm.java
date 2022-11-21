package com.haylion.charge.system.model.form;

import lombok.Data;

/**
 * @author Laixiaopeng
 * @date 2021/02/20 10:45
 * @description
 **/
@Data
public class AppInfoForm {

    private Integer id;

    private Integer appType;

    private Integer versionNumber;

    private String versionName;

    private String forcedUpdatedInstructions;

    private String updatedInstructions;

    private Integer minVersionNumber;

    private String uploadUrl;
}
