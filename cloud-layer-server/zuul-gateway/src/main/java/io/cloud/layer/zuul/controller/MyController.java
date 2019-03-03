package io.cloud.layer.zuul.controller;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonRoutingFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author RippleChan
 * @date 2019-03-03 18:29
 */
@RestController
public class MyController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test() {
        return "跳转测试";
    }

    @Autowired
    private ZuulProperties zuulProperties;

    /**
     * 获取properties配置文件中的routers配置
     * @return
     */
    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public Map<String, ZuulProperties.ZuulRoute> test1() {
        Map<String, ZuulProperties.ZuulRoute> routes = zuulProperties.getRoutes();
        return routes;
    }

    /**
     * 根据源码得知，该方式虽然能够将值改变，但并不能真正生效，因为太多地方已经配置了第一次初始化的 path
     * @return
     */
    @RequestMapping(value = "/set",method = RequestMethod.GET)
    public Map<String, ZuulProperties.ZuulRoute> set() {
        Map<String, ZuulProperties.ZuulRoute> routes = zuulProperties.getRoutes();
        ZuulProperties.ZuulRoute zuulRoute = routes.get("client-a");
        zuulRoute.setPath("/client1/**");
        return routes;
    }

    /**
     * pre filters
     */
    @Autowired
    private PreDecorationFilter preDecorationFilter;

    /**
     * route filters
     */
    @Autowired
    private RibbonRoutingFilter ribbonRoutingFilter;

    @Autowired
    private ApplicationContext context;


    @RequestMapping(value = "/filters",method = RequestMethod.GET)
    public Map<String, ZuulFilter> testFilters() {
        Map<String, ZuulFilter> beansOfType = context.getBeansOfType(ZuulFilter.class);
        return beansOfType;
    }



}
