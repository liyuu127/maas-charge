package com.haylion.common.oss.util;

import cn.hutool.core.date.DateTime;

/**
 * @author liyu
 * date 2021/6/8 18:47
 * description
 */
public class FileUtils {

    /**
     * 构造存储路径
     *
     * @param sourceFileName
     * @return file/yyyy/MM/dd/timestamp-sourceFileName
     */
    public static String getFilePath(String sourceFileName) {
        DateTime dateTime = new DateTime();
        return "file/" + dateTime.toString("yyyy")
                + "/" + dateTime.toString("MM") + "/"
                + dateTime.toString("dd") + "/" + System.currentTimeMillis() + "-" + sourceFileName;
    }
}
