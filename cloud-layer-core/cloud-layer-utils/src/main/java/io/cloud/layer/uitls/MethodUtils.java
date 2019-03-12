package io.cloud.layer.uitls;

/**
 * @author RippleChan
 * @date 2019-03-08 18:02
 */
public class MethodUtils {

    private static final String NORMAL_FIELD_GET_METHOD_PREFIX = "get";
    private static final String BOOLEAN_FIELD_GET_METHOD_PREFIX = "is";

    /**
     * 获取方法名
     * @param fieldName
     * @param isBoolean
     * @return
     */
    public static String getGetMethodName(String fieldName, boolean isBoolean) {
        StringBuilder get = new StringBuilder();
        if (isBoolean) {
            get.append(BOOLEAN_FIELD_GET_METHOD_PREFIX);
        } else {
            get.append(NORMAL_FIELD_GET_METHOD_PREFIX);
        }
        String first = fieldName.substring(0, 1).toUpperCase();
        String last = fieldName.substring(1);
        StringBuilder append = get.append(first).append(last);
        return append.toString();
    }

}
