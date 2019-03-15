package io.cloud.layer.code.datamodel;

import io.cloud.layer.code.utils.TextUtils;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生成bean所需属性的封装
 * @author RippleChan
 * @date 2019-03-10 15:06
 */
@Accessors(chain = true)
@ToString
@Getter
@Setter
@Builder
public class BeanModel extends DataModel implements Serializable {

    private static final long serialVersionUID = -3991036267848610037L;

    /**
     * 表名
     */
    private String tableName;
    /**
     * 包名
     */
    private String packageName;
    /**
     * jdk相关的imports
     */
    private List<String> jdkImports;
    /**
     * 其他imports
     */
    private List<String> otherImports;

    /**
     * 类上面的注释
     */
    private List<String> beanComments;

    /**
     * 类注解
     */
    private List<String> classAnnotations;
    /**
     * 类名
     */
    private String className;
    /**
     * Serializable id
     */
    private String uid;

    /**
     * fields
     */
    private List<Field> fields = new ArrayList<>();


    public BeanModel() {

    }

    private BeanModel(String tableName, String packageName, List<String> jdkImports, List<String> otherImports, List<String> beanComments, List<String> classAnnotations, String className, String uid, List<Field> fields) {
        this.tableName = tableName;
        this.packageName = packageName;
        this.jdkImports = jdkImports;
        this.otherImports = otherImports;
        this.beanComments = beanComments;
        this.classAnnotations = classAnnotations;
        this.className = className;
        this.uid = uid;
        this.fields = fields;
    }

    public BeanModel(BeanComment beanComment) {
        beanComments.add("* " + beanComment.getComment());
        beanComments.add("* @author " + beanComment.getAuthor());
        beanComments.add("* @date " + beanComment.getDate());
        beanComments.add("* @version " + beanComment.getVersion());
        this.uid = TextUtils.getSerialVersionUID();
    }

    /**
     * bean注释
     */
    @Data
    @ToString
    public static class BeanComment {

        private String comment;
        private String author;
        private String date;
        private String version;

        private BeanComment() {

        }

        public BeanComment(String comment, String author, Date date, String version) {
            this.comment = comment;
            this.author = author;
            this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            this.version = version;
        }

    }

    /**
     * 字段
     */
    @Data
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class Field {

        /**
         * 列名
         */
        private String columnName;
        /**
         * todo
         */
        private String property;
        /**
         * 是否是ID
         */
        private Boolean isId;
        /**
         * JDBC类型
         */
        private String jdbcType;
        /**
         * Java类型
         */
        private String javaType;
        /**
         * 长度
         */
        private Integer length;
        /**
         * 注释
         */
        private String comment;
        /**
         * 注解列表
         */
        private List<String> annotations = new ArrayList<>();


    }

}
