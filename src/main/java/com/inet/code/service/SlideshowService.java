package com.inet.code.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inet.code.entity.slideshow.po.Slideshow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 轮播图表 服务类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
public interface SlideshowService extends IService<Slideshow> {

    /**
     * 分页查看轮播图
     * Paginate to view the rotation chart
     * @author HCY
     * @since 2021/3/22 下午2:30
     * @param slideshowPage: 分页对象
     * @param slideshowPage: Paging object
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.inet.code.entity.slideshow.po.Slideshow>
    */
    IPage<Slideshow> pageSlideshow(Page<Slideshow> slideshowPage);
}
