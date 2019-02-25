package io.cloud.layer.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RippleChan
 * @date 2019-02-24 20:24
 */
@RestController
public class UserController {

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String test() {
        return "test1";
    }

}
