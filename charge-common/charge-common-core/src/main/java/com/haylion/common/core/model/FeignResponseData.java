package com.haylion.common.core.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.haylion.common.core.exception.ApplicationException;
import com.haylion.common.core.exception.SysStubInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 前后通讯数据格式
 *
 * @author shuang
 */
@Data
@NoArgsConstructor
public class FeignResponseData<T> implements Serializable {
    //private static final Long serialVersionUID = 3799998925838568241L;
    private static final long serialVersionUID = 1L;
    public static final Integer SUCCESS_CODE = 200;
    public static final Integer IOT_SUCCESS_CODE = 0;
    public static final Integer FAIL_CODE = 500;


    private Integer code;
    /**
     * 消息提示
     * 默认操作成功
     */
    private String message;
    /**
     * 当前服务器时间
     * 格式yyyy-MM-dd HH:mm:ss
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time = new Date();
    /**
     * 业务数据
     */
    private T data;

    public FeignResponseData(SysStubInfo sysStubInfo, String msg, T emptyData) {
        this.data = emptyData;
        this.code = sysStubInfo.getCode();
        this.message = msg;
    }

    public FeignResponseData(SysStubInfo sysStubInfo, T emptyData) {
        this.data = emptyData;
        this.code = sysStubInfo.getCode();
        this.message = sysStubInfo.getMsg();
    }


    /**
     * 构造操作成功数据包
     *
     * @param data
     * @return
     */
    public static FeignResponseData success(Object data) {
        FeignResponseData feignResponseData = new FeignResponseData();
        feignResponseData.setData(data);
        feignResponseData.setCode(SUCCESS_CODE);
        feignResponseData.setMessage("操作成功");
        return feignResponseData;
    }


    /**
     * 构造操作成功数据包
     *
     * @return
     */
    public static FeignResponseData success() {
        FeignResponseData feignResponseData = new FeignResponseData();
        feignResponseData.setData(null);
        feignResponseData.setCode(SUCCESS_CODE);
        feignResponseData.setMessage("操作成功");
        return feignResponseData;
    }

    public void assertSuccess() {
        if (this.code == null) this.code = FAIL_CODE;
        if (this.message == null) this.message = "操作失败";
        if (!this.code.equals(SUCCESS_CODE)) {
            throw new ApplicationException(SysStubInfo.DEFAULT_FAIL);
        }
    }
}
