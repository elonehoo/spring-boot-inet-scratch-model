package com.inet.code.entity.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 登陆的实体类
 * Entity class for logging in
 * @author HCY
 * @since 2021/3/20 下午1:46
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("登陆的实体类")
public class LoginBean {

    /**
     * 账号
     * This is the account number field
     */
    @ApiModelProperty("账号")
    private String account;

    /**
     * 密码
     * This is the password field
     */
    @ApiModelProperty("密码")
    private String cipher;
}
