package com.fanshr.step.engine.core.service.impl;

import com.fanshr.step.engine.core.domain.entity.Locale;
import com.fanshr.step.engine.core.dao.LocaleMapper;
import com.fanshr.step.engine.core.service.LocaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统国际化可选表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class LocaleServiceImpl extends ServiceImpl<LocaleMapper, Locale> implements LocaleService {

}
