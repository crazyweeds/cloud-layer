package io.cloud.layer.bean.basic.impl;

import io.cloud.layer.bean.basic.Result;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author RippleChan
 * @date 2019-02-24 20:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ToString
public class HttpResult<T> extends Result {

    private static final long serialVersionUID = -3985537075686370030L;

    private Integer code;
    private String message;
    private T data;

}
