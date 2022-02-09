package com.fanshr.step.dao;

import com.fanshr.step.entity.InterviewCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 15:27
 * @date : Modified at 2021/11/11 15:27
 */

public interface InterviewCategoryDao {

    List<InterviewCategory> queryList(@Param("interviewCategoryCondition") InterviewCategory interviewCategoryCondition);

    InterviewCategory queryOne(@Param("id") Integer id);

    int insert(InterviewCategory interviewCategory);

    int update(InterviewCategory interviewCategory);

    int delete(long id);
    int batchDelete(List<Integer> interviewCategoryIdList);


}
