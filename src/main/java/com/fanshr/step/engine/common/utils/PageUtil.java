package com.fanshr.step.engine.common.utils;

import com.fanshr.step.engine.common.dto.PageBean;
import com.github.pagehelper.Page;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2021/11/15 17:23
 * @date : Modified at 2021/11/15 17:23
 */
public class PageUtil {
    public static int calculatePageCount(int totalCount, int pageSize) {
        int idealPage = totalCount / pageSize;
        int totalPage = (totalCount % pageSize == 0) ? idealPage : (idealPage + 1);
        return totalPage;
    }

    public static int calculateRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }

}
