package io.cloud.layer.hbase.impl.config.table;

import io.cloud.layer.hbase.impl.tags.Table;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * 用于创建表
 * @author RippleChan
 * @date 2019-04-14 03:06
 */
@Configuration
@EnableConfigurationProperties(TableProperties.class)
public class TableConfig implements BeanPostProcessor {


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Table declaredAnnotation = bean.getClass().getDeclaredAnnotation(Table.class);
        if (!Objects.isNull(declaredAnnotation)) {
            boolean auto = declaredAnnotation.auto();
            String families = declaredAnnotation.families();
            String s = declaredAnnotation.tableName();
        }
        return bean;
    }

}
