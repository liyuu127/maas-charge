package com.haylion.common.entity.vo;

import com.haylion.common.entity.entity.UserT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserPermissionVo {

    /**
     * 用户基本信息
     */
    private UserT userT;

    /**
     * 用户权限
     */
    Set<String> permissions;
    /**
     * 角色
     */
    Set<String> roles;

    private String supplierCode;
}
