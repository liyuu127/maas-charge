package com.haylion.charge.system.model.form;

import lombok.Data;

/**
 * @Description
 * @Author hqf
 * @Date 2021/11/1
 */
@Data
public class LookupChildForm {
    private Integer id;

    /** 父级Id **/
    private Integer pid;

    /** value值 **/
    private String value;

    /** 名称 **/
    private String name;

    /** 描述 **/
    private String description;

    /** 内部排序 **/
    private Integer orders;

    /** 状态 **/
    private Integer status;

    /** 属性1 **/
    private String attr1;

    /** 属性2 **/
    private String attr2;

    /** 属性3 **/
    private String attr3;

    /** 属性4 **/
    private String attr4;
}
