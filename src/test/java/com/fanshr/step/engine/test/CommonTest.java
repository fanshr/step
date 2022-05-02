package com.fanshr.step.engine.test;

import com.fanshr.step.config.split.DESUtil;
import org.junit.Test;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/3/14 10:48
 * @date : Modified at 2022/3/14 10:48
 */
public class CommonTest {
    @Test
    public void test11(){
        String str = "Hello";
        System.out.println(str.substring(0,str.length()-1));
    }

    @Test
    public void test19(){
        String encryptUserName = DESUtil.getEncryptString("root");
        String encryptPassword = DESUtil.getEncryptString("123456");
        System.out.println(encryptUserName);
        System.out.println(encryptPassword);
        System.out.println(DESUtil.getDecryptString(encryptUserName));
        System.out.println(DESUtil.getDecryptString(encryptPassword));
    }


}
