package com.haylion.charge.system.constant;


import com.haylion.common.core.exception.RetStub;


public enum RetStubDetail implements RetStub {

    VALUE_ALREADY_EXIST(300_001, "ValueAlreadyExist"),
    CODE_HAS_ALREADY_SEND(300_002, "verify_code_send_repeat"),
    SYS_INTERNATIONALIZATION_CODE_ALREADY_EXIST(300_003, "SysInternationalizationCodeAlreadyExist"),
    RUN_XXJJOB_ERROR(300_004, "run_xxjjob_error"),

    ;

    private int code;
    private String msg;
    private static final String MODEL = "system";

    RetStubDetail(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
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