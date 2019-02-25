package io.cloud.layer.security.core;

/**
 * 登录方式
 * @author RippleChan
 * @date 2019-02-25 22:40
 */
public enum  LoginTypeEnum {

    /**
     * form 表单形式提交
     */
    FORM,
    /**
     * OpenId登录
     */
    OPENID,

    /**
     * Oauth2登录
     */
    OAUTH2;

}
