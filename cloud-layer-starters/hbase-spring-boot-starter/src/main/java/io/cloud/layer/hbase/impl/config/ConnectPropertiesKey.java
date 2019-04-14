package io.cloud.layer.hbase.impl.config;

import lombok.AllArgsConstructor;
import org.apache.hadoop.hbase.client.HBaseAdmin;

/**
 * 这里列出了部分Hbase Config支持的key，暂时没有使用,但可以作为配置 {@link HbaseProperties.PropertiesConfig} 的依据
 * 这里只是一部分，更多参数请参照：/org/apache/hbase/hbase-common/2.0.1/hbase-common-2.0.1.jar!/hbase-default.xml
 *
 * @author RippleChan
 * @date 2019-04-14 16:27
 */
@SuppressWarnings("ALL")
@AllArgsConstructor
public enum ConnectPropertiesKey {

    /**
     * @see HBaseAdmin#syncWaitTimeout
     */
    HBASE_CLIENT_SYNC_WAIT_TIMEOUT_MSEC("hbase.client.sync.wait.timeout.msec", 10 * 60000),

    /**
     * 如果是多个，可以使用逗号隔开，比如：host1:2181,host2:2181
     */
    HBASE_ZOOKEEPER_QUORUM("hbase.zookeeper.quorum", "localhost:2181"),

    /**
     * ZooKeeper zoo.cfg的属性。客户端将连接的端口
     */
    HBASE_ZOOKEEPER_PROPERTY_CLIENTPORT("hbase.zookeeper.property.clientPort", 2181),

    /**
     * scanner超时时间，单位：ms
     */
    HBASE_CLIENT_SCANNER_TIMEOUT_PERIOD("hbase.client.scanner.timeout.period", 60000),

    /**
     * 操作超时时间
     */
    HBASE_CLIENT_OPERATION_TIMEOUT("hbase.client.operation.timeout", 60000),

    /**
     * Hbase超级用户
     */
    HBASE_SUPERUSER("hbase.superuser", ""),

    /**
     * 是否开启协处理
     */
    HBASE_COPROCESSOR_ENABLED("hbase.coprocessor.enabled",true),

    /**
     * 客户端Scanner结果集的最大条目数
     */
    HBASE_CLIENT_SCANNER_MAX_RESULT_SIZE("hbase.client.scanner.max.result.size",2097152),

    /**
     * 服务端scanner操作结果集最大条目数
     */
    HBASE_SERVER_SCANNER_MAX_RESULT_SIZE("hbase.server.scanner.max.result.size",104857600),

    /**
     * 动态jar目录，已经加载的jar不会卸载
     */
    HBASE_DYNAMIC_JARS_DIR("hbase.dynamic.jars.dir",""),

    /**
     * Hbase Master绑定的端口
     */
    HBASE_MASTER_PORT("hbase.master.port",16000);


    private String key;
    private Object value;

}
