package io.cloud.layer.other;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ThreadFactory;

/**
 * 生产者和消费者必须都是异步的
 * @author RippleChan
 * @date 2019-05-20 01:08
 */
public class LongEventMain {

    public static void main(String[] args) {
        LongEventFactory longEventFactory = new LongEventFactory();
        int ringBufferSize = 1024 * 1024;
        /**
         * ProducerType.SINGLE单个生产者
         * ProducerType.MULTI多个生产者
         */
        /**
         * 策略：最推荐Yielding
         */
        Disruptor<LongEvent> longEventDisruptor = new Disruptor<>(longEventFactory, ringBufferSize, new MyThreadFactory(), ProducerType.SINGLE, new YieldingWaitStrategy());
        /**
         * 可以理解为这就是消费者
         */
        longEventDisruptor.handleEventsWith(new LongEventHandler());
        longEventDisruptor.start();
        /**
         * 提交数据,通过ringBuffer实现
         */
        RingBuffer<LongEvent> ringBuffer = longEventDisruptor.getRingBuffer();
        LongEventProducer longEventProducer = new LongEventProducer(ringBuffer);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        for (long i = 0; i < 100; i++) {
            allocate.putLong(0, i);
            String s = longEventProducer.onData(allocate);
        }
        longEventDisruptor.shutdown();
    }

}


class MyThreadFactory implements ThreadFactory {


    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        return thread;
    }

}
