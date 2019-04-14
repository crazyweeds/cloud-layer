package io.cloud.layer.hbase.impl.exceptions;

/**
 * @author RippleChan
 * @date 2019-04-14 17:02
 */
public class HbaseOperationException extends RuntimeException {

    private static final long serialVersionUID = -3467802668643107708L;

    public HbaseOperationException(String message) {
        super(message);
    }

}
