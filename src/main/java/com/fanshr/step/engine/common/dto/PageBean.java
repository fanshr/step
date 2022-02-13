package com.fanshr.step.engine.common.dto;

import lombok.Data;

import java.util.List;

/**
 *
 * 用于controller层中封装分页对象及数据，回传至前端
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/3 22:29
 * @date : Modified at 2022/2/3 22:29
 */
@Data
public class PageBean<T> {
    private List<T> list;
    private long total;

    public PageBean() {
    }

    public PageBean(List<T> list, long total) {
        this.list = list;
        this.total = total;
    }
}
