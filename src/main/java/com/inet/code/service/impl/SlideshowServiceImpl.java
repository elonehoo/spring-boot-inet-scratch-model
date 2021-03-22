package com.inet.code.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inet.code.entity.slideshow.po.Slideshow;
import com.inet.code.mapper.SlideshowMapper;
import com.inet.code.service.SlideshowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 轮播图表 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Service
public class SlideshowServiceImpl extends ServiceImpl<SlideshowMapper, Slideshow> implements SlideshowService {

    /**
     * 轮播图持久层
     * Rotate the graph persistence layer
     * @author HCY
     * @since 2021/3/22 下午2:31
    */
    @Resource
    private SlideshowMapper slideshowMapper;

    /**
     * 分页查看轮播图
     * Paginate to view the rotation chart
     * @author HCY
     * @since 2021/3/22 下午2:30
     * @param page: 分页对象
     * @param page: Paging object
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.inet.code.entity.slideshow.po.Slideshow>
     */
    @Override
    public IPage<Slideshow> pageSlideshow(Page<Slideshow> page) {
        return slideshowMapper.selectPagePo(page);
    }
}
