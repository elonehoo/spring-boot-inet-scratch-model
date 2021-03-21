package com.inet.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.code.entity.picture.po.Picture;

/**
 * 默认头像表
 * @author HCY
 * @since 2021/3/21 上午10:43
*/
public interface PictureMapper extends BaseMapper<Picture> {
    /**
     * 产生随机的图片URL
     * Generates a random image URL
     * @author HCY
     * @since 2021/3/21 下午2:29
     * @param state: 随机数值 --- 范围（ 0，默认头像 - 1 ）
     * @return java.lang.String
    */
    String selectRandomPictureUrl(int state);
}
