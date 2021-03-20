package com.inet.code.service;

import com.inet.code.entity.power.po.Power;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
public interface PowerService extends IService<Power> {

    /**
     * 通过用户序号获取用户权限
     * @author HCY
     * @since 2021/3/20 上午8:48
     * @param userId: 用户序号
     * @return java.util.List<com.inet.code.entity.power.po.Power>
    */
    List<Power> getByUserId(String userId);
}
