package com.haylion.common.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author liyu
 * date 2022/4/19 16:02
 * description
 */
public class ExceptionUtil {
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }
}
