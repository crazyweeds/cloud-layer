package io.cloud.layer.trace.annotations;

import org.springframework.stereotype.Service;

/**
 * @author RippleChan
 * @date 2019-05-26 13:14
 */
@Service
public class TestService {

    @Trace(value = "messageId")
    public void test(String messageId) {
        System.out.println("Test");
    }

}
