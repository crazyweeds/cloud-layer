package io.cloud.layer.hbase.impl.service;

import io.cloud.layer.hbase.core.api.HbaseServerService;
import io.cloud.layer.hbase.core.enums.WalStatus;
import org.apache.hadoop.hbase.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author RippleChan
 * @date 2019-04-11 21:53
 */
@Service
public class HbaseServerServiceImpl implements HbaseServerService {

    @Autowired
    private Connection connection;

    @Override
    public void wal(WalStatus walStatus) {
    }

}
