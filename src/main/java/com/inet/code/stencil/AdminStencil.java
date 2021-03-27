package com.inet.code.stencil;

import com.inet.code.entity.slideshow.dto.AmendSlideshowBean;
import com.inet.code.entity.slideshow.dto.SlideshowBean;
import com.inet.code.entity.user.dto.EnrollBean;
import com.inet.code.result.Result;

/**
 * 管理员通用模板
 * @author HCY
 * @since 2021/3/20 上午8:16
*/
public interface AdminStencil {

    /**
     * 注册的操作
     * Operation of registration
     * @author HCY
     * @since 2021/3/21 上午11:15
     * @param enrollBean: 注册的需要的用户名
     * @param enrollBean: The user name required for registration
     * @param path: URL路径
     * @param path: The URL path
     * @return com.inet.code.result.Result
    */
    Result enroll(EnrollBean enrollBean, String path);

    /**
     * 查看轮播图
     * Check out the rotation chart
     * @author HCY
     * @since 2021/3/22 下午1:45
     * @param current: 页数
     * @param current: Number of pages
     * @param size: 条目数
     * @param size: Number of entries
     * @param path: URL路径
     * @param path: The URL path
     * @return com.inet.code.result.Result
    */
    Result getSlideshow(Integer current, Integer size, String path);

    /**
     * 通过轮播图序号删除轮播图
     * Delete the rotation map by the rotation map serial number
     * @author HCY
     * @since 2021/3/23 上午9:02
     * @param id: 轮播图序号
     * @param id: Rotate the map sequence number
     * @param path: URL路径
     * @param path: The URL path
     * @return com.inet.code.result.Result
    */
    Result deleteSlideshow(String id, String path);

    /**
     * 通过轮播图的序号修改轮播图的状态
     * Modify the state of the carousel by its serial number
     * @author HCY
     * @since 2021/3/23 上午9:55
     * @param slideshowBean: 轮播图的序号实体类 --> [序号]
     * @param slideshowBean: Ordinal Entity Class of Rotating Graph --> [Ordinal]
     * @param path: URL路径
     * @param path: The URL path
     * @return com.inet.code.result.Result
    */
    Result putSlideshow(SlideshowBean slideshowBean, String path);

    /**
     * 保存轮播图
     * Save the rotation map
     * @author HCY
     * @since 2021/3/27 上午11:33
     * @param amendSlideshowBean: 添加轮播图的实体类 --> [轮播图的URL]
     * @param amendSlideshowBean: Add the entity class of the rotated graph --> [URL of the rotated graph]
     * @param path: URL路径
     * @param path: The URL path
     * @return com.inet.code.result.Result
    */
    Result amendSlideshow(AmendSlideshowBean amendSlideshowBean, String path);
}
