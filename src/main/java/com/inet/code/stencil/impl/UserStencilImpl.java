package com.inet.code.stencil.impl;

import com.inet.code.entity.user.po.User;
import com.inet.code.entity.user.vo.AllUserInfo;
import com.inet.code.entity.user.vo.RealmUser;
import com.inet.code.entity.userPower.vo.RealmPermissions;
import com.inet.code.entity.userRole.vo.RealmPart;
import com.inet.code.service.PowerService;
import com.inet.code.service.RoleService;
import com.inet.code.service.UserService;
import com.inet.code.stencil.UserStencil;
import com.inet.code.utils.BeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户接口实现类
 * @author HCY
 * @since 2021/3/20 上午8:19
*/
@Service
public class UserStencilImpl implements UserStencil {

    /**
     * 用户接口
     * @author HCY
     * @since 2021/3/20 上午8:32
    */
    @Resource
    private UserService userService;

    /**
     * 角色接口
     * @author HCY
     * @since 2021/3/20 上午8:32
    */
    @Resource
    private RoleService roleService;

    /**
     * 权限接口
     * @author HCY
     * @since 2021/3/20 上午8:44
    */
    @Resource
    private PowerService powerService;

    /**
     * 通过用户的主键进行查询
     *
     * @param userId : 用户主键
     * @return com.inet.code.entity.user.vo.AllUserInfo
     * @author HCY
     * @since 2021/3/20 上午8:22
     */
    @Override
    public AllUserInfo getByAllUserInfo(String userId) {
        //通过用户序号获取到用户的User实体类 ---> 再次使用Bean实体类将其转换成为RealmUser实体类
        RealmUser realmUser = BeanUtil.copy(userService.getById(userId),RealmUser.class);
        //通过用户序号获取到角色的Role实体类 ---> 再次使用Bean实体类将其转换为RealmPart实体类
        RealmPart realmPart = BeanUtil.copy(roleService.getByUserId(userId), RealmPart.class);
        //通过用户序号获取到权限的实体类集合 ---> 再次使用Bean实体类将其转换成为实体类集合
        List<RealmPermissions> realmPermissions = BeanUtil.batchCopy(powerService.getByUserId(userId), RealmPermissions.class);
        //返回用户的数据
        return new AllUserInfo(realmUser,realmPart,realmPermissions);
    }

    /**
     * 通过用户主键获取到用户信息
     *
     * @param userId : 用户主键
     * @return com.inet.code.entity.user.po.User
     * @author HCY
     * @since 2021/3/20 上午9:09
     */
    @Override
    public User getById(String userId) {
        return userService.getById(userId);
    }
}
