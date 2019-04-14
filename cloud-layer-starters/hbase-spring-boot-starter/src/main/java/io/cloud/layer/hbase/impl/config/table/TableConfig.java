package io.cloud.layer.hbase.impl.config.table;

import io.cloud.layer.hbase.core.tags.HbaseTable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * 基于注解 {@link HbaseTable} 自动创建表
 * @author RippleChan
 * @date 2019-04-14 03:06
 */
@Configuration
public class TableConfig implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
