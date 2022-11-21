package com.haylion.common.notice.constant;


import com.haylion.common.core.exception.RetStub;

/**
 * @author liyu
 * date 2021/1/8 15:33
 * description
 */
public enum RetStubDetail implements RetStub {

    MESSAGE_TYPE_ERROR(110_001, "message type error"),

    ;

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
        return msg;
    }

    public RetStubDetail setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
