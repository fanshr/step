package com.fanshr.step.api.mode;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fanshr.step.engine.common.dto.Condition;
import com.fanshr.step.engine.common.vo.PageVo;
import com.fanshr.step.engine.mode.domain.entity.Select;
import com.fanshr.step.engine.mode.service.SelectOptionService;
import com.fanshr.step.engine.mode.service.SelectService;
import com.fanshr.step.engine.mode.domain.vo.SelectVo;
import com.fanshr.step.utils.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 公用选择框字段信息 前端控制器
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@RestController
@RequestMapping("/mode/select")
@ResponseResult
@Slf4j
public class SelectController {
    @Autowired
    private SelectService selectService;
    @Autowired
    private SelectOptionService selectOptionService;



    @GetMapping("getAll")
    public List<Select> getAll() {
        return selectService.list();
    }
    @PostMapping("getList")
    public List<Select> getList(@RequestBody Select select) {
        LambdaQueryWrapper<Select> wrapper = new LambdaQueryWrapper<>();
        // wrapper.eq(StringUtil.isNotBlank(select.getSelectName()), Select::getSelectName, select.getSelectName());

        return selectService.list(wrapper);
    }

    @GetMapping("getOne")
    public Select getOne(Integer id) {
        return selectService.getById(id);
    }

    @PostMapping("queryAll")
    public PageVo<Select> queryAll(@RequestParam Map<String, Object> params) {

        IPage<Select> page = selectService.page(new PageVo<Select>().getPage(params),
                new QueryWrapper<>());
        return new PageVo<>(page);
    }

    @PostMapping("queryList")
    public PageVo<Select> queryList(@RequestBody Condition<Select> condition) {



        LambdaQueryWrapper<Select> wrapper = new LambdaQueryWrapper<>();
        Select select = condition.getPayload();
        // wrapper.eq(StringUtil.isNotBlank(select.getSelectName()), Select::getSelectName, select.getSelectName());
        IPage<Select> page = selectService.page(new PageVo<Select>().getPage(condition),
                wrapper);
        return new PageVo<>(page);
    }

    @PostMapping("add")
    public void add(@RequestBody Select select) {
        selectService.save(select);
    }

    @PostMapping("modify")
    public void modify(@RequestBody Select select) {
        LambdaUpdateWrapper<Select> wrapper = new LambdaUpdateWrapper();
        // wrapper.eq(select.getId() != null, Select::getId, select.getId());
        // wrapper.set(StringUtil.isNotBlank(select.getPinyin()), Select::getPinyin, select.getPinyin());
        selectService.update(wrapper);
    }

    @PostMapping("remove")
    void remove(Integer id) {
        selectService.removeById(id);
    }




    @GetMapping("/info/{id}")
    public SelectVo info(@PathVariable("id") Integer id) {
        SelectVo selectVo = selectService.findDetailById(id);
        return selectVo;

    }















}
