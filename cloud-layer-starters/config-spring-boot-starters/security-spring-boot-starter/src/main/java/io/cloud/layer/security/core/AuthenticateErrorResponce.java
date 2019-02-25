package io.cloud.layer.security.core;

import io.cloud.layer.security.handle.RedirectSecurityRequestController;

/**
 * REST 接口开发，授权失败后需要返回的类,留给用户自己实现，实现后，请保证注入到 IOC 容器
 * 如果用户不自定义，那么会返回 {@link io/cloud/layer/security/handle/RedirectSecurityRequestController.java:70}
 * 用于 {@link RedirectSecurityRequestController#redirect(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)} 的返回
 * @author RippleChan
 * @date 2019-02-24 19:06
 */
public interface AuthenticateErrorResponce {



}