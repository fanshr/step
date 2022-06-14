package com.fanshr.step.engine.core.service.impl;

import com.fanshr.step.engine.core.domain.entity.Keyword;
import com.fanshr.step.engine.core.dao.KeywordMapper;
import com.fanshr.step.engine.core.service.KeywordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关键保留字表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class KeywordServiceImpl extends ServiceImpl<KeywordMapper, Keyword> implements KeywordService {

}
