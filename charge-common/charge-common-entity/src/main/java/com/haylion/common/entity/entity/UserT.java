package com.haylion.common.entity.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2022/4/8 15:04
 * description
 */
@Data
@Accessors(chain = true)
public class UserT implements Serializable {
    /**
     * 员工信息表ID
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证
     */
    private String card;

    /**
     * 二维码
     */
    private String headIconUrl;

    /**
     * 公司ID
     */
    private Integer cId;

    /**
     * 部门ID
     */
    private Integer dId;

    /**
     * 职位ID
     */
    private Integer pId;

    /**
     * loginPermission
     */
    private Integer loginPermission;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 状态
     */
    private Integer state;

    private LocalDateTime createTime;

    private String createBy;

    private LocalDateTime updateTime;

    private String updateBy;

    /**
     * 是否修改密码0：否 1：是
     */
    private Integer passwordModified;

    /**
     * 是否开启短信提醒(0:否,1:是)
     */
    private Integer messageState;

    /**
     * for_rail_car
     */
    private String remark;

    /**
     * 是否删除 0未删除 1 已删除
     */
    private Integer deleted;

    private static final long serialVersionUID = 1L;
}