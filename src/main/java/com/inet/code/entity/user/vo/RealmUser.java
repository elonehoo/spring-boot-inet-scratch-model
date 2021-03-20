package com.inet.code.entity.user.vo;

import lombok.*;

import java.util.Date;

/**
 * 权限时所需要的user实体类
 * @author HCY
 * @since 2021/3/20 上午8:24
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RealmUser {

    /**
     * 用户序号
     */
    private String id;

    /**
     * 账号
     */
    private String account;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 头像地址
     */
    private String headPortrait;

    /**
     * 个人介绍
     */
    private String introduce;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 生日
     */
    private Date birthday;
}
