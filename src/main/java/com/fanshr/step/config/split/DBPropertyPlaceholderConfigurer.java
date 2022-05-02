package com.fanshr.step.config.split;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/3/30 14:40
 * @date : Modified at 2022/3/30 14:40
 */
public class DBPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    // 需要解密的属key
    private String[] encryptedProperties;
    // 配置文件
    private Properties properties;

    public void setEncryptedProperties(String[] encryptedProperties) {
        this.encryptedProperties = encryptedProperties;
    }

    @Override
    protected void convertProperties(Properties properties) {
        if (encryptedProperties != null) {
            // 遍历需要解密的key
            for (int i = 0; i < encryptedProperties.length; i++) {
                String key = encryptedProperties[i];
                if (properties.containsKey(key)) {
                    String value = properties.getProperty(key);
                    // 解密
                    value = DESUtil.getDecryptString(value);
                    // 重新赋值
                    properties.setProperty(key, value);
                }
            }
        }
        this.properties = properties;
        super.convertProperties(properties);
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

}
