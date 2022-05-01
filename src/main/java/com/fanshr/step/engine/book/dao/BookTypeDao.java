package com.fanshr.step.engine.book.dao;


import com.fanshr.step.engine.book.entity.BookType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author : LiuYJ	
 * @date : Created at 2022/3/16 11:26
 * @date : Modified at 2022/3/16 11:26
 * @version : v1.0       	
 */

public interface BookTypeDao {

    /**
     * 传入id时，取所有的一级类别
     * 传入描述时，取所有的二级类别
     * 传入parentId时，取某一个级别下的二级类别
     * @param condition
     * @return
     */
    List<BookType> queryList(@Param("condition") BookType condition);

    BookType queryOne(@Param("id") Integer id);

    int insert(BookType bookType);

    int update(BookType bookType);

    int delete(Integer id);
    int batchDelete(List<Integer> idList);


}
