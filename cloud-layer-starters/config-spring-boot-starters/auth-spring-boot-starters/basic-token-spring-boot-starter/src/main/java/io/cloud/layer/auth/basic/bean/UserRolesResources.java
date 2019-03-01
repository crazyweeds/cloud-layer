package io.cloud.layer.auth.basic.bean;

import io.cloud.layer.auth.basic.core.Resources;
import io.cloud.layer.auth.basic.core.Roles;
import io.cloud.layer.auth.basic.core.SessionUser;

/**
 * 带有角色和资源的用户
 * @author RippleChan
 * @date 2019-03-01 23:08
 */
public abstract class UserRolesResources implements SessionUser, Roles, Resources {



}
