package com.inet.code.stencil;

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
}
