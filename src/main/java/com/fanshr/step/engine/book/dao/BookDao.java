package com.fanshr.step.engine.book.dao;

import com.fanshr.step.engine.book.entity.Book;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 15:27
 * @date : Modified at 2021/11/11 15:27
 */
public interface BookDao {

    List<Book> queryList(@Param("condition") Book condition,
                         @Param("rowIndex") Integer rowIndex, @Param("pageSize") Integer pageSize);

    int queryCount(@Param("condition") Book condition);

    Page<Book> list(@Param("condition") Book condition);

    Book queryOne(Integer id);


    /**
     * 新增店铺信息
     * @param book 店铺对象
     * @return effectedRows 受影响的行数
     */
    int insert(Book book);

    int update(Book book);

    int delete(Integer id);

    int batchDelete(List<Integer> idList);


}
