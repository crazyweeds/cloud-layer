package io.cloud.layer.trace.annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RippleChan
 * @date 2019-05-26 13:13
 */
@SpringBootApplication
@RestController
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @Trace(traceId = "test")
    public void trace(String message) {
        System.out.println("test");
    }

}
