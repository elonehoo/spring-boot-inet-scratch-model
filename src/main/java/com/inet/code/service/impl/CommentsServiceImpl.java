package com.inet.code.service.impl;

import com.inet.code.entity.comments.po.Comments;
import com.inet.code.mapper.CommentsMapper;
import com.inet.code.service.CommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

}
