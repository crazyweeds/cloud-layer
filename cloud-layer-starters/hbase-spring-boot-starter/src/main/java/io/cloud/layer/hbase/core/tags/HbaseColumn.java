package io.cloud.layer.hbase.core.tags;

import org.apache.hadoop.hbase.io.compress.Compression;

import java.lang.annotation.*;

/**
 * 基于注解创建表
 * @author RippleChan
 * @date 2019-04-14 21:57
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HbaseColumn {

    /**
     * 需要和 {@link HbaseTable#families()} 对应
     * @return
     */
    String familyName() default "default";

    /**
     * 压缩方式
     * @return
     */
    Compression.Algorithm compression() default Compression.Algorithm.NONE;


}
