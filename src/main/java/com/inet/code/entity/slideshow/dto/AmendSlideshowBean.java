package com.inet.code.entity.slideshow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 添加轮播图的实体类
 * @author HCY
 * @since 2021/3/27 上午11:29
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("添加轮播图的实体类")
public class AmendSlideshowBean {

    /**
     * 轮播图的URL
     */
    @ApiModelProperty("轮播图的URL")
    private String slideshowUrl;
}
