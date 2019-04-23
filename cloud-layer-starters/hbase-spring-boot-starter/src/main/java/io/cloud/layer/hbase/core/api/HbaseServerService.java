package io.cloud.layer.hbase.core.api;

import io.cloud.layer.hbase.core.enums.WalStatus;

/**
 * Hbase server相关的操作
 * @author RippleChan
 * @date 2019-04-11 00:51
 */
public interface HbaseServerService {

    void wal(WalStatus walStatus);

}
