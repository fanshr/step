package com.fanshr.step.dao;

import com.fanshr.step.entity.InterviewTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 15:27
 * @date : Modified at 2021/11/11 15:27
 */

public interface InterviewTagDao {

    List<InterviewTag> queryList(@Param("interviewTagCondition") InterviewTag interviewTagCondition);
    List<InterviewTag> queryByIds(@Param("ids") String ids);


    InterviewTag queryOne(Integer id);

    int insert(InterviewTag interviewTag);

    int update(InterviewTag interviewTag);

    int delete(Integer id);
    int batchDelete(List<Integer> interviewTagIdList);


}
