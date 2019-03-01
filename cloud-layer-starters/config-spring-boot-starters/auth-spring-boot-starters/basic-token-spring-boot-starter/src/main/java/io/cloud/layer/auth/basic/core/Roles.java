package io.cloud.layer.auth.basic.core;

import java.util.List;

/**
 * 用户拥有的权限
 * @author RippleChan
 * @date 2019-03-01 22:20
 */
public interface Roles {

    List<String> getRole();

}
