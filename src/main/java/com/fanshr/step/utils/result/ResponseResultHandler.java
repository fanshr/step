package com.fanshr.step.utils.result;


import com.fanshr.step.engine.common.dto.Result;
import com.fanshr.step.engine.common.enums.ErrorCode;
import com.fanshr.step.engine.common.exception.IDeleteException;
import com.fanshr.step.engine.common.exception.IServiceException;
import com.fanshr.step.engine.common.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.io.IOException;

/**
 *
 * 全局异常处理以及返回数据的封装
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/4/30 11:44
 * @date : Modified at 2022/4/30 11:44
 */
@Slf4j
@RestController
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    public static final String RESPONSE_RESULT_ANN = "RESPONSE-RESULT-ANN";
    @Autowired
    HttpServletRequest request;

    /**
     * 是否去请求包含了包装注解标记，没有直接返回
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
       log.info("进入 supports...");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();

        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);

        return responseResultAnn != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<?
            extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        log.info("返回体重写处理...");
        return ResultUtil.success(body);
    }



    /**
     * 异常日志记录
     *
     * @param e
     */
    private void log(Exception e) {

        log.error("访问IP：{}--{}", request.getRemoteAddr(), request.getRemoteHost());
        log.error("报错API URL:{}", request.getRequestURL().toString());
        log.error("异常信息:{}\n{}", e.getMessage(),e.getStackTrace());
    }

    /**
     * 参数格式异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler({ConstraintViolationException.class, BindException.class, MethodArgumentNotValidException.class})
    protected Result methodArgumentNotValid(Exception exception) {
        log(exception);
        return ResultUtil.error(ErrorCode.PARAM_FORMAT_ERROR);
    }

    /**
     * 参数类型有误
     *
     * @param exception
     * @return
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    protected Result typeMismatch(Exception exception) {
        log(exception);
        return ResultUtil.error(ErrorCode.PARAM_TYPE_BIND_ERROR);
    }

    /**
     * 参数缺失异常，@RequestParam的require属性校验失败
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected Result missingServletRequestParameter(MissingServletRequestParameterException exception) {
        log(exception);
        return ResultUtil.error(ErrorCode.PARAM_NOT_COMPLETE);
    }

    /**
     * 不支持的请求类型
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected Result httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception) {
        log(exception);
        return ResultUtil.error(ErrorCode.UNSUPPORTED_METHOD);
    }


    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    protected Result handleValidationException(ValidationException exception) {
        log(exception);
        return ResultUtil.error(ErrorCode.PARAM_VALIDATION_ERROR, exception.getCause().getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerNoFoundException(Exception exception) {
        log(exception);
        return ResultUtil.error(ErrorCode.PATH_NOT_EXIST, "路径不存在，请检查路径是否正确");

    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException exception) {
        log(exception);
        return ResultUtil.error(ErrorCode.DUPLICATE_KEY_CODE, "数据重复，请检查后提交");
    }

    /**
     * 业务层异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(IServiceException.class)
    protected Result serviceException(IServiceException exception) {
        log(exception);
        return ResultUtil.error(ErrorCode.ERROR, exception.getMessage());
    }

    /**
     * 删除异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(IDeleteException.class)
    protected Result serviceException(IDeleteException exception) {
        log(exception);
        return ResultUtil.error(ErrorCode.DELETE_REFUSED, exception.getMessage());
    }


    /**
     * 其他异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler({HttpClientErrorException.class, IOException.class, Exception.class})
    protected Result commonException(Exception exception) {
        log(exception);
        return ResultUtil.error(ErrorCode.ERROR);
    }


// TODO: @Valid校验参数缺失，类型不匹配异常的处理
}
