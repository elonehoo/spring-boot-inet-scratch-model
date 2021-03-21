package com.inet.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.code.entity.user.po.User;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过账号和密码获取用户的序号
     * Get the serial number of the user through the account and password
     * @author HCY
     * @since 2021/3/20 下午2:37
     * @param account: 账号
     * @param account: Account number field
     * @param cipher: 密码
     * @param cipher: Password field
     * @return java.lang.String
    */
    String selectByAccountAndPassword(String account, String cipher);

    /**
     * 通过账号查询是否重复
     * Check for duplication by checking the account number
     * @author HCY
     * @since 2021/3/21 下午4:40
     * @param account: 账号
     * @param account: Account number field
     * @return java.lang.Integer
    */
    Integer selectByAccount(String account);

    /**
     * 通过账号查询用户序号
     * Inquire the serial number of the user through the account
     * @author HCY
     * @since 2021/3/21 下午5:02
     * @param account: 账号
     * @param account: Account number field
     * @return java.lang.String
    */
    String selectAccountByUserId(String account);
}

