package com.inet.code.service.impl;

import com.inet.code.entity.state.po.State;
import com.inet.code.mapper.StateMapper;
import com.inet.code.service.StateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 状态表 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-03-17
 */
@Service
public class StateServiceImpl extends ServiceImpl<StateMapper, State> implements StateService {

}
