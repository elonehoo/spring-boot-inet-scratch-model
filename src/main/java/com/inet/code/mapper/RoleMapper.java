package com.inet.code.mapper;

import com.inet.code.entity.role.po.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 通过用户主键获取到用户的序号
     * @author HCY
     * @since 2021/3/20 上午8:36
     * @param userId: 用户主键
     * @return com.inet.code.entity.role.po.Role
    */
    Role selectByUserId(String userId);

    /**
     * 通过角色名字获取角色实体类
     * @author HCY
     * @since 2021/3/21 下午5:55
     * @param roleName: 角色名字
     * @param roleName: Character name
     * @return com.inet.code.entity.role.po.Role
    */
    Role selectByRoleName(String roleName);

}
