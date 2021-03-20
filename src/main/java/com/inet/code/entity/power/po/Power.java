package com.inet.code.entity.power.po;

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
 * 权限表
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_power")
public class Power implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键序号
     */
    @TableId(value = "id" , type = IdType.UUID)
    private String id;

    /**
     * 权限的名字
     */
    @TableField(value = "power_name")
    private String powerName;

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
