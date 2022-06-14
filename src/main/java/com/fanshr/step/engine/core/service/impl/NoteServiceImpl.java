package com.fanshr.step.engine.core.service.impl;

import com.fanshr.step.engine.core.domain.entity.Note;
import com.fanshr.step.engine.core.dao.NoteMapper;
import com.fanshr.step.engine.core.service.NoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 语句索引信息 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {

}
