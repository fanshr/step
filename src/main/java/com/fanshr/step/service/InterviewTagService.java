package com.fanshr.step.service;

import com.fanshr.step.dto.Execution;
import com.fanshr.step.entity.InterviewTag;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 17:08
 * @date : Modified at 2021/11/11 17:08
 */
public interface InterviewTagService {


    List<InterviewTag> get();
    InterviewTag get(Integer id);

    Execution add(InterviewTag interviewTag);

    Execution modify(InterviewTag interviewTag);
    Execution remove(Integer id);

    Execution multiRemove(List<Integer> idList);


}
