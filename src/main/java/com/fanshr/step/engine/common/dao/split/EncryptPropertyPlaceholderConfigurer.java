package com.fanshr.step.engine.common.dao.split;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/3/30 14:27
 * @date : Modified at 2022/3/30 14:27
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    // 需加密的字段数组
    private String[] encryptPropNames = {"jdbc.username", "jdbc.password"};

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            String decryptValue = DESUtil.getDecryptString(propertyValue);
            return decryptValue;
        }else{
            return propertyValue;
        }

    }

    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropName : encryptPropNames) {
            if (encryptPropName.equals(propertyName)) {
                return true;
            }
        }

        return false;

    }


    // @Override
    // protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) {
    //     System.out.println("正在解密系统文件...");
    //     try {
    //         String JdPassword = props.getProperty("jdbc.password");
    //         // rk----------------------
    //         if (JdPassword != null &&JdPassword .startsWith("{DES}")) {
    //
    //             JdPassword = JdPassword .substring("{DES}".length());
    //             //解密  password
    //             JdPassword = DESUtil.getDecryptString(JdPassword);
    //         }
    //
    //         //将解密后的密码放入Properties中
    //         props.setProperty("jdbc.password", JdPassword);
    //         super.processProperties(beanFactory, props);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         throw new RuntimeException(e.getMessage());
    //     }
    // }




}
