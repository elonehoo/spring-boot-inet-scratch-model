package com.inet.code.entity.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 注册的实体类
 * The registered entity class
 * @author HCY
 * @since 2021/3/21 上午10:01
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("注册的实体类")
public class EnrollBean {
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

}
