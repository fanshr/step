package com.fanshr.step.service;

import com.fanshr.step.dto.Execution;
import com.fanshr.step.entity.InterviewItem;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/7 20:49
 * @date : Modified at 2022/2/7 20:49
 */
public interface InterviewItemService {


    Execution get(InterviewItem condition,int pageIndex,int pageSize);
    InterviewItem get(Integer id);

    Execution add(InterviewItem interviewItem);

    Execution modify(InterviewItem interviewItem);
    Execution remove(Integer id);

    Execution multiRemove(List<Integer> idList);
}
