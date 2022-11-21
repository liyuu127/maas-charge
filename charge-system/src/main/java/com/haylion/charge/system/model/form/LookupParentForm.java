package com.haylion.charge.system.model.form;

import lombok.Data;

/**
 * @Description
 * @Author hqf
 * @Date 2021/11/1
 */
@Data
public class LookupParentForm {

    private Integer id;

    /** value值 **/
    private String value;

    /** 名称 **/
    private String name;

    /** 描述 **/
    private String description;

    /** 模块名称 **/
    private String appName;

    /** 状态 **/
    private Integer status;
}
