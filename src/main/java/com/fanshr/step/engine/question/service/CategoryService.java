package com.fanshr.step.engine.question.service;

import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.question.entity.Category;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 17:08
 * @date : Modified at 2021/11/11 17:08
 */
public interface CategoryService {


    List<Category> get(Category condition);
    Category get(Integer id);



    Execution add(Category category);

    Execution modify(Category category);
    Execution remove(Integer id);

    Execution multiRemove(List<Integer> idList);


}
