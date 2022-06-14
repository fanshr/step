package com.fanshr.step.engine.mode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanshr.step.engine.mode.domain.dto.SelectOptionDto;
import com.fanshr.step.engine.mode.domain.entity.Select;
import com.fanshr.step.engine.mode.domain.entity.SelectOption;
import com.fanshr.step.engine.mode.dao.SelectMapper;
import com.fanshr.step.engine.mode.dao.SelectOptionMapper;
import com.fanshr.step.engine.mode.service.SelectService;
import com.fanshr.step.engine.mode.domain.vo.SelectVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 公用选择框字段信息 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Service
public class SelectServiceImpl extends ServiceImpl<SelectMapper, Select> implements SelectService {

    @Autowired
    SelectOptionMapper selectOptionMapper;
    @Override
    public SelectVo findDetailById(Integer id) {
        Select select = this.baseMapper.selectById(id);
        SelectVo selectVo = new SelectVo();
        if (select != null) {
            BeanUtils.copyProperties(select,selectVo);

            List<SelectOption> selectOptionList =
                    selectOptionMapper.selectList(new LambdaQueryWrapper<SelectOption>().eq(SelectOption::getMainId,
                            id));
            List<SelectOptionDto> selectOptionDtoList = selectOptionList.stream().map(item -> {
                SelectOptionDto selectOptionDto = new SelectOptionDto();
                BeanUtils.copyProperties(item, selectOptionDto);
                return selectOptionDto;
            }).collect(Collectors.toList());
            selectVo.setSelectOptionDtoList(selectOptionDtoList);


        }

        return selectVo;
    }
}
