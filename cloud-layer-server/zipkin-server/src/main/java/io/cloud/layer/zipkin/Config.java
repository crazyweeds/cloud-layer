package io.cloud.layer.zipkin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * @author RippleChan
 * @date 2019-03-08 01:41
 */
@Configuration
@AutoConfigureAfter(value = MetricsProperties.class)
public class Config implements BeanPostProcessor {


    /**
     * 不处理，会报错
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().getName().equals(MetricsProperties.class.getName())) {
            MetricsProperties bean1 = (MetricsProperties) bean;
            bean1.getWeb().getServer().setAutoTimeRequests(false);
            return bean1;
        }
        return null;
    }

}
