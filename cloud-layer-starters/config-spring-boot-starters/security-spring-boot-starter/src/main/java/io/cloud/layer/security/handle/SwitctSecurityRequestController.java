package io.cloud.layer.security.handle;

import io.cloud.layer.security.core.AuthenticateResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于区分 REST 接口和传统 Web 项目
 * @author RippleChan
 * @date 2019-02-24 19:03
 */
@Controller
public class SwitctSecurityRequestController {

    @Autowired
    private AuthenticateResponce defaultAuthenticateResponce;


    @RequestMapping(value = "${test}")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public AuthenticateResponce switchTo(HttpServletRequest request, HttpServletResponse response) {
        return defaultAuthenticateResponce;
    }

}
