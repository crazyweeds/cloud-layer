package io.cloud.layer.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * 启动入口
 * @author RippleChan
 * @date 2019-03-07 23:59
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {


    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class);
    }

}
