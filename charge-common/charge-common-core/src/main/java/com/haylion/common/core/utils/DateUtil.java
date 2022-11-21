package com.haylion.common.core.utils;


import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @description: 时间转换工具类
 * @author:
 * @create: 2020-06-29 14:10
 **/
@Slf4j
public class DateUtil {
    /**
     * 日期格式yyyy-MM字符串常量
     */
    public static final String MONTH_FORMAT = "yyyy-MM";
    /**
     * 日期格式yyyyMM字符串常量
     */
    public static final String MONTH_FORMAT_SHORT = "yyyyMM";
    /**
     * 日期格式yyyy-MM-dd字符串常量
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_DIT = "yyyy.MM.dd";
    /**
     * 日期格式yyyyMMdd字符串常量
     */
    public static final String DATE_FORMAT_SHORT = "yyyyMMdd";
    /**
     * 日期格式yyyyMMddHHmm字符串常量
     */
    public static final String DATE_FORMAT_LONG = "yyyyMMddHHmm";
    public static final String DATE_FORMAT_MD = "MMdd";
    public static final String DATE_FORMAT_CHN_MD = "M月dd日";
    /**
     * 日期格式yyyy MM dd字符串常量
     */
    public static final String DATE_FORMAT_BANK = "yyyy MM dd";
    /**
     * 日期格式HH:mm:ss字符串常量
     */
    public static final String HOUR_FORMAT = "HH:mm:ss";
    /**
     * 日期格式yyyy-MM-dd HH:mm:ss字符串常量
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期格式yyyy-MM-dd 00:00:00字符串常量
     */
    public static final String DATETIME_FORMAT_ZERO = "yyyy-MM-dd 00:00:00";
    /**
     * 日期格式yyyy-MM-dd HH:mm:ss.SSS字符串常量
     */
    public static final String MILLI3SECOND_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * 日期格式yyyyMMddHHmmss字符串常量
     */
    public static final String yyyyMMddHHmmss_FORMAT = "yyyyMMddHHmmss";
    public static final String yyyyMMddHHmmssSSS_FORMAT = "yyyyMMddHHmmssSSS";

    public static final String YYYYMMDDTHHMMSSZ_FORMAT = "YYYY-MM-dd'T'HH:mm:ss'Z'";
    /**
     * 时分秒分隔符
     */
    public static final String sep = ":";
    /**
     * 年月分隔符
     */
    public static final String dash = "-";
    /**
     * 空白
     */
    public static final String blank = " ";
    /**
     * 日期格式HH:mm字符串常量
     */
    public static final String HOUR_MIN_FORMAT = "HH:mm";


    /**
     * date类型进行格式化输出（返回类型：String）
     *
     * @param date
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * date类型输出为目标格式（返回类型：String）
     *
     * @param date
     * @return
     */
    public static Date formatToDate(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dateStr = formatter.format(date);
        return parse(dateStr, pattern);
    }

    /**
     * 返回yyyy-MM-dd HH:mm:ss格式的日期字符串
     *
     * @param date
     * @return
     */
    public static String dateTimeStr(Date date) {
        return format(date, DATETIME_FORMAT);
    }

    /**
     * 返回yyyy-MM-dd HH:mm:ss格式的当前日期字符串
     *
     * @return
     */
    public static String currDateTimeStr() {
        return format(new Date(), DATETIME_FORMAT);
    }

    /**
     * 返回yyyy-MM-dd 格式的日期字符串
     *
     * @param date
     * @return
     */
    public static String dateStr(Date date) {
        return format(date, DATE_FORMAT);
    }

    /**
     * 将"yyyy-MM-dd HH:mm:ss"型字符串转化为Date
     *
     * @param str
     * @return
     */
    public static Date parse(String str, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = formatter.parse(str);
        } catch (ParseException e) {
            log.error("date format error:{}",e.getMessage());
        }
        return date;
    }

    /**
     * 将字符串转化为目标类型字符串
     *
     * @param str
     * @return
     */
    public static String parseToString(String str, String pattern, String tarPattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = formatter.parse(str);
        } catch (ParseException e) {
            //log.error("日期转换异常：" + e);
        }
        return format(date, tarPattern);
    }

    /**
     * 日期加减天数
     *
     * @param date
     * @param num
     * @return
     */
    public static Date addDate(Date date, int num) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //把日期往后增加一天.整数往后推,负数往前移动
        calendar.add(Calendar.DATE, num);
        //这个时间就是日期往后推一天的结果
        return calendar.getTime();
    }

    /**
     * 日期加减月份
     *
     * @param date
     * @param num
     * @return
     */
    public static Date addMonths(Date date, int num) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //把日期往后增加n个月.整数往后推,负数往前移动
        calendar.add(Calendar.MONTH, num);
        //这个时间就是日期往后推n个月的结果
        return calendar.getTime();
    }

    /**
     * 日期加减周数
     *
     * @param date
     * @param num
     * @return
     */
    public static Date addWeeks(Date date, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, num);
        return calendar.getTime();
    }

    /**
     * 日期加减年份
     *
     * @param date
     * @param num
     * @return
     */
    public static Date addYears(Date date, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, num);
        return calendar.getTime();
    }

    /**
     * 判断是否在该时间段内
     *
     * @return
     */
    public static boolean dateIsBetween(Date start, Date end, Date target) {
        if (target.getTime() > start.getTime() && target.getTime() < end.getTime()) {
            return true;
        }
        return false;
    }

    /**
     * 获取日期属于周几
     *
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int i = cal.get(Calendar.DAY_OF_WEEK);
        return i == 1 ? 7 : i - 1;
    }

    public static String getWeek(Date date) {
        String[] weeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    public static String getDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    }


    /**
     * 获取小时数
     */
    public static float getHourNum() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        float hour = cal.get(Calendar.HOUR_OF_DAY);
        float min = cal.get(Calendar.MINUTE);
        return hour + min / 60;
    }

    public static long getInterval(Date before, Date after) {
        long diff = after.getTime() - before.getTime();
        Long days = diff / (1000 * 60 * 60 * 24);
        return days;
    }

}
