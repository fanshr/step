package com.fanshr.step.engine.test;

import com.fanshr.step.config.split.DESUtil;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

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

    @Test
    public void test30(){

        String gensalt = BCrypt.gensalt();
        System.out.println("gensalt-->"+gensalt);

        String testStr = BCrypt.hashpw("0000", gensalt);
        System.out.println("testStr-->"+testStr);

    }

    @Test
    public void testBCrypt(){

        //对密码进行加密
        String hashpw = BCrypt.hashpw("456", BCrypt.gensalt());
        System.out.println(hashpw);

        //校验密码
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$aFsOFzujtPCnUCUKcozsHux0rQ/3faAHGFSVb9Y.B1ntpmEhjRtru");
        boolean checkpw2 = BCrypt.checkpw("123", "$2a$10$HuClcUqr/FSLmzSsp9SHqe7D51Keu1sAL7tUAAcb..FyILiLdFKYy");
        System.out.println(checkpw);
        System.out.println(checkpw2);

        boolean checkpw3 = BCrypt.checkpw("0000", "$2a$10$afZL2hOlJ0MVdD9fHfhapuqyDeCYRtd61VTRU3FD0XykMYtBkoPh6");

        System.out.println(checkpw3);
    }


}
