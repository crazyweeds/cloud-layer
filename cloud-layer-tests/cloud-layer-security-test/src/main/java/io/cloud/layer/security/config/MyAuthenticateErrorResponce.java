package io.cloud.layer.security.config;

import io.cloud.layer.bean.basic.impl.HttpResult;
import io.cloud.layer.security.core.AuthenticateErrorResponce;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author RippleChan
 * @date 2019-02-24 20:32
 */
@Component
public class MyAuthenticateErrorResponce<T> extends HttpResult<T> implements AuthenticateErrorResponce {

    private static final long serialVersionUID = -6538505210546564485L;

    @Override
    public Integer getCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }

    @Override
    public String getMessage() {
        return HttpStatus.UNAUTHORIZED.toString();
    }

}
