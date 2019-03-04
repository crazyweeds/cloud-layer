package io.cloud.layer.zuul.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author RippleChan
 * @date 2019-03-03 23:30
 */
@Configuration
public class FilterConfig {

    @Bean
    public MyErrorFilter filter() {
        return new MyErrorFilter();
    }

}
