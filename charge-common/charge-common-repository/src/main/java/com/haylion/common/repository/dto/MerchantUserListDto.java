package com.haylion.common.repository.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liyu
 * date 2022/11/28 10:38
 * description
 */
@Data
public class MerchantUserListDto {

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
     * loginPermission
     */
    private Integer loginPermission;


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

    private Integer userType;

    private LocalDateTime lastLoginTime;

    private String merchantName;
    private String roleName;
}
