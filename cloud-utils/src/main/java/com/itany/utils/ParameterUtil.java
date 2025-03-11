package com.itany.utils;

import com.itany.constant.DictConstant;

import java.util.Arrays;
import java.util.Objects;

public class ParameterUtil {
    /**
     * 验证非空或纯空格
     */
    public static boolean isNull(String... params) {
        return Arrays.stream(params).anyMatch(s -> s == null || s.trim().isEmpty());
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

    public static boolean isValidFlag(Integer flag) {
        return Objects.equals(flag, DictConstant.EXAMINE_SUCCESS) || Objects.equals(flag, DictConstant.EXAMINE_FAIL);
    }
}
