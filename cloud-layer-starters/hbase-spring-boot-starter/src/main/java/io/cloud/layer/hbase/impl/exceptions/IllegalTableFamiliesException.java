package io.cloud.layer.hbase.impl.exceptions;

/**
 * @author RippleChan
 * @date 2019-04-18 00:17
 */
public class IllegalTableFamiliesException extends RuntimeException {

    private static final long serialVersionUID = -4263494737167352849L;

    public IllegalTableFamiliesException(String message) {
        super(message);
    }
}
