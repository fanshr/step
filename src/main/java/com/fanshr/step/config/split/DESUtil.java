package com.fanshr.step.config.split;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.SecureRandom;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/3/30 14:15
 * @date : Modified at 2022/3/30 14:15
 */
public class DESUtil {
    private static Key key;
    private static String KEY_STR = "MYkEY";
    private static String CHASETNAME = "UTF-8";
    private static String ALGORITHM = "DES";
    static {
        try {
            //生成DES算法对象
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            // 运用SHA1安全策略
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            // 设置秘钥种子
            secureRandom.setSeed(KEY_STR.getBytes());
            // 初始化基于SHA1的算法对象
            generator.init(secureRandom);
            // 生成秘钥对象
            key = generator.generateKey();
            generator = null;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getEncryptString(String str) {
        BASE64Encoder encoder = new BASE64Encoder();

        try {
            // 获取字节流
            byte[] bytes = str.getBytes(CHASETNAME);
            // 获取加密对象
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // 初始化密码信息
            cipher.init(Cipher.ENCRYPT_MODE,key);
            // 加密
            byte[] doFinal = cipher.doFinal(bytes);
            return encoder.encode(doFinal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDecryptString(String str) {
        BASE64Decoder decoder = new BASE64Decoder();

        try {
            byte[] bytes = decoder.decodeBuffer(str);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] doFinal = cipher.doFinal(bytes);
            return new String(doFinal, CHASETNAME);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
