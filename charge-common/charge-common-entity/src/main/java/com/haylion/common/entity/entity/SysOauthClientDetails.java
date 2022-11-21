package com.haylion.common.entity.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author liyu
 *  date 2022/4/7 14:27
 *  description 
 */
@Data
public class SysOauthClientDetails implements Serializable {
    /**
    * 客户端Id
    */
    private String clientId;

    private String resourceIds;

    /**
    * 客户端秘钥
    */
    private String clientSecret;

    /**
    * 域
    */
    private String scope;

    private String authorizedGrantTypes;

    private String webServerRedirectUri;

    /**
    * 权限
    */
    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalInformation;

    /**
    * 是否自动放行
    */
    private String autoapprove;

    private static final long serialVersionUID = 1L;
}