package com.inet.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.code.entity.user.po.User;
import com.inet.code.entity.user.vo.AllUserInfo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
public interface UserService extends IService<User> {

    /**
     * 判断登陆操作
     * Determine Login Operations
     * @author HCY
     * @since 2021/3/20 下午2:26
     * @param account: 账号
     * @param account: Account number field
     * @param cipher: 密码
     * @param cipher: Password field
     * @return com.inet.code.entity.user.vo.AllUserInfo
    */
    String getByAccountAndCipher(String account, String cipher);
}
