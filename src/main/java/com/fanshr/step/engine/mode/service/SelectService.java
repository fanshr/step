package com.fanshr.step.engine.mode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fanshr.step.engine.mode.domain.entity.Select;
import com.fanshr.step.engine.mode.domain.vo.SelectVo;

/**
 * <p>
 * 公用选择框字段信息 服务类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
public interface SelectService extends IService<Select> {

    SelectVo findDetailById(Integer id);
}
