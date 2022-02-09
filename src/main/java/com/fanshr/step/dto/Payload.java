package com.fanshr.step.dto;

import lombok.Data;

import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/3 22:29
 * @date : Modified at 2022/2/3 22:29
 */
@Data
public class Payload {
    private List list;
    private int current;
    private int pageSize;
    private int total;
}
