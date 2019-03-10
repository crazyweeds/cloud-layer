package io.cloud.layer.code.datamodel;

import io.cloud.layer.code.utils.TextUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
public class Bean extends DataModel implements Serializable {

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
    private List<String> jdkImports = new ArrayList<>();
    /**
     * 其他imports
     */
    private List<String> otherImports = new ArrayList<>();

    /**
     * 类上面的注释
     */
    private List<String> beanComments = new ArrayList<>();

    /**
     * 类注解
     */
    private List<String> classAnnotations = new ArrayList<>();
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

    private Bean() {

    }

    private Bean(String tableName, String packageName, List<String> jdkImports, List<String> otherImports, List<String> beanComments, List<String> classAnnotations, String className, String uid, List<Field> fields) {
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

    public Bean(BeanComment beanComment) {
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
    public static class Field {

        private String name;
        private Boolean isId;
        private String jdbcType;
        private String javaType;
        private Integer length;
        private String comment;
        private List<String> annotations = new ArrayList<>();

        private Field() {

        }

        public Field(String comment, List<String> annotations, String type, String name) {
            this.comment = comment;
            this.annotations = annotations;
            this.name = type + " " + name;
        }

    }

}
