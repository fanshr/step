package com.fanshr.step.engine.core.service.impl;

import com.fanshr.step.engine.core.domain.entity.Tag;
import com.fanshr.step.engine.core.dao.TagMapper;
import com.fanshr.step.engine.core.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
