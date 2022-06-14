package com.fanshr.step.engine.mode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fanshr.step.engine.common.utils.PageUtils;
import com.fanshr.step.engine.common.utils.Query;
import com.fanshr.step.engine.common.vo.PageVo;
import com.fanshr.step.engine.mode.domain.entity.SelectItem;
import com.fanshr.step.engine.mode.dao.SelectItemMapper;
import com.fanshr.step.engine.mode.service.SelectItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 独立选择框字段条目 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class SelectItemServiceImpl extends ServiceImpl<SelectItemMapper, SelectItem> implements SelectItemService {

    @Override
    public PageVo<SelectItem> queryPage(Map<String, Object> params) {

        IPage<SelectItem> page = this.page(new Query<SelectItem>().getPage(params), new QueryWrapper<SelectItem>());

        return new PageVo<>(page);
    }
}
