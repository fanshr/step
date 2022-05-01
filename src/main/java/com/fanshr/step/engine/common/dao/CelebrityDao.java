package com.fanshr.step.engine.common.dao;


import com.fanshr.step.engine.common.entity.Celebrity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 15:27
 * @date : Modified at 2021/11/11 15:27
 */

public interface CelebrityDao {

    List<Celebrity> queryList(@Param("condition") Celebrity condition);
    List<Celebrity> queryByIds(@Param("ids") String ids);


    Celebrity queryOne(Integer id);

    int insert(Celebrity celebrity);

    int update(Celebrity celebrity);

    int delete(Integer id);
    int batchDelete(List<Integer> idList);


}
