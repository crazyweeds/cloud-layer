package io.cloud.layer.hbase.impl.factories;

import io.cloud.layer.hbase.core.model.HbaseTable;
import io.cloud.layer.hbase.impl.exceptions.IllegalTableFamiliesException;
import io.cloud.layer.hbase.impl.exceptions.IllegalTableNameException;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;

import java.util.Objects;

/**
 * @author RippleChan
 * @date 2019-04-14 21:16
 */
public class TableFactories {

    /**
     * 快速构建  {@link TableDescriptor} 对象
     *
     * @param hbaseTable
     * @return
     */
    public static TableDescriptor buildTableDescriptor(HbaseTable hbaseTable) {
        if (StringUtils.isBlank(hbaseTable.getTableName())) {
            throw new IllegalTableNameException("表名不能为空");
        }
        if (Objects.isNull(hbaseTable.getTableFamilies()) || hbaseTable.getTableFamilies().isEmpty()) {
            throw new IllegalTableFamiliesException("列族不能为空");
        }
        TableDescriptorBuilder.ModifyableTableDescriptor modifyableTableDescriptor = new TableDescriptorBuilder.ModifyableTableDescriptor(TableName.valueOf(hbaseTable.getTableName()));
        if (!Objects.isNull(hbaseTable.getTableFamilies()) && !hbaseTable.getTableFamilies().isEmpty()) {
            hbaseTable.getTableFamilies().forEach(family -> {
                if (!StringUtils.isBlank(family)) {
                    ColumnFamilyDescriptorBuilder.ModifyableColumnFamilyDescriptor modifyableColumnFamilyDescriptor = new ColumnFamilyDescriptorBuilder.ModifyableColumnFamilyDescriptor(family.getBytes());
                    modifyableTableDescriptor.setColumnFamily(modifyableColumnFamilyDescriptor);
                }
            });
        }
        return modifyableTableDescriptor;
    }

}
