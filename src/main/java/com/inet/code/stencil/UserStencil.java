package com.inet.code.stencil;

import com.inet.code.entity.user.po.User;
import com.inet.code.entity.user.vo.AllUserInfo;

/**
 * 用户接口
 * @author HCY
 * @since 2021/3/20 上午8:18
*/
public interface UserStencil {
    /**
     * 通过用户的主键进行查询
     * @author HCY
     * @since 2021/3/20 上午8:22
     * @param userId: 用户主键
     * @return com.inet.code.entity.user.vo.AllUserInfo
    */
    AllUserInfo getByAllUserInfo(String userId);

    /**
     * 通过用户主键获取到用户信息
     * @author HCY
     * @since 2021/3/20 上午9:09
     * @param userId: 用户主键
     * @return com.inet.code.entity.user.po.User
    */
    User getById(String userId);
}
