package io.cloud.layer.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author RippleChan
 * @date 2019-02-24 20:23
 */
@SpringBootApplication
@EnableSecurity
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}
