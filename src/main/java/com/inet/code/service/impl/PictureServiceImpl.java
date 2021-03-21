package com.inet.code.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.code.entity.picture.po.Picture;
import com.inet.code.mapper.PictureMapper;
import com.inet.code.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 默认头像的接口
 * @author HCY
 * @since 2021/3/21 上午10:42
*/
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {

    /**
     * 图片的mapper层
     * The mapper layer of the picture
     * @author HCY
     * @since 2021/3/21 下午2:17
    */
    @Resource
    private PictureMapper pictureMapper;

    /**
     * 随机产生一个图片URL
     * Randomly generates an image URL
     * @author HCY
     * @since 2021/3/21 下午2:17
     * @return java.lang.String
     */
    @Override
    public String getRandomPictureUrl() {
        return pictureMapper.
                selectRandomPictureUrl(RandomUtil.randomInt(0, this.count() - 1));
    }
}
