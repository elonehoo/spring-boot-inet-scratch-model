package com.inet.code.service.impl;

import com.inet.code.entity.power.po.Power;
import com.inet.code.mapper.PowerMapper;
import com.inet.code.service.PowerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Service
public class PowerServiceImpl extends ServiceImpl<PowerMapper, Power> implements PowerService {

    @Resource
    private PowerMapper powerMapper;

    /**
     * 通过用户序号获取用户权限
     *
     * @param userId : 用户序号
     * @return java.util.List<com.inet.code.entity.power.po.Power>
     * @author HCY
     * @since 2021/3/20 上午8:48
     */
    @Override
    public List<Power> getByUserId(String userId) {
        return powerMapper.selectByUserId(userId);
    }
}
