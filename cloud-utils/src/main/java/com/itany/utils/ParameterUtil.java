package com.itany.utils;

public class ParameterUtil {
    /**
     * 验证非空或纯空格
     */
    public static boolean isNull(String s) {
        return null == s || s.trim().isEmpty();
    }

    /**
     *
     */
    public static String escapeString(String s) {
        if (!ParameterUtil.isNull(s)) {
            char[] cs = s.toCharArray();
            StringBuffer buffer = new StringBuffer();
            for (char c : cs) {
                buffer.append("/" + c);
            }
            return buffer.toString();
        }
        return null;
    }
}
