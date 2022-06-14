package com.fanshr.step.api.core;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fanshr.step.engine.common.dto.Condition;
import com.fanshr.step.engine.common.vo.PageVo;
import com.fanshr.step.engine.core.domain.entity.Tag;
import com.fanshr.step.engine.core.service.TagService;
import com.fanshr.step.utils.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/core/tag")
@ResponseResult
@Slf4j
public class TagController {

    @Autowired
    private TagService tagService;



    @GetMapping("getAll")
    public List<Tag> getAll() {
        return tagService.list();
    }
    @PostMapping("getList")
    public List<Tag> getList(@RequestBody Tag tag) {
        LambdaQueryWrapper<Tag> wrapper = new LambdaQueryWrapper<>();
        // wrapper.eq(StringUtil.isNotBlank(tag.getSelectName()), Tag::getSelectName, tag.getSelectName());

        return tagService.list(wrapper);
    }

    @GetMapping("getOne")
    public Tag getOne(Integer id) {
        return tagService.getById(id);
    }



    @PostMapping("queryAll")
    public PageVo<Tag> queryAll(@RequestParam Map<String, Object> params) {

        IPage<Tag> page = tagService.page(new PageVo<Tag>().getPage(params),
                new QueryWrapper<>());
        return new PageVo<>(page);
    }

    @PostMapping("queryList")
    public PageVo<Tag> queryList(@RequestBody Condition<Tag> condition) {



        LambdaQueryWrapper<Tag> wrapper = new LambdaQueryWrapper<>();
        Tag tag = condition.getPayload();
        // wrapper.eq(StringUtil.isNotBlank(tag.getSelectName()), Tag::getSelectName, tag.getSelectName());
        IPage<Tag> page = tagService.page(new PageVo<Tag>().getPage(condition),
                wrapper);
        return new PageVo<>(page);
    }

    @PostMapping("add")
    public void add(@RequestBody Tag tag) {
        tagService.save(tag);
    }

    @PostMapping("modify")
    public void modify(@RequestBody Tag tag) {
        LambdaUpdateWrapper<Tag> wrapper = new LambdaUpdateWrapper();
        // wrapper.eq(tag.getId() != null, Tag::getId, tag.getId());
        // wrapper.set(StringUtil.isNotBlank(tag.getPinyin()), Tag::getPinyin, tag.getPinyin());
        tagService.update(wrapper);
    }

    @PostMapping("remove")
    void remove(Integer id) {
        tagService.removeById(id);
    }

}
