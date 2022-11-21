package com.haylion.common.entity.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author liyu
 * date 2022/4/8 11:49
 * description
 */
@Data
public class UserRoleT implements Serializable {
    /**
     * 用户角色关联表ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}