package io.cloud.layer.hbase.impl.exceptions;

/**
 * @author RippleChan
 * @date 2019-04-14 21:18
 */
public class IllegalTableNameException extends RuntimeException {

    private static final long serialVersionUID = 7567430200828654890L;

    public IllegalTableNameException(String message) {
        super(message);
    }

}
