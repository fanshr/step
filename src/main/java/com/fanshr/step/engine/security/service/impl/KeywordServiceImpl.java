package com.fanshr.step.engine.security.service.impl;

import com.fanshr.step.engine.security.entity.Keyword;
import com.fanshr.step.engine.security.mapper.KeywordMapper;
import com.fanshr.step.engine.security.service.KeywordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关键保留字表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Service
public class KeywordServiceImpl extends ServiceImpl<KeywordMapper, Keyword> implements KeywordService {

}
