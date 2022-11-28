package com.haylion.charge.user.constant;

/**
 * @author liyu
 * date 2022/4/8 11:25
 * description
 */
public class UserConstant {
    /**
     * 默认无角色用户roleId
     */
    public static final int USER_ROLE_NULL = -1;
    /**
     * 是否首次修改密码0：否 1：是
     */
    public static final int PASSWORD_FIRST_MODIFY_FLAG_NO = 0;
    public static final int PASSWORD_FIRST_MODIFY_FLAG_YES = 1;

    /**
     * 申请渠道
     * 1:安卓app
     * 2:IOSAPP
     * 3:微信小程序
     * 4:支付宝小程序
     */
    public static final int APPLY_CHANNEL_ANDROID_APP = 1;
    public static final int APPLY_CHANNEL_IOS_APP = 2;
    public static final int APPLY_CHANNEL_WECHANT_APPLET = 3;
    public static final int APPLY_CHANNEL_ALIPAY_APPLET = 4;

    /**
     * 账户状态：
     * 1:正常
     * 2:欠费
     */
    public static final int ACCOUNT_STATE_NORMAL = 1;
    public static final int ACCOUNT_STATE_ARREARS = 2;

    /**
     * 用户类型
     * 1:终端
     * 2:pc
     */
    public static final int USER_TYPE_MOBILE = 1;
    public static final int USER_TYPE_PC = 2;
}
