package io.cloud.layer.hbase.core.model;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author RippleChan
 * @date 2019-04-11 00:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@EqualsAndHashCode
@ToString
public class HbaseTable implements Serializable {

    private static final long serialVersionUID = -3774181994366376770L;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 列族：官方并不建议太多个
     */
    private List<String> tableFamilies;

    /**
     * 表属性
     */
    private HbaseTableConfig hbaseTableConfig;

    public static class HbaseTableConfig {


    }

}
