package com.fanshr.step.engine.common.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fanshr.step.engine.common.dto.Condition;
import com.fanshr.step.engine.common.utils.Constant;
import com.fanshr.step.engine.common.utils.SQLFilter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/6/12 21:42
 * @date : Modified at 2022/6/12 21:42
 */
public class PageVo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总记录数
     */
    private int total;
    /**
     * 每页记录数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页数
     */
    private int current;
    /**
     * 列表数据
     */
    private List<T> list;

    public PageVo() {
    }

    public PageVo(List<T> list, int total) {
        this.list = list;
        this.total = total;
    }
    /**
     * 分页
     * @param list        列表数据
     * @param total  总记录数
     * @param pageSize    每页记录数
     * @param current    当前页数
     */
    public PageVo(List<T> list, int total, int pageSize, int current) {
        this.list = list;
        this.total = total;
        this.pageSize = pageSize;
        this.current = current;
        this.totalPage = (int)Math.ceil((double) total /pageSize);
    }

    /**
     * 分页
     */
    public PageVo(IPage<T> page) {
        this.list = page.getRecords();
        this.total = (int)page.getTotal();
        this.pageSize = (int)page.getSize();
        this.current = (int)page.getCurrent();
        this.totalPage = (int)page.getPages();
    }

    public IPage<T> getPage(Condition<T> condition){
        Map<String, Object> params = new HashMap<>(3);
        params.put(Constant.CURRENT, condition.getCurrent());
        params.put(Constant.PAGE_SIZE, condition.getPageSize());
        return this.getPage(params);
    }

    public IPage<T> getPage(Map<String, Object> params) {
        return this.getPage(params, null, false);
    }

    public IPage<T> getPage(Map<String, Object> params, String defaultOrderField, boolean isAsc) {
        //分页参数
        long curPage = 1;
        long limit = 10;

        if(params.get(Constant.CURRENT) != null){
            curPage = Long.parseLong((String)params.get(Constant.CURRENT));
        }
        if(params.get(Constant.PAGE_SIZE) != null){
            limit = Long.parseLong((String)params.get(Constant.PAGE_SIZE));
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //分页参数
        params.put(Constant.CURRENT, page);

        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String orderField = SQLFilter.sqlInject((String)params.get(Constant.ORDER_FIELD));
        String order = (String)params.get(Constant.ORDER);


        //前端字段排序
        if(StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)){
            if(Constant.ASC.equalsIgnoreCase(order)) {
                return  page.addOrder(OrderItem.asc(orderField));
            }else {
                return page.addOrder(OrderItem.desc(orderField));
            }
        }

        //没有排序字段，则不排序
        if(StringUtils.isBlank(defaultOrderField)){
            return page;
        }

        //默认排序
        if(isAsc) {
            page.addOrder(OrderItem.asc(defaultOrderField));
        }else {
            page.addOrder(OrderItem.desc(defaultOrderField));
        }

        return page;
    }
}
