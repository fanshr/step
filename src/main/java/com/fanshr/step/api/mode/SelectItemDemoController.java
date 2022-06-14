package com.fanshr.step.api.mode;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fanshr.step.engine.common.dto.Condition;
import com.fanshr.step.engine.common.utils.R;
import com.fanshr.step.engine.common.vo.PageVo;
import com.fanshr.step.engine.mode.domain.entity.SelectItem;
import com.fanshr.step.engine.mode.service.SelectItemService;
import com.fanshr.step.utils.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 独立选择框字段条目 前端控制器
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@RestController
@RequestMapping("/mode/select-item/demo/")
@Slf4j
public class SelectItemDemoController {
    /**
     * /list
     * /info/{id}
     * /save
     * /update
     * /delete
     *
     * /getAll
     * /getList
     *
     * /getOne
     * /queryAll
     * /qureyList
     * /add
     * /modify
     * /remove
     *
     * 以下为参数的一些应用
     */
    @Autowired
    private SelectItemService selectItemService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String,Object> params){
        PageVo<SelectItem> page = selectItemService.queryPage(params);
        return R.ok().put("page", page);

    }

    @ResponseResult
    @GetMapping("/query")
    public PageVo<SelectItem> query(@RequestBody Condition<SelectItem> condition) {
        IPage<SelectItem> page = selectItemService.page(new PageVo<SelectItem>().getPage(condition));
        return new PageVo<>(page);
    }

    @GetMapping("info/{id}")
    public SelectItem info(@PathVariable("id") Integer id) {

        return selectItemService.getById(id);
    }

    @PostMapping("list/{fieldId}")
    public List<SelectItem> listByFieldId(@RequestParam Map<String, Object> params,
                                            @PathVariable("fieldId") Integer fieldId) {
        return selectItemService.list();
    }

    

/*
*
* 以下为通用的一些方法
* */


    @GetMapping("getAll")
    public List<SelectItem> getAll() {
        return selectItemService.list();
    }
    @PostMapping("getList")
    public List<SelectItem> getList(@RequestBody SelectItem selectItem) {
        LambdaQueryWrapper<SelectItem> wrapper = new LambdaQueryWrapper<>();
        // wrapper.eq(StringUtil.isNotBlank(selectItem.getSelectName()), SelectItem::getSelectName, selectItem.getSelectName());

        return selectItemService.list(wrapper);
    }

    @GetMapping("getOne")
    public SelectItem getOne(Integer id) {
        return selectItemService.getById(id);
    }



    @PostMapping("queryAll")
    public PageVo<SelectItem> queryAll(@RequestParam Map<String, Object> params) {

        IPage<SelectItem> page = selectItemService.page(new PageVo<SelectItem>().getPage(params),
                new QueryWrapper<>());
        return new PageVo<>(page);
    }

    @PostMapping("queryList")
    public PageVo<SelectItem> queryList(@RequestBody Condition<SelectItem> condition) {



        LambdaQueryWrapper<SelectItem> wrapper = new LambdaQueryWrapper<>();
        SelectItem selectItem = condition.getPayload();
        // wrapper.eq(StringUtil.isNotBlank(selectItem.getSelectName()), SelectItem::getSelectName, selectItem.getSelectName());
        IPage<SelectItem> page = selectItemService.page(new PageVo<SelectItem>().getPage(condition),
                wrapper);
        return new PageVo<>(page);
    }

    @PostMapping("add")
    public void add(@RequestBody SelectItem selectItem) {
        selectItemService.save(selectItem);
    }

    @PostMapping("modify")
    public void modify(@RequestBody SelectItem selectItem) {
        LambdaUpdateWrapper<SelectItem> wrapper = new LambdaUpdateWrapper();
        // wrapper.eq(selectItem.getId() != null, SelectItem::getId, selectItem.getId());
        // wrapper.set(StringUtil.isNotBlank(selectItem.getPinyin()), SelectItem::getPinyin, selectItem.getPinyin());
        selectItemService.update(wrapper);
    }

    @PostMapping("remove")
    void remove(Integer id) {
        selectItemService.removeById(id);
    }


}
