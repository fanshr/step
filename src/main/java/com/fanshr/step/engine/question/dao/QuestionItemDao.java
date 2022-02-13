package com.fanshr.step.engine.question.dao;

import com.fanshr.step.engine.question.entity.QuestionItem;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 15:27
 * @date : Modified at 2021/11/11 15:27
 */
public interface QuestionItemDao {

    List<QuestionItem> queryList(@Param("condition") QuestionItem condition,
                                 @Param("rowIndex") Integer rowIndex, @Param("pageSize") Integer pageSize);

    int queryCount(@Param("condition") QuestionItem condition);

    Page<QuestionItem> list(@Param("condition") QuestionItem condition);

    QuestionItem queryOne(Integer id);


    /**
     * 新增店铺信息
     * @param questionItem 店铺对象
     * @return effectedRows 受影响的行数
     */
    int insert(QuestionItem questionItem);

    int update(QuestionItem questionItem);

    int delete(Integer id);

    int batchDelete(List<Integer> idList);


}