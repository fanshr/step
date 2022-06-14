package com.fanshr.step.engine.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanshr.step.engine.security.domain.entity.RightType;
import com.fanshr.step.engine.security.dao.RightTypeMapper;
import com.fanshr.step.engine.security.service.RightTypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限类型表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class RightTypeServiceImpl extends ServiceImpl<RightTypeMapper, RightType> implements RightTypeService {

}
