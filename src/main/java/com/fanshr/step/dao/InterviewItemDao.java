package com.fanshr.step.dao;

import com.fanshr.step.entity.InterviewItem;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 15:27
 * @date : Modified at 2021/11/11 15:27
 */
public interface InterviewItemDao {

    List<InterviewItem> queryList(@Param("condition") InterviewItem condition,
                                               @Param("rowIndex") Integer rowIndex, @Param("pageSize") Integer pageSize);

    int queryCount(@Param("condition") InterviewItem condition);

    InterviewItem queryOne(Integer id);


    /**
     * 新增店铺信息
     * @param interviewItem 店铺对象
     * @return effectedRows 受影响的行数
     */
    int insert(InterviewItem interviewItem);

    int update(InterviewItem interviewItem);

    int delete(Integer id);

    int batchDelete(List<Integer> idList);


}
