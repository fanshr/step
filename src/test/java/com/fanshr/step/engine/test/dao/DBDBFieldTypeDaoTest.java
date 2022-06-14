package com.fanshr.step.engine.test.dao;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.engine.BaseTest;
import com.fanshr.step.engine.test.entity.DBFieldType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/1 15:46
 * @date : Modified at 2022/2/1 15:46
 */
public class DBDBFieldTypeDaoTest extends BaseTest {
    @Autowired
    DBFieldTypeDao DBFieldTypeDao;

    @Test
    public void testQuery() {
        DBFieldType DBFieldType = new DBFieldType();
        List<DBFieldType> DBFieldTypeList = DBFieldTypeDao.queryList(DBFieldType);
        System.out.println(DBFieldTypeList);
        System.out.println("1====================");


    }

    @Test
    public void testQueryById() {

        DBFieldType DBFieldType = DBFieldTypeDao.queryOne(1L);
        System.out.println(DBFieldType);

    }

    @Test
    public void testInsertFieldType() {
        DBFieldType DBFieldType = new DBFieldType();
        DBFieldType.setField1(true);
        DBFieldType.setField2(false);
        DBFieldType.setField3(true);

        int effectedRow = DBFieldTypeDao.insert(DBFieldType);
        Assert.assertEquals(1, effectedRow);
    }


    @Test
    public void testids() {

        String ids = "2,3,4,5,6";
        List<DBFieldType> DBFieldTypeList;
        DBFieldTypeList = DBFieldTypeDao.queryByIds1(ids);
        System.out.println(JSON.toJSONString(DBFieldTypeList));
        DBFieldTypeList = DBFieldTypeDao.queryByIds2(ids);
        System.out.println(JSON.toJSONString(DBFieldTypeList));
    }

    @Test
    public void testQueryByTags() {


        List<DBFieldType> DBFieldTypeList = null;
        // 批量模糊查询
        DBFieldTypeList = DBFieldTypeDao.queryByFuzzy("注1,注3,备注4");
        System.out.println(JSON.toJSONString(DBFieldTypeList));

        // 标签多选查询
        DBFieldTypeList = DBFieldTypeDao.queryBytags("2,3,4,6");
        System.out.println(JSON.toJSONString(DBFieldTypeList));

    }

    @Test
    public void testQueryListByMap() {
        List<DBFieldType> DBFieldTypeList = null;
        // fieldTypeList = fieldTypeDao.queryListByMap1();
        // System.out.println(JSON.toJSONString(fieldTypeList));

        DBFieldTypeList = DBFieldTypeDao.queryListByMap2();
        System.out.println(JSON.toJSONString(DBFieldTypeList));
    }


    /**
     * 测试类型
     */
    @Test
    public void test67() {

    }

    /**
     * 测试单个字段在 if 条件语句中的使用
     * 单个参数时，在 if 中可以使用_parameter进行接收，在#{} 中可以用任意的名称，比如_parameter,或者参数名称，或者其他任意值
     * 或者使用@Param对参数进行修饰，此时的可以使用绑定的参数名称进行接收
     */
    @Test
    public void testParam() {
        List<DBFieldType> DBFieldTypeList = null;
        // 注释掉的方法均会出现 org.apache.ibatis.reflection.ReflectionException: There is no getter for property named 'title'
        // in 'class java.lang.String'
        // fieldTypeList = fieldTypeDao.queryByTitle1("测试");
        // System.out.println("queryByTitle1-----"+JSON.toJSONString(fieldTypeList));
        // fieldTypeList = fieldTypeDao.queryByTitle3("测试");
        // System.out.println("queryByTitle3-----"+JSON.toJSONString(fieldTypeList));
        DBFieldTypeList = DBFieldTypeDao.queryByTitle4("测试");
        System.out.println("queryByTitle4-----" + JSON.toJSONString(DBFieldTypeList));
        DBFieldTypeList = DBFieldTypeDao.queryByTitle2("测试");
        System.out.println("queryByTitle2-----" + JSON.toJSONString(DBFieldTypeList));
        DBFieldTypeList = DBFieldTypeDao.queryByTitle5("测试");
        System.out.println("queryByTitle5-----" + JSON.toJSONString(DBFieldTypeList));
        DBFieldTypeList = DBFieldTypeDao.queryByTitle6("测试");
        System.out.println("queryByTitle6-----" + JSON.toJSONString(DBFieldTypeList));
        DBFieldTypeList = DBFieldTypeDao.queryByTitle7("测试");
        System.out.println("queryByTitle7-----" + JSON.toJSONString(DBFieldTypeList));

        // 其他包装类型有类似情况
        // fieldTypeList = fieldTypeDao.queryByCreatorId(1);
        // System.out.println("queryByCreatorId-----"+JSON.toJSONString(fieldTypeList));
    }

    /**
     * 一个参数时，如果不使用@Param绑定变量，那么针对
     * <where>
     * <if test="value!=null and value !=''">
     * and remark=#{value}
     * </if>
     * </where>
     * 中的情况说明如下：
     * if中用于接收参数的变量可以是_parameter 或者 value
     * #{value} 中可以使用任意合法的字符串替换，比如remark,dkjj,dfkdj
     * <p>
     * <p>
     * 参照源码如下：
     * <p>
     * TextSqlNode.java的57行
     * public String handleToken(String content) {
     * Object parameter = context.getBindings().get("_parameter");
     * if (parameter == null) {
     * context.getBindings().put("value", null);
     * } else if (SimpleTypeRegistry.isSimpleType(parameter.getClass())) {
     * context.getBindings().put("value", parameter);
     * }
     * Object value = OgnlCache.getValue(content, context.getBindings());
     * return (value == null ? "" : String.valueOf(value)); // issue #274 return "" instead of "null"
     * }
     */
    @Test
    public void testValue() {
        List<DBFieldType> DBFieldTypeList = DBFieldTypeDao.queryByRemark("备注1");
        System.out.println(JSON.toJSONString(DBFieldTypeList));
    }

    /**
     * 针对两个及以上参数，且不使用@Param的情况
     * if以及其中sql均只能使用arg0,arg1...
     * 或者 param1,param2...来接收参数
     * <p>
     * Parameter 'creatorId' not found. Available parameters are [arg1, arg0, param1, param2]
     */
    @Test
    public void testParamMulti() {
        List<DBFieldType> DBFieldTypeList = null;
        // fieldTypeList = fieldTypeDao.queryByCreatorIdAndRemark1(1,"备注1");
        // System.out.println("queryByCreatorIdAndRemark1-----"+JSON.toJSONString(fieldTypeList));
        // fieldTypeList = fieldTypeDao.queryByCreatorIdAndRemark2(1,"备注1");
        // System.out.println("queryByCreatorIdAndRemark2-----"+JSON.toJSONString(fieldTypeList));
        DBFieldTypeList = DBFieldTypeDao.queryByCreatorIdAndRemark3(1, "备注1");
        System.out.println("queryByCreatorIdAndRemark3-----" + JSON.toJSONString(DBFieldTypeList));
        DBFieldTypeList = DBFieldTypeDao.queryByCreatorIdAndRemark4(1, "备注1");
        System.out.println("queryByCreatorIdAndRemark4-----" + JSON.toJSONString(DBFieldTypeList));
        DBFieldTypeList = DBFieldTypeDao.queryByCreatorIdAndRemark5(1, "备注1");
        System.out.println("queryByCreatorIdAndRemark5-----" + JSON.toJSONString(DBFieldTypeList));

        // fieldTypeList = fieldTypeDao.queryByCreatorIdAndRemark5(1,"备注1");
        // System.out.println("queryByCreatorIdAndRemark5-----"+JSON.toJSONString(fieldTypeList));
    }


    /**
     * 测试上级递归，所有上级，直接下级的处理
     */
    @Test
    public void test79() {

    }



}

