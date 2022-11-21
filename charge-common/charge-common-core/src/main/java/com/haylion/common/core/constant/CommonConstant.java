package com.haylion.common.core.constant;

/**
 * @author liyu
 * date 2020/8/11 10:43
 * description 通用常量类
 */
public class CommonConstant {

    /**
     * 删除标志 0：未删除
     */
    public static final int DELETED_NO = 0;
    /**
     * 删除标志 1：已删除
     */
    public static final int DELETED_YES = 1;

    /**
     * 启用状态 0：禁用
     */
    public static final int STATUS_OFF = 0;

    /**
     * 启用状态 1：启用
     */
    public static final int STATUS_ON = 1;


    public static final String SEMICOLON_DELIMITER = ";";
    public static final String VERTICAL_LINE_DELIMITER = "|";

    public static final String COMMA_DELIMITER = ",";
    public static final String IS_EQUAL_TO = "=";

    public static final String BCRYPT = "bcrypt";
    public static final String BCRYPT_WAPPER = "{bcrypt}";
    public static final String BCRYPT_REGE = "\\{bcrypt}";

    public static final String TEL_REGEXP = "^1(?:3\\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\\d|9\\d)\\d{8}$";
    public static final String YEAR_MONTH_DAY_FORMAT = "yyyy-MM-dd";

    /**
     * 移动端安装包是否是当前生效版本 0-否 1-是
     */
    public static final int VALID_NO = 0;
    public static final int VALID_YES = 1;
    /**
     * 打印状态(0-未打印,1-已打印）
     */
    public static final Integer PRINTING_STATUS = 0;
    public static final Integer PRINTED_STATUS = 1;
    /**
     * 打印状态(0-未打印,1-已打印）
     */
    public static final String PRINTING_TEXT = "未打印";
    public static final String PRINTED_TEXT = "已打印";

    /**
     * 调度平台车辆位置与本系统位置单位转换系数
     */
    public static double CONVERT_RATIO = 0.05d;
    /**
     * 告警等级(1-高风险,2-低风险)
     */
    public static int HIGH_LEVEL = 1;
    public static int LOW_LEVEL = 2;

    public static final String ITEM_CODE_FILE_TEMPLATE_PATH = "static/files/item_code_template.xlsx";
};
