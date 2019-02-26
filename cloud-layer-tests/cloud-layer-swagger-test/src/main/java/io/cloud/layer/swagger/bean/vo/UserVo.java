package io.cloud.layer.swagger.bean.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 随便继承的，没啥套路
 * @author RippleChan
 * @date 2019-02-27 00:39
 */
public class UserVo {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Accessors(chain = true)
    public static class Delete {

        @ApiModelProperty(value = "用户ID")
        private Long id;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public static class Create extends Delete{

        @ApiModelProperty(value = "用户名")
        private String name;

    }

    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public static class Update extends Create {


    }

    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public static class Search extends Create implements PageVo{


        @ApiModelProperty(notes = "页码")
        private Integer pageNo;

        @ApiModelProperty(notes = "每页数量")
        private Integer pageSize;


    }


}
