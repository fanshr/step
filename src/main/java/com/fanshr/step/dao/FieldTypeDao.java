package com.fanshr.step.dao;

import com.fanshr.step.entity.FieldType;
import com.fanshr.step.entity.InterviewTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/11 15:27
 * @date : Modified at 2021/11/11 15:27
 */

public interface FieldTypeDao {

    List<FieldType> queryList(@Param("fieldTypeCondition") FieldType fieldTypeCondition);

    FieldType queryOne(long id);

    int insert(FieldType fieldType);



    List<FieldType> queryByTitle1(String title);
    List<FieldType> queryByTitle2(@Param("title") String title);
    List<FieldType> queryByTitle3(String str);
    List<FieldType> queryByTitle4(@Param("str") String str);

    List<FieldType> queryByTitle5(@Param("title") String str);
    List<FieldType> queryByTitle6(String str);
    List<FieldType> queryByTitle7(String str);
    List<FieldType> queryByCreatorId(Integer creatorId);
    List<FieldType> queryByCreatorIdAndRemark1(Integer creatorId,String remark);
    List<FieldType> queryByCreatorIdAndRemark2(Integer creatorId,String remark);
    List<FieldType> queryByCreatorIdAndRemark3(Integer creatorId,String remark);
    List<FieldType> queryByCreatorIdAndRemark4(Integer creatorId,String remark);
    List<FieldType> queryByCreatorIdAndRemark5(@Param("creatorId") Integer creatorId,@Param("remark") String remark);


    List<FieldType> queryAdvance(Boolean field1, Boolean field2);


    /**
     * 逗号拼接的多个id字符串的 collection标签 集合查询方式
     * @param ids
     * @return
     */
    List<FieldType> queryByIds1(@Param("ids") String ids);
    /**
     * 逗号拼接的多个id字符串的in字符串字面量拼接方式
     * @param ids
     * @return
     */
    List<FieldType> queryByIds2(@Param("ids") String ids);


    FieldType queryById(@Param("id") Integer id);

    List<FieldType> queryByRemark( String remark);

    List<FieldType> queryByFuzzy(@Param("keywords") String keywords);


    List<FieldType> queryBytags(@Param("tags") String tags);

    List<FieldType> queryListByMap1();
    List<FieldType> queryListByMap2();



}
