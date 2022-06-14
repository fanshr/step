package com.fanshr.step.engine.question.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fanshr.step.engine.question.domain.entity.QuestionTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 15:27
 * @date : Modified at 2021/11/11 15:27
 */
@Mapper
public interface TagDao extends BaseMapper<QuestionTag> {

    List<QuestionTag> queryList(@Param("condition") QuestionTag condition);
    List<QuestionTag> queryByIds(@Param("ids") String ids);


    QuestionTag queryOne(Integer id);

    int insert(QuestionTag questionTag);

    int update(QuestionTag questionTag);

    int delete(Integer id);
    int batchDelete(List<Integer> idList);


}
