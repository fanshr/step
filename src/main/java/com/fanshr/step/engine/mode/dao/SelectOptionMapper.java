package com.fanshr.step.engine.mode.dao;

import com.fanshr.step.engine.mode.domain.dto.SelectOptionDto;
import com.fanshr.step.engine.mode.domain.entity.SelectOption;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 公用选择框条目明细 Mapper 接口
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Mapper
public interface SelectOptionMapper extends BaseMapper<SelectOption> {
    @Select("select t1.id,t1.select_name,t1.select_value,t1.checked,t1.canceled,t1.pinyin,t1.display " +
            "from mode_select t0 left join mode_select_option t1 on t0.id = t1.main_id " +
            "where t0.mark = ? and t1.select_value =?  ")
    public SelectOptionDto findByMarkAndValue(String mark, Integer value);




}
