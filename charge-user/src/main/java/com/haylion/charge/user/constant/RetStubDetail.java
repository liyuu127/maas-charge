package com.haylion.charge.user.constant;


import com.haylion.common.core.exception.RetStub;


public enum RetStubDetail implements RetStub {

    NAME_EXIST_ERROR(100_001, "name_already_exist"),
    ROLE_NAME_OR_CODE_EXIST(100_002, "role_name_or_code_already_exist"),
    OLD_PASSWORD_ERROR(100_003, "old_password_error"),
    CODE_ERROR_OR_INVALID(100_004, "code_error_or_invalid"),
    COMPANY_NAME_EXIST_ERROR(100_010, "company_name_already_exist"),
    DEPARTMENT_NAME_EXIST_ERROR(100_011, "department_name_already_exist"),
    POSITION_NAME_EXIST_ERROR(100_012, "position_name_already_exist"),
    POSITION_ON_DEPARTMENT_NOT_NULL(100_013, "department_with_company_not_null"),
    DEPARTMENT_ON_COMPANY_NOT_NULL(100_014, "position_with_department_not_null"),
    POSITION_ON_USER_NOT_NULL(100_015, "user_with_position_not_null"),
    USERNAME_EXIST(100_016, "username_already_exist"),
    TEL_EXIST(100_017, "tel_already_exist"),
    USER_NOUT_FOUND(100_018, "user_not_found"),
    COLOR_NAME_REPEAT(100_019, "color_name_repeat"),
    COMPANY_CODE_EXIST_ERROR(100_020, "company_supply_code_already_exist"),

    ;
    private static final String MODEL = "user";

    private int code;
    private String msg;

    RetStubDetail(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return MODEL_PREFIX + "." + MODEL + "." + this.msg;
    }

    public RetStubDetail setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
