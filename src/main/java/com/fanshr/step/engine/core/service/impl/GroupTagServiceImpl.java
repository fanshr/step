package com.fanshr.step.engine.core.service.impl;

import com.fanshr.step.engine.core.domain.entity.GroupTag;
import com.fanshr.step.engine.core.dao.GroupTagMapper;
import com.fanshr.step.engine.core.service.GroupTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签与组映射表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class GroupTagServiceImpl extends ServiceImpl<GroupTagMapper, GroupTag> implements GroupTagService {

}
