package com.fanshr.step.service;

import com.fanshr.step.dto.Execution;
import com.fanshr.step.entity.InterviewCategory;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 17:08
 * @date : Modified at 2021/11/11 17:08
 */
public interface InterviewCategoryService {


    List<InterviewCategory> get();
    InterviewCategory get(Integer id);

    List<InterviewCategory> get2();
    List<InterviewCategory> get2(Integer parentId);

    Execution add(InterviewCategory interviewCategory);

    Execution modify(InterviewCategory interviewCategory);
    Execution remove(Integer id);

    Execution multiRemove(List<Integer> idList);


}
