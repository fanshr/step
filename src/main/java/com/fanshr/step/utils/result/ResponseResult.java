package com.fanshr.step.utils.result;

import java.lang.annotation.*;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/4/30 11:30
 * @date : Modified at 2022/4/30 11:30
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
