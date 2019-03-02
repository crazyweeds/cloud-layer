package io.cloud.layer.auth.basic;

/**
 * 单点登录（非SSO），绑定IP。
 * @author RippleChan
 * @date 2019-03-02 02:22
 */
public @interface EnableSingle {

    /**
     * 禁止新的登录。比如用户Tom已经在A电脑登录，又有人在B电脑登录Tom账号，那么B电脑将被禁止登录；
     *
     * @return
     */
    boolean disable() default true;


    /**
     * 将之前登录的用户踢下线。比如用户Tom已经在A电脑登录，又有人在B电脑登录Tom账号，那么A电脑登录的账号将会被踢下线；
     * @return
     */
    boolean replace() default false;


    /**
     * todo 可能实现
     * 通过WebSocket的形式及时告知用户，有新的用户登录；
     * @return
     */
    boolean alert() default false;

}
