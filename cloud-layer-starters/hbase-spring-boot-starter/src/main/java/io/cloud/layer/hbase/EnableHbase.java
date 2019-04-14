package io.cloud.layer.hbase;

import io.cloud.layer.hbase.impl.service.HbaseServices;

import java.lang.annotation.*;

/**
 * @author RippleChan
 * @date 2019-04-11 21:54
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@HbaseServices
public @interface EnableHbase {



}
