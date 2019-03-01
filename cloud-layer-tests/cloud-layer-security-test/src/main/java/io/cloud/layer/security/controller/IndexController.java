package io.cloud.layer.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RippleChan
 * @date 2019-03-01 01:25
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/ueoa",method = RequestMethod.GET)
    public String index() {
        return "ok";
    }

}
