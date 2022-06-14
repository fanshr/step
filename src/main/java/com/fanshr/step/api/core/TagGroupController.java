package com.fanshr.step.api.core;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fanshr.step.engine.common.dto.Condition;
import com.fanshr.step.engine.common.vo.PageVo;
import com.fanshr.step.engine.core.domain.entity.TagGroup;
import com.fanshr.step.engine.core.domain.vo.TagGroupVo;
import com.fanshr.step.engine.core.service.TagGroupService;
import com.fanshr.step.utils.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 权限组表 前端控制器
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/core/tagGroup")
@ResponseResult
@Slf4j
public class TagGroupController {
    @Autowired
    TagGroupService tagGroupService;
    



    @GetMapping("getAll")
    public List<TagGroup> getAll() {
        return tagGroupService.list();
    }
    @PostMapping("getList")
    public List<TagGroup> getList(@RequestBody TagGroup tagGroup) {
        LambdaQueryWrapper<TagGroup> wrapper = new LambdaQueryWrapper<>();
        // wrapper.eq(StringUtil.isNotBlank(tagGroup.getSelectName()), TagGroup::getSelectName, tagGroup.getSelectName());

        return tagGroupService.list(wrapper);
    }

    @GetMapping("getOne")
    public TagGroup getOne(Integer id) {
        return tagGroupService.getById(id);
    }



    @PostMapping("queryAll")
    public PageVo<TagGroup> queryAll(@RequestParam Map<String, Object> params) {

        IPage<TagGroup> page = tagGroupService.page(new PageVo<TagGroup>().getPage(params),
                new QueryWrapper<>());
        return new PageVo<>(page);
    }

    @PostMapping("queryList")
    public PageVo<TagGroup> queryList(@RequestBody Condition<TagGroup> condition) {



        LambdaQueryWrapper<TagGroup> wrapper = new LambdaQueryWrapper<>();
        TagGroup tagGroup = condition.getPayload();
        // wrapper.eq(StringUtil.isNotBlank(tagGroup.getSelectName()), TagGroup::getSelectName, tagGroup.getSelectName());
        IPage<TagGroup> page = tagGroupService.page(new PageVo<TagGroup>().getPage(condition),
                wrapper);
        return new PageVo<>(page);
    }

    @PostMapping("add")
    public void add(@RequestBody TagGroup tagGroup) {
        tagGroupService.save(tagGroup);
    }

    @PostMapping("modify")
    public void modify(@RequestBody TagGroup tagGroup) {
        LambdaUpdateWrapper<TagGroup> wrapper = new LambdaUpdateWrapper();
        // wrapper.eq(tagGroup.getId() != null, TagGroup::getId, tagGroup.getId());
        // wrapper.set(StringUtil.isNotBlank(tagGroup.getPinyin()), TagGroup::getPinyin, tagGroup.getPinyin());
        tagGroupService.update(wrapper);
    }

    @PostMapping("remove")
    public void remove(Integer id) {
        tagGroupService.removeById(id);
    }

    @GetMapping("/list/{typeId}")
    public List<TagGroupVo> listByTypeId(@PathVariable("typeId") Integer typeId){

        return tagGroupService.listByTypeId(typeId);
    }

    @GetMapping("/info/{id}")
    public TagGroupVo info(@PathVariable("id") Integer id){

        return tagGroupService.findTagById(id);
    }

}
