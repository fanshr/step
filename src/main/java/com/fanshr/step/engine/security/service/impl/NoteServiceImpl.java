package com.fanshr.step.engine.security.service.impl;

import com.fanshr.step.engine.security.entity.Note;
import com.fanshr.step.engine.security.mapper.NoteMapper;
import com.fanshr.step.engine.security.service.NoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 语句索引信息 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {

}
