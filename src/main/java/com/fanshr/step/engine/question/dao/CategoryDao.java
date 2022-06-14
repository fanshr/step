package com.fanshr.step.engine.question.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fanshr.step.engine.question.domain.entity.Category;
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
public interface CategoryDao extends BaseMapper<Category> {

    /**
     * 传入id时，取所有的一级类别
     * 传入描述时，取所有的二级类别
     * 传入parentId时，取某一个级别下的二级类别
     * @param categoryCondition
     * @return
     */
    List<Category> queryList(@Param("condition") Category categoryCondition);

    Category queryOne(@Param("id") Integer id);

    int insert(Category category);

    int update(Category category);

    int delete(long id);
    int batchDelete(List<Integer> interviewCategoryIdList);


}
