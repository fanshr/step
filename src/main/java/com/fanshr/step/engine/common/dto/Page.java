package com.fanshr.step.engine.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 分页信息表
 *
 * 一般用于service层，接收参数之后，计算分页相关属性
 * 与PageHelper 的 Page对象功能相同，引入PageHelper后废弃
 * @author : LiuYJ	
 * @date : Created at 2022/2/10 15:39
 * @date : Modified at 2022/2/10 15:39
 * @version : v1.0       	
 */
@Data
@ToString
public class Page implements Serializable {

    public Page() {
    }


    public Page(int total, int current) {
        this.total = total;
        this.current = current;
        int pages =1;
        if (total>=0){
            pages= total / getPageSize();
            pages =  (total % pageSize == 0) ? pages
                    : pages + 1;
        }
        this.totalPage = pages;

        this.startRow = (this.current - 1) * pageSize;
        this.isFirstPage = current ==1;
        this.isLastPage = current == pages;
        this.hasNextPage = !this.isLastPage;
        this.hasPreviousPage = !this.isFirstPage;
    }

    /**
     * 默认每页条数
     */
    private static final int defaultSize = 10;
    private static final long serialVersionUID = -2331932270369142252L;
    /**
     * 当前页面
     */
    private int current = 1;

    /**
     * 每页显示数量
     */
    private int pageSize = 10;

    /**
     * 总记录条数
     */
    private int total;

    /**
     * 总页数
     */
    private int totalPage;



    /**
     * 当前页面开始的行数
     */
    private int startRow;

    /**
     * 是否首页
     */
    private boolean isFirstPage;
    /**
     * 是否尾页
     */
    private boolean isLastPage;
    /**
     * 是否存在前一页
     */
    private boolean hasPreviousPage;

    /**
     * 是否存在下一页
     */
    private boolean hasNextPage;




}
