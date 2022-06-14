package com.fanshr.step.api.mode;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fanshr.step.engine.common.dto.Condition;
import com.fanshr.step.engine.common.vo.PageVo;
import com.fanshr.step.engine.mode.domain.entity.SelectOption;
import com.fanshr.step.engine.mode.service.SelectOptionService;
import com.fanshr.step.engine.question.utils.StringUtil;
import com.fanshr.step.utils.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 公用选择框条目明细 前端控制器
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@RestController
@RequestMapping("/mode/selectOption")
@ResponseResult
@Slf4j
public class SelectOptionController {

    @Autowired
    private SelectOptionService selectOptionService;



    @GetMapping("getAll")
    public List<SelectOption> getAll() {
        return selectOptionService.list();
    }
    @PostMapping("getList")
    public List<SelectOption> getList(@RequestBody SelectOption selectOption) {
        LambdaQueryWrapper<SelectOption> wrapper = new LambdaQueryWrapper<>();
        // wrapper.eq(StringUtil.isNotBlank(selectDetail.getSelectName()), SelectDetail::getSelectName, selectDetail.getSelectName());

        return selectOptionService.list(wrapper);
    }

    @GetMapping("getOne")
    public SelectOption getOne(Integer id) {
        return selectOptionService.getById(id);
    }



    @PostMapping("queryAll")
    public PageVo<SelectOption> queryAll(@RequestParam Map<String, Object> params) {

        IPage<SelectOption> page = selectOptionService.page(new PageVo<SelectOption>().getPage(params),
                new QueryWrapper<>());
        return new PageVo<>(page);
    }

    @PostMapping("queryList")
    public PageVo<SelectOption> queryList(@RequestBody Condition<SelectOption> condition) {



        LambdaQueryWrapper<SelectOption> wrapper = new LambdaQueryWrapper<>();
        SelectOption selectOption = condition.getPayload();
        wrapper.eq(StringUtil.isNotBlank(selectOption.getSelectName()), SelectOption::getSelectName, selectOption.getSelectName());
        IPage<SelectOption> page = selectOptionService.page(new PageVo<SelectOption>().getPage(condition),
                wrapper);
        return new PageVo<>(page);
    }

    @PostMapping("add")
    public void add(@RequestBody SelectOption selectOption) {
        selectOptionService.save(selectOption);
    }

    @PostMapping("modify")
    public void modify(@RequestBody SelectOption selectOption) {
        LambdaUpdateWrapper<SelectOption> wrapper = new LambdaUpdateWrapper();
        // wrapper.eq(selectDetail.getId() != null, SelectDetail::getId, selectDetail.getId());
        // wrapper.set(StringUtil.isNotBlank(selectDetail.getPinyin()), SelectDetail::getPinyin, selectDetail.getPinyin());
        selectOptionService.update(wrapper);
    }

    @PostMapping("remove")
    void remove(Integer id) {
        selectOptionService.removeById(id);
    }


    @GetMapping("/list/{mainId}")
    public List<SelectOption> listByMainId(@PathVariable("mainId") Integer mainId) {
        return selectOptionService.list(
                new LambdaQueryWrapper<SelectOption>().eq(mainId>0, SelectOption::getMainId, mainId)
        );
    }

}
