package com.inet.code.entity.slideshow.po;

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
 * 轮播图表
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("tbl_slideshow")
@EqualsAndHashCode(callSuper = false)
public class Slideshow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键序号
     */
    @TableId(value = "id" , type = IdType.UUID)
    private String id;

    /**
     * 轮播图的URL
     */
    @TableField(value = "slideshow_url")
    private String slideshowUrl;

    /**
     * 轮播图的状态
     */
    @TableField(value = "slideshow_status")
    private Boolean slideshowStatus;

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

    public Slideshow(String slideshowUrl, Boolean slideshowStatus) {
        this.slideshowUrl = slideshowUrl;
        this.slideshowStatus = slideshowStatus;
    }
}
