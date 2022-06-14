package com.fanshr.step.engine.core.service.impl;

import com.fanshr.step.engine.core.domain.entity.Language;
import com.fanshr.step.engine.core.dao.LanguageMapper;
import com.fanshr.step.engine.core.service.LanguageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统语言可选表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class LanguageServiceImpl extends ServiceImpl<LanguageMapper, Language> implements LanguageService {

}
