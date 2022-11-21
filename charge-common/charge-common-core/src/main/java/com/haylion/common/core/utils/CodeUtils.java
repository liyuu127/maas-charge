package com.haylion.common.core.utils;

import java.util.Random;

/**
 * @description: code生成工具类
 * @author:
 * @time: 2020/7/2
 */
public class CodeUtils {


    public static String createIdentifyCode() {
        long lastRandomSeed = 0;
        String identifyCode = "";
        Random myRandom = new Random(System.currentTimeMillis() + lastRandomSeed);
        identifyCode += (myRandom.nextInt() % 10 + 20) % 10;
        identifyCode += (myRandom.nextInt() % 10 + 20) % 10;
        identifyCode += (myRandom.nextInt() % 10 + 20) % 10;
        identifyCode += (myRandom.nextInt() % 10 + 20) % 10;
        return identifyCode;
    }
}
