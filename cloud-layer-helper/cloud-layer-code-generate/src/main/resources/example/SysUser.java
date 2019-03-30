package io.cloud.layer.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 表注释
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name="sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 29103855351396352L;

    /**
     * 这是Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Mysql")
    @NotNull
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 创建时间
     */
    private Date createTime;


}
