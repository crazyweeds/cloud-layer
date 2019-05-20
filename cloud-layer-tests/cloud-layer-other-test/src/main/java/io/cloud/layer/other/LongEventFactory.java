package io.cloud.layer.other;

import com.lmax.disruptor.EventFactory;

/**
 * @author RippleChan
 * @date 2019-05-20 01:07
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }

}
