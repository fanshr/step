package com.fanshr.step.engine.question.dao;

import com.fanshr.step.engine.question.entity.Tag;
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
public interface TagDao {

    List<Tag> queryList(@Param("condition") Tag condition);
    List<Tag> queryByIds(@Param("ids") String ids);


    Tag queryOne(Integer id);

    int insert(Tag tag);

    int update(Tag tag);

    int delete(Integer id);
    int batchDelete(List<Integer> idList);


}
