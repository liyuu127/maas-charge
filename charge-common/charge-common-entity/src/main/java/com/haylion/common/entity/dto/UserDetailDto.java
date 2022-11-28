package com.haylion.common.entity.dto;

import com.haylion.common.entity.entity.ChargeMerchantUser;
import com.haylion.common.entity.entity.ChargeTerminalUser;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liyu
 * date 2022/4/7 14:27
 * description
 */
@Data
@Accessors(chain = true)
public class UserDetailDto {
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
    private String cName;

    /**
     * 部门ID
     */
    private Integer dId;
    private String dName;

    /**
     * 职位ID
     */
    private Integer pId;
    private String pName;

    private Integer roleId;
    private String roleName;
    /**
     * loginPermission
     */
    private Integer loginPermission;
    private Integer state;


    private LocalDateTime createTime;

    private String createBy;

    private LocalDateTime updateTime;

    private String updateBy;

    /**
     * 是否开启短信提醒(0:否,1:是)
     */
    private Integer messageState;
    private Integer passwordModified;

    /**
     * for_rail_car
     */
    private String remark;

    private List<String> permissions;

}