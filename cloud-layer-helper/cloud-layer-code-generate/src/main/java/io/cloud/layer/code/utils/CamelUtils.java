package io.cloud.layer.code.utils;

/**
 * @author RippleChan
 * @date 2019-03-10 19:06
 */
public class CamelUtils {


    public static String format(String prefix, String normalText, String suffix,String splitStr) {
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

}
