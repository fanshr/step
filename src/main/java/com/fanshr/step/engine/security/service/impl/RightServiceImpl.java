package com.fanshr.step.engine.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanshr.step.engine.security.domain.entity.Right;
import com.fanshr.step.engine.security.dao.RightMapper;
import com.fanshr.step.engine.security.service.RightService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class RightServiceImpl extends ServiceImpl<RightMapper, Right> implements RightService {

}
