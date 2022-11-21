package com.haylion.common.core.constant;

/**
 * @Description 安全常用类
 */
public class SecurityConstant {


    public static final String OAUTH_TOKEN_URL = "/oauth/token";
    public static final String MOBILE_LOGIN_URL = "/mobile/login";

    public static final String PHONE_KEY = "mobile";
    public static final String CODE_KEY = "code";
    /**
     * 邮箱
     */
    public static final String RESET_MAIL = "MAIL";
    /**
     * 图形验证码
     */
    public static final String PREX_IMAGE_KEY = "PREX_IMAGE_KEY";
    /**
     * 短信验证码
     */
    public static final String SMS_KEY = "SMS_CODE_";
    /**
     * sys_oauth_client_details 表的字段 {scrypt}
     */
    public static final String CLIENT_FIELDS = "client_id, CONCAT('{noop}',client_secret) as client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    /**
     * JdbcClientDetailsService 查询语句
     */
    public static final String BASE_FIND = "select " + CLIENT_FIELDS + " from sys_oauth_client_details";

    /**
     * 默认的查询语句
     */
    public static final String DEFAULT_FIND = BASE_FIND + " order by client_id";

    /**
     * 按条件client_id 查询
     */
    public static final String DEFAULT_SELECT = BASE_FIND + " where client_id = ?";


    public static final String LOGIN_QQ = "qq";
    public static final String LOGIN_WEIXIN = "weixin";
    public static final String LOGIN_GITEE = "gitee";
    public static final String LOGIN_GITHUB = "github";

    /**
     * 用户帐号状态 0待审核，1正常，2冻结
     */
    public static final int USER_STATE_PENDING_AUDIT = 0;
    public static final int USER_STATE_NORMAL = 1;
    public static final int USER_STATE_FREEZE = 2;

    /**
     * 登录权限 app,web
     */
    public static final int USER_LOGIN_PERMISSION_APP = 0x01 << 1;
    public static final int USER_LOGIN_PERMISSION_WEB = 0x01 << 2;
}
