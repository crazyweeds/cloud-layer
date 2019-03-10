package io.cloud.layer.code.utils;

import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;

/**
 * @author RippleChan
 * @date 2019-03-10 18:06
 */
public class TextUtils implements Serializable{

    public static String getSerialVersionUID() {
        long l = RandomUtils.nextLong();
        return l + "L";
    }

}
