package com.inet.code.entity.picture.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 默认头像表
 * @author HCY
 * @since 2021/3/21 上午10:32
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@TableName("tbl_picture")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Picture {

    /**
     * 主键
     */
    @TableId(value = "id" , type = IdType.UUID)
    private String id;

    /**
     * 头像
     */
    @TableField(value = "photo_url")
    private String photoUrl;

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

    public Picture(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
