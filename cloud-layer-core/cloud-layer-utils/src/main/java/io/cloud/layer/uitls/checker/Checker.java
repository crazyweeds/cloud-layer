package io.cloud.layer.uitls.checker;

/**
 * @author RippleChan
 * @date 2019-03-17 18:13
 */
public interface Checker<T> {

    void throwException(T t);

    CheckerResult getResurt(T t);

}
