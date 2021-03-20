package com.inet.code.service.impl;

import com.inet.code.entity.role.po.Role;
import com.inet.code.mapper.RoleMapper;
import com.inet.code.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 通过用户序号获取到用户的角色
     *
     * @param userId : 用户序号
     * @return com.inet.code.entity.role.po.Role
     * @author HCY
     * @since 2021/3/20 上午8:35
     */
    @Override
    public Role getByUserId(String userId) {
        return roleMapper.selectByUserId(userId);
    }
}
