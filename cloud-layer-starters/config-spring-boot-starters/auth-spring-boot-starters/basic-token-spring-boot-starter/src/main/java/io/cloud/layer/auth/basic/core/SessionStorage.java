package io.cloud.layer.auth.basic.core;

/**
 * 默认实现了容器内部存储、Redis存储，同时也支持用户自己实现存储方式
 * @author RippleChan
 * @date 2019-03-01 22:53
 */
public interface SessionStorage {

    void storage(SessionUser user);

    SessionUser getUser(String key);

}
