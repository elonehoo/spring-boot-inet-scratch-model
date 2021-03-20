package com.inet.code.service.impl;

import com.inet.code.entity.user.po.User;
import com.inet.code.entity.user.vo.AllUserInfo;
import com.inet.code.mapper.UserMapper;
import com.inet.code.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

}
