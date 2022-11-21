package com.haylion.common.core.constant;

/**
 * @author wuqing
 * date 2020/8/11 10:43
 * description
 */
public class RedisConstant {
    /**
     * 用户验证码user:verificationCode:userId/tel
     */
    public static final String USER_VERIFICATION_CODE_PREFIX = "user:verificationCode:";
    public static final long USER_VERIFICATION_CODE_CACHE_TIME_SECONDS = 5 * 60L;
    public static final long VERIFICATION_CODE_CACHE_TIME_SECONDS = 5 * 60L;

    public static final String CAMERA_LOCATION = "camera:location";

    /**
     * 用户置顶摄像头信息
     */
    public static final String CURRENT_USER_TOP_CAMERA_CACHE_KEY = "user:camera:tops:%s";
    /**
     * tcs远程token
     */
    public static final String TCS_REMOTE_TOKEN_PRF = "remote:token:";
    public static final long TCS_REMOTE_TOKEN_EXPIRE_TIME_HOUR = 23;

    public static final String MAINTENANCE_ORDER_DAY_NUMBER_PREFIX = "maintenanceOrderNumber";
}

