package com.fanshr.step.engine.common.config;

import ch.qos.logback.core.PropertyDefinerBase;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/3/18 11:21
 * @date : Modified at 2022/3/18 11:21
 */
public class LogHomeProperty extends PropertyDefinerBase {
    private static final String separator = System.getProperty("file.separator");

    @Override
    public String getPropertyValue() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")){
            basePath = "D:/code/project/step/step_java/logs";
        }else{
            basePath = "/u01/app/tomcat/logs/step/logs";
        }
        basePath = basePath.replace("/",separator);
        return  basePath;
    }
}
