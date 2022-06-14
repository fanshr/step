package com.fanshr.step.engine.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/5/4 14:14
 * @date : Modified at 2022/5/4 14:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condition<T> {

    private Integer current =  1;
    private  Integer pageSize = 10;
    private T payload;
}
