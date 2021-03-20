package com.inet.code.service;

import com.inet.code.entity.role.po.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
public interface RoleService extends IService<Role> {

    /**
     * 通过用户序号获取到用户的角色
     * @author HCY
     * @since 2021/3/20 上午8:35
     * @param userId: 用户序号
     * @return com.inet.code.entity.role.po.Role
    */
    Role getByUserId(String userId);
}
