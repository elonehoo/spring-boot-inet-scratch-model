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
     * Get the user's role from the user serial number
     * @author HCY
     * @since 2021/3/20 上午8:35
     * @param userId: 用户序号
     * @return com.inet.code.entity.role.po.Role
    */
    Role getByUserId(String userId);

    /**
     * 通过角色名字获取角色实体类
     * Get the role entity class by the role name
     * @author HCY
     * @since 2021/3/21 下午5:09
     * @param roleName: 角色名字
     * @param roleName: Character name
     * @return com.inet.code.entity.role.po.Role
    */
    Role getByUserName(String roleName);
}
