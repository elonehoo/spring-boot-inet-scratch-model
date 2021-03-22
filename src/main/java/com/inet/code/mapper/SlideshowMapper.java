package com.inet.code.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inet.code.entity.slideshow.po.Slideshow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 轮播图表 Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
public interface SlideshowMapper extends BaseMapper<Slideshow> {

    /**
     * 分页查看轮播图
     * Paginate to view the rotation chart
     * @author HCY
     * @since 2021/3/22 下午2:33
     * @param page: 分页对象
     * @param page: Paging object
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.inet.code.entity.slideshow.po.Slideshow>
    */
    IPage<Slideshow> selectPagePo(Page<Slideshow> page);
}
