package com.fanshr.step.engine.mode.service;

import com.fanshr.step.engine.common.vo.PageVo;
import com.fanshr.step.engine.mode.domain.entity.SelectItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 独立选择框字段条目 服务类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
public interface SelectItemService extends IService<SelectItem> {

    PageVo<SelectItem> queryPage(Map<String, Object> params);
}
