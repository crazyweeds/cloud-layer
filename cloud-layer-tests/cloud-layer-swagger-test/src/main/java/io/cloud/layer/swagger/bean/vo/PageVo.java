package io.cloud.layer.swagger.bean.vo;

/**
 * @author RippleChan
 * @date 2019-02-27 00:42
 */
public interface PageVo {

    PageVo setPageSize(Integer pageNo);

    PageVo setPageNo(Integer pageNo);

    Integer getPageSize();

    Integer getPageNo();

}
