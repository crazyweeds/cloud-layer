package io.cloud.layer.hbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author RippleChan
 * @date 2019-04-11 23:02
 */
@SpringBootApplication
@EnableHbase
public class HbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HbaseApplication.class, args);
    }

}
