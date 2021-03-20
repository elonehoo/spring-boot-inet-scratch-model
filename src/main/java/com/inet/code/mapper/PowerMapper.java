package com.inet.code.mapper;

import com.inet.code.entity.power.po.Power;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
public interface PowerMapper extends BaseMapper<Power> {

    /**
     * 通过用户序号获取到用户权限集合
     * @author HCY
     * @since 2021/3/20 上午8:53
     * @param userId: 用户序号
     * @return java.util.List<com.inet.code.entity.power.po.Power>
    */
    List<Power> selectByUserId(String userId);
}
