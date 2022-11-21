package com.haylion.common.entity.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author liyu
 *  date 2022/4/7 14:27
 *  description 
 */
@Data
public class RoleResourceT implements Serializable {
    /**
    * 角色权限关联表
    */
    private Integer id;

    /**
    * 角色ID
    */
    private Integer roleId;

    /**
    * 权限ID
    */
    private Integer resourceId;

    private static final long serialVersionUID = 1L;
}