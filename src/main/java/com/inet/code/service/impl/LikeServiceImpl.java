package com.inet.code.service.impl;

import com.inet.code.entity.like.po.Like;
import com.inet.code.mapper.LikeMapper;
import com.inet.code.service.LikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 点赞表 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Service
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements LikeService {

}
