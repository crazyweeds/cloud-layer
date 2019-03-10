package io.cloud.layer.code.core;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author RippleChan
 * @date 2019-03-10 23:16
 */
@Data
@ToString
public class TableInfo implements Serializable {

    private static final long serialVersionUID = 2278052531938627336L;

    private String tableName;
    private String tableComment;

}
