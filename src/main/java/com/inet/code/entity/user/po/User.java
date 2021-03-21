package com.inet.code.entity.user.po;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键序号
     */
    @TableId(value = "id" , type = IdType.UUID)
    private String id;

    /**
     * sm4加密，原密码不可以超过15
     */
    @TableField(value = "account")
    private String account;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 头像的URL地址
     */
    @TableField("head_portrait")
    private String headPortrait;

    /**
     * 个人介绍
     */
    @TableField("introduce")
    private String introduce;

    /**
     * 性别
     */
    @TableField("gender")
    private Boolean gender;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("birthday")
    private Date birthday;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtModified;

    public User(String account, String userName, String headPortrait) {
        this.account = account;
        this.userName = userName;
        this.headPortrait = headPortrait;
    }
}
