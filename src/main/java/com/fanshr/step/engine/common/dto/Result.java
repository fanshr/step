package com.fanshr.step.engine.common.dto;

import com.fanshr.step.engine.common.enums.ErrorCode;
import lombok.Data;
import lombok.ToString;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/16 14:03
 * @date : Modified at 2021/11/16 14:03
 */
@Data
@ToString
public class Result<T> {
    private boolean success;
    private T data;

    private String errorCode;
    private String errorMessage;
    private int showType;
    private String traceId;
    private String host;


    public Result(){}
    public Result(ErrorCode errorCode, T data) {
        this.success = false;
        this.errorCode = errorCode.code();
        this.errorMessage = errorCode.msg();
        this.data = data;
    }

}
