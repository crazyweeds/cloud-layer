package io.cloud.layer.other;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author RippleChan
 * @date 2019-05-20 01:22
 */
public class LongEventProducer {

    private RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public String onData(ByteBuffer byteBuffer) {
        long next = ringBuffer.next();
        try {
            LongEvent longEvent = ringBuffer.get(next);
            longEvent.setValue(byteBuffer.getLong(0));
        } finally {
            ringBuffer.publish(next);
        }
        return "Test";
    }

}
