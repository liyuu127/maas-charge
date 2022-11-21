package com.haylion.charge.user.utils;

import com.haylion.common.core.constant.CommonConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liyu
 * date 2022/4/13 10:20
 * description
 */
public class RegexUtil {
    public static boolean isMobileNumber(String regString) {
        Pattern p = Pattern.compile(CommonConstant.TEL_REGEXP);
        Matcher m = p.matcher(regString);
        return m.matches();
    }
}
