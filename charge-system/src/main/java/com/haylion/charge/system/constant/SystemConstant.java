package com.haylion.charge.system.constant;

/**
 * @author liyu
 * date 2022/4/15 16:39
 * description
 */
public class SystemConstant {

    /**
     * 短信类型 0身份认证，1登录，2注册，3密码修改
     */
    public final static int SMS_TYPE_USER_IDENTITY = 0;
    public final static int SMS_TYPE_LOGIN = 1;
    public final static int SMS_TYPE_REGISTER = 2;
    public final static int SMS_TYPE_UPDATE_PASSWORD = 3;

    public final static int SMS_VERIFY_CODE_LENGTH = 6;


    public final static int TERMINAL_TYPE_USER = 0;
    public final static int TERMINAL_TYPE_MAINTENANCE = 1;


}
