package io.cloud.layer.tail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前期测试，starter化后删除
 *
 * @author RippleChan
 * @date 2019-03-07 00:19
 */
@SpringBootApplication
@RequestMapping
public class TailApplication {

    public static void main(String[] args) {
        SpringApplication.run(TailApplication.class, args);
    }

}
