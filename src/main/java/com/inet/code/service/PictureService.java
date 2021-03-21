package com.inet.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.code.entity.picture.po.Picture;

/**
 * 默认头像的接口
 * @author HCY
 * @since 2021/3/21 上午10:42
*/
public interface PictureService extends IService<Picture> {

    /**
     * 随机产生一个图片URL
     * Randomly generates an image URL
     * @author HCY
     * @since 2021/3/21 下午2:17
     * @return java.lang.String
    */
    String getRandomPictureUrl();
}
