package com.fanshr.step.engine.test.dao;

import com.fanshr.step.engine.test.entity.DBFieldType;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 15:27
 * @date : Modified at 2021/11/11 15:27
 */

public interface DBFieldTypeDao {



    List<DBFieldType> queryList(@Param("fieldTypeCondition") DBFieldType DBFieldTypeCondition);
    Page findByPage();

    DBFieldType queryOne(long id);

    int insert(DBFieldType DBFieldType);



    List<DBFieldType> queryByTitle1(String title);
    List<DBFieldType> queryByTitle2(@Param("title") String title);
    List<DBFieldType> queryByTitle3(String str);
    List<DBFieldType> queryByTitle4(@Param("str") String str);

    List<DBFieldType> queryByTitle5(@Param("title") String str);
    List<DBFieldType> queryByTitle6(String str);
    List<DBFieldType> queryByTitle7(String str);
    List<DBFieldType> queryByCreatorId(Integer creatorId);
    List<DBFieldType> queryByCreatorIdAndRemark1(Integer creatorId, String remark);
    List<DBFieldType> queryByCreatorIdAndRemark2(Integer creatorId, String remark);
    List<DBFieldType> queryByCreatorIdAndRemark3(Integer creatorId, String remark);
    List<DBFieldType> queryByCreatorIdAndRemark4(Integer creatorId, String remark);
    List<DBFieldType> queryByCreatorIdAndRemark5(@Param("creatorId") Integer creatorId, @Param("remark") String remark);


    List<DBFieldType> queryAdvance(Boolean field1, Boolean field2);


    /**
     * 逗号拼接的多个id字符串的 collection标签 集合查询方式
     * @param ids
     * @return
     */
    List<DBFieldType> queryByIds1(@Param("ids") String ids);
    /**
     * 逗号拼接的多个id字符串的in字符串字面量拼接方式
     * @param ids
     * @return
     */
    List<DBFieldType> queryByIds2(@Param("ids") String ids);


    DBFieldType queryById(@Param("id") Integer id);

    List<DBFieldType> queryByRemark(String remark);

    List<DBFieldType> queryByFuzzy(@Param("keywords") String keywords);


    List<DBFieldType> queryBytags(@Param("tags") String tags);

    List<DBFieldType> queryListByMap1();
    List<DBFieldType> queryListByMap2();



}
