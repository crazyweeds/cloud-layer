package io.cloud.layer.uitls.checker;

import io.cloud.layer.uitls.MethodUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author RippleChan
 * @date 2019-03-13 01:08
 */
public class BeanChecker {

    /**
     * 配合 {@link NotBlank} 使用
     * @param bean
     */
    public static void notBlaknChecker(Object bean) {
        if (Objects.isNull(bean)) {
            throw new RuntimeException("are you kidding me?");
        }
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            String name = declaredField.getType().getName();
            if (!StringUtils.equalsIgnoreCase(String.class.getName(), name)) {
                break;
            }
            NotBlank[] notBlanks = declaredField.getAnnotationsByType(NotBlank.class);
            if (!Objects.isNull(notBlanks) && notBlanks.length != 0) {
                NotBlank notBlank = notBlanks[0];
                try {
                    Method declaredMethod = bean.getClass().getDeclaredMethod(MethodUtils.getGetMethodName(declaredField.getName(), false));
                    Object invoke = declaredMethod.invoke(bean);
                    if (Objects.isNull(invoke) || StringUtils.isBlank(invoke.toString())) {
                        throw new RuntimeException(notBlank.value());
                    }
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
