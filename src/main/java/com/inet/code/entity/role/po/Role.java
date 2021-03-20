package com.inet.code.entity.role.po;

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
 * 角色表
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键序号
     */
    @TableId(value = "id" , type = IdType.UUID)
    private String id;

    /**
     * 角色名字
     */
    @TableField(value = "role_name")
    private String roleName;

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
