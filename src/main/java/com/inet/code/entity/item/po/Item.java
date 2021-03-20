package com.inet.code.entity.item.po;

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
 * 项目表
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键序号
     */
    @TableId(value = "id" , type = IdType.UUID)
    private String id;

    /**
     * 用户序号
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 宣传图的URL
     */
    @TableField(value = "propaganda_url")
    private String propagandaUrl;

    /**
     * 项目的名字
     */
    @TableField(value = "item_name")
    private String itemName;

    /**
     * 项目的URL
     */
    @TableField(value = "item_url")
    private String itemUrl;

    /**
     * 项目说明简介
     */
    @TableField(value = "item_introduce")
    private String itemIntroduce;

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
