package com.fanshr.step.utils;


import com.fanshr.step.dto.Result;
import com.fanshr.step.enums.ErrorCode;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2020/11/16 01:55
 * @date : Modified at 2020/11/16 01:55
 */
public class ResultUtil {

    /**
     * 默认成功
     *
     * @return 消息
     */
    public static <T> Result<T> success() {
        return success(null, null);
    }

    /**
     * 成功且带数据
     *
     * @param payload 负载
     * @param <T>     类型
     * @return 消息
     */
    public static <T> Result<T> success(T payload) {
        return success(null, payload);
    }

    /**
     * 成功且带信息
     *
     * @param msg 消息
     * @param <T> 泛型
     * @return 消息
     */
    public static <T> Result<T> success(String msg) {
        return success(msg, null);
    }

    /**
     * 成功且带信息带数据
     *
     * @param msg     消息
     * @param payload 负载
     * @param <T>     泛型
     * @return 消息
     */
    public static <T> Result<T> success(String msg, T payload) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setErrorCode(ErrorCode.SUCCESS.getState());
        msg = msg == null ? ErrorCode.SUCCESS.getMsg() : msg;
        result.setErrorMessage(msg);
        result.setData(payload);
        return result;
    }

    /**
     * 默认失败
     *
     * @param <T> 泛型
     * @return 消息
     */
    public static <T> Result<T> error() {
        return error(ErrorCode.ERROR);
    }

    /**
     * 失败且返回状态码
     *
     * @param code 错误码
     * @param <T>  泛型
     * @return 消息
     */
    public static <T> Result<T> error(ErrorCode code) {
        return error(code, null, null);
    }

    public static <T> Result<T> error(String msg) {
        return error(ErrorCode.ERROR, msg, null);
    }

    /**
     * 失败且带详细错误信息
     *
     * @param code 错误码
     * @param msg  消息
     * @return 消息
     */
    public static <T> Result<T> error(ErrorCode code, String msg) {
        return error(code, msg, null);
    }

    /**
     * 失败且带数据
     *
     * @param payload 负载
     * @param <T>     泛型
     * @return 消息
     */
    public static <T> Result<T> error(ErrorCode code, T payload) {
        return error(code, null, payload);
    }

    /**
     * 失败且带数据
     *
     * @param code    状态码
     * @param msg     消息
     * @param payload 负载
     * @param <T>     泛型
     * @return 消息
     */
    public static <T> Result<T> error(ErrorCode code, String msg, T payload) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setErrorCode(code.getState());
        msg = msg == null ? code.getMsg() : msg;
        result.setErrorMessage(msg);
        result.setData(payload);
        return result;
    }


    /**
     *
     * @param code
     * @param msg
     * @param showType
     *  0-不提示错误
     *  1-警告信息提示
     *  2-错误信息提示
     *  4-通知提示
     *  9-页面跳转
     *
     * @param traceId
     * @param host
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(ErrorCode code, String msg, int showType,String traceId,String host) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setErrorCode(code.getState());
        msg = msg == null ? code.getMsg() : msg;
        result.setErrorMessage(msg);
        result.setShowType(showType);
        result.setTraceId(traceId);
        result.setHost(host);
        return result;
    }

}
