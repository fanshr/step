package com.fanshr.step.engine.locale.service.impl;

import com.fanshr.step.engine.locale.domain.entity.LocaleTag;
import com.fanshr.step.engine.locale.dao.LocaleTagMapper;
import com.fanshr.step.engine.locale.service.LocaleTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签多语言描述表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class LocaleTagServiceImpl extends ServiceImpl<LocaleTagMapper, LocaleTag> implements LocaleTagService {

}
