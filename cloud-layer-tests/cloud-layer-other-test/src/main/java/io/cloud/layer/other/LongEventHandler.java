package io.cloud.layer.other;

import com.lmax.disruptor.EventHandler;

import java.util.concurrent.TimeUnit;

/**
 * 消费者
 * @author RippleChan
 * @date 2019-05-20 01:17
 */
public class LongEventHandler implements EventHandler<LongEvent> {


    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println(event.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
