package com.inet.code.service.impl;

import com.inet.code.entity.item.po.Item;
import com.inet.code.mapper.ItemMapper;
import com.inet.code.service.ItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目表 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {

}
