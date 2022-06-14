package com.fanshr.step.engine.core.dao;

import com.fanshr.step.engine.core.domain.entity.Note;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 语句索引信息 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Mapper
public interface NoteMapper extends BaseMapper<Note> {

}
