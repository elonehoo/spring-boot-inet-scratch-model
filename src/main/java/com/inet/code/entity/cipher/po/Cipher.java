package com.inet.code.entity.cipher.po;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 密码表
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_cipher")
public class Cipher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键序号
     */
    @TableId(value = "id" , type = IdType.UUID)
    private String id;

    /**
     * 用户表主键
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 密码
     */
    @TableField(value = "cipher")
    private String cipher;

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


}
