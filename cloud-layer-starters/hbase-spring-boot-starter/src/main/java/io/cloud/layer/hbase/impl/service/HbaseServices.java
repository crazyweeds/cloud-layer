package io.cloud.layer.hbase.impl.service;

import org.springframework.context.annotation.Import;

/**
 * @author RippleChan
 * @date 2019-04-14 15:52
 */
@Import({HbaseDataServiceImpl.class,HbaseServerServiceImpl.class,HbaseTableServiceImpl.class})
public @interface HbaseServices {
}
