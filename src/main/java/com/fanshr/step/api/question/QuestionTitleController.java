package com.fanshr.step.api.question;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fanshr.step.engine.common.dto.Condition;
import com.fanshr.step.engine.common.vo.PageVo;
import com.fanshr.step.engine.question.domain.entity.QuestionTitle;
import com.fanshr.step.engine.question.service.QuestionTitleService;
import com.fanshr.step.utils.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 题目明细表 前端控制器
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/question/title")
@ResponseResult
@Slf4j
public class QuestionTitleController {

    @Autowired
    private QuestionTitleService questionTitleService;



    @GetMapping("getAll")
    public List<QuestionTitle> getAll() {
        return questionTitleService.list();
    }
    @PostMapping("getList")
    public List<QuestionTitle> getList(@RequestBody QuestionTitle questionTitle) {
        LambdaQueryWrapper<QuestionTitle> wrapper = new LambdaQueryWrapper<>();
        // wrapper.eq(StringUtil.isNotBlank(questionTitle.getSelectName()), QuestionTitle::getSelectName, questionTitle.getSelectName());

        return questionTitleService.list(wrapper);
    }

    @GetMapping("getOne")
    public QuestionTitle getOne(Integer id) {
        return questionTitleService.getById(id);
    }



    @PostMapping("queryAll")
    public PageVo<QuestionTitle> queryAll(@RequestParam Map<String, Object> params) {

        IPage<QuestionTitle> page = questionTitleService.page(new PageVo<QuestionTitle>().getPage(params),
                new QueryWrapper<>());
        return new PageVo<>(page);
    }

    @PostMapping("queryList")
    public PageVo<QuestionTitle> queryList(@RequestBody Condition<QuestionTitle> condition) {



        LambdaQueryWrapper<QuestionTitle> wrapper = new LambdaQueryWrapper<>();
        QuestionTitle questionTitle = condition.getPayload();
        // wrapper.eq(StringUtil.isNotBlank(questionTitle.getSelectName()), QuestionTitle::getSelectName, questionTitle.getSelectName());
        IPage<QuestionTitle> page = questionTitleService.page(new PageVo<QuestionTitle>().getPage(condition),
                wrapper);
        return new PageVo<>(page);
    }

    @PostMapping("add")
    public void add(@RequestBody QuestionTitle questionTitle) {
        questionTitleService.save(questionTitle);
    }

    @PostMapping("modify")
    public void modify(@RequestBody QuestionTitle questionTitle) {
        LambdaUpdateWrapper<QuestionTitle> wrapper = new LambdaUpdateWrapper();
        // wrapper.eq(questionTitle.getId() != null, QuestionTitle::getId, questionTitle.getId());
        // wrapper.set(StringUtil.isNotBlank(questionTitle.getPinyin()), QuestionTitle::getPinyin, questionTitle.getPinyin());
        questionTitleService.update(wrapper);
    }

    @PostMapping("remove")
    void remove(Integer id) {
        questionTitleService.removeById(id);
    }

}
