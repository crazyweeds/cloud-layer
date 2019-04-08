package io.cloud.layer.auth.basic.core;

/**
 * Session存储类型
 * @author RippleChan
 * @date 2019-03-01 23:47
 */
public enum StorageTypeEnum {

    /**
     * 存放到Redis
     */
    REDIS,
    /**
     * 存放到Web容器内部
     */
    SESSION,
    /**
     * 其他，需要用户自己实现
     */
    OTHER;

}
