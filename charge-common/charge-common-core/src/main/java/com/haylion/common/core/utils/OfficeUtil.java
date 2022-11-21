package com.haylion.common.core.utils;

import com.deepoove.poi.XWPFTemplate;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Map;


/**
 * @author LaiXiaoPeng
 * @version 1.0
 * @date 2021/8/3 15:57
 */
@Slf4j
public class OfficeUtil {

    public static boolean wordGenerate(String templatePath, String docOutPutPath, Map<String, Object> data) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(docOutPutPath);
            XWPFTemplate.compile(OfficeUtil.class.getResourceAsStream(templatePath)).render(data, out);
            out.flush();
            return true;
        } catch (Exception e) {
            log.error("word generate failure:{}", e.getMessage());
            return false;
        } finally {
            if (out == null) return false;
            try {
                out.close();
            } catch (Exception e) {
                log.error("word generate failure:{}", e.getMessage());
                return false;
            }
        }
    }
}
