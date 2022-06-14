package com.fanshr.step.engine.common.exception;

/**
 * 服务异常
 * 
 * @author : LiuYJ	
 * @date : Created at 2022/4/30 18:24
 * @date : Modified at 2022/4/30 18:24
 * @version : v1.0       	
 */
public class IServiceException extends Exception {
    public  IServiceException(){
        super();
    }

    public IServiceException(String msg){
        super(msg);
    }
}
