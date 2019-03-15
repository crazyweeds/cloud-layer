package io.cloud.layer.code.utils;

/**
 * @author RippleChan
 * @date 2019-03-10 19:06
 */
public class CamelUtils {


    public static String formatClassName(String prefix, String normalText, String suffix,String splitStr) {
        String[] split = normalText.split(splitStr);
        StringBuffer stringBuffer = new StringBuffer(prefix);
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String start = s.substring(0,1).toUpperCase();
            String end = s.substring(1);
            stringBuffer.append(start).append(end);
        }
        return stringBuffer.append(suffix).toString().replace(splitStr, "");
    }

    public static String formatFieldName(String prefix, String normalText, String suffix,String splitStr) {
        String s = formatClassName(prefix, normalText, suffix, splitStr);
        String first = s.substring(0, 1).toLowerCase();
        if (s.length() != 1) {
            String last = s.substring(1);
            first = first + last;
        }
        return first;
    }

}
