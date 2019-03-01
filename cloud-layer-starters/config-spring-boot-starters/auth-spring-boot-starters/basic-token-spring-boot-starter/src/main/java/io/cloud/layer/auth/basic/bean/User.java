package io.cloud.layer.auth.basic.bean;

import io.cloud.layer.auth.basic.core.SessionUser;

/**
 * 最基础的实现，因为该用户没有资源信息，也没有权限信息
 * 将该对象放入到Session中，表示登录了，至于字段？不需要的，如果需要，自行继承即可
 * @author RippleChan
 * @date 2019-03-01 22:31
 */
public class User implements SessionUser {



}
