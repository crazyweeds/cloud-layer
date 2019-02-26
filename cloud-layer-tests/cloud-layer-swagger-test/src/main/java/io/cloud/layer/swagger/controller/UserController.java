package io.cloud.layer.swagger.controller;

import io.cloud.layer.swagger.bean.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RippleChan
 * @date 2019-02-27 00:37
 */
@RestController
@Api(tags = "1.用户")
public class UserController {

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ApiOperation(value = "1.1.创建订单")
    public void add(@RequestBody UserVo.Create create) {

    }


    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @ApiOperation(value = "1.2.删除订单")
    public void delete(@RequestBody UserVo.Delete delete) {

    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @ApiOperation(value = "1.3.更新订单")
    public void update(@RequestBody UserVo.Update update) {

    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ApiOperation(value = "1.4.获取订单")
    public void search(UserVo.Search search) {

    }

}
