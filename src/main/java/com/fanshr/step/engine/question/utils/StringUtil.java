package com.fanshr.step.engine.question.utils;

import java.util.Locale;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/9/6 09:16
 * @date : Modified at 2021/9/6 09:16
 */
public class StringUtil {


    public static boolean isBlank(String var) {
        return null == var || var.trim().isEmpty();
    }

    public static boolean isNotBlank(String var) {
        return !isBlank(var);
    }

    public static String null2s(String var0) {
        return var0 == null ? "" : var0;
    }

    public static String null2s(String var0, String var1) {
        return var0 != null && !var0.equals("") ? var0 : (var1 == null ? "" : var1);
    }

    public static String toCondition(String str) {
        return str == null ?"":str.replace(" ","").toLowerCase();
    }
}
