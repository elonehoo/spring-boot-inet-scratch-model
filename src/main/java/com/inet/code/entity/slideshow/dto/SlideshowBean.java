package com.inet.code.entity.slideshow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 轮播图序号的实体类
 * @author HCY
 * @since 2021/3/23 上午9:50
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("轮播图序号的实体类")
public class SlideshowBean {

    /**
     * 轮播图序号
     */
    @ApiModelProperty("轮播图序号")
    private String id;
}
