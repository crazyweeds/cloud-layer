package io.cloud.layer.uitls;

/**
 * 线程工具类.
 * @author RippleChan
 * @date 2019-02-21 22:47
 */
public class ThreadUtils {

    /**
     * 获取 IO 密集型线程池大小.
     * @return
     */
    public Integer getThreadPoolSizeIOIntensive() {
        return Runtime.getRuntime().availableProcessors() * 2 + 1;
    }

    /**
     * 获取 CPU 密集型线程池大小.
     * @return
     */
    public Integer getThreadPoolSizeCPUIntensive() {
        return Runtime.getRuntime().availableProcessors() + 1;
    }

}
