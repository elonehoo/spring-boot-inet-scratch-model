package com.inet.code.service.impl;

import com.inet.code.entity.user.po.User;
import com.inet.code.entity.user.vo.AllUserInfo;
import com.inet.code.entity.user.vo.RealmUser;
import com.inet.code.entity.userPower.vo.RealmPermissions;
import com.inet.code.entity.userRole.vo.RealmPart;
import com.inet.code.mapper.UserMapper;
import com.inet.code.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.code.utils.BeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

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
    @Override
    public String getByAccountAndCipher(String account, String cipher) {
        //通过账号密码获取到用户序号
        return userMapper.selectByAccountAndPassword(account,cipher);
    }

    /**
     * 通过账号判断用户账号是否重复
     * Determine whether the user account is duplicate by the account
     * @author HCY
     * @since 2021/3/21 下午4:26
     * @param account: sm4加密的账号
     * @param account: SM4 encrypted account
     * @return java.lang.Boolean
     */
    @Override
    public Boolean getByAccount(String account) {
        return userMapper.selectByAccount(account) == 1;
    }

    /**
     * 通过账号获取到用户的序号
     * Get the serial number of the user through the account
     * @author HCY
     * @since 2021/3/21 下午4:52
     * @param account: 账号
     * @param account: Account number field
     * @return java.lang.String
     */
    @Override
    public String accountByUserId(String account) {
        return userMapper.selectAccountByUserId(account);
    }
}
