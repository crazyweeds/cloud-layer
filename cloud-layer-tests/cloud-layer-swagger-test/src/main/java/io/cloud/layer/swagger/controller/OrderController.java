package io.cloud.layer.swagger.controller;

import io.cloud.layer.swagger.bean.vo.OrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author RippleChan
 * @date 2019-02-27 00:37
 */
@RestController
@Api(tags = "2.订单")
public class OrderController {

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    @ApiOperation(value = "2.1.创建订单")
    public void add(@RequestBody OrderVo.Create create) {

    }


    @RequestMapping(value = "/order", method = RequestMethod.DELETE)
    @ApiOperation(value = "2.2.删除订单")
    public void delete(@RequestBody OrderVo.Delete delete) {

    }

    @RequestMapping(value = "/order",method = RequestMethod.PUT)
    @ApiOperation(value = "2.3.更新订单")
    public void update(@RequestBody OrderVo.Update update) {

    }

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    @ApiOperation(value = "2.4.获取订单")
    public void search(OrderVo.Search search) {

    }

}
