package com.fanshr.step.api.question;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fanshr.step.engine.common.dto.Condition;
import com.fanshr.step.engine.common.vo.PageVo;
import com.fanshr.step.engine.question.domain.entity.QuestionAnswer;
import com.fanshr.step.engine.question.service.QuestionAnswerService;
import com.fanshr.step.utils.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 回答详情表 前端控制器
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/question/answer")
@ResponseResult
@Slf4j
public class QuestionAnswerController {

    @Autowired
    private QuestionAnswerService questionAnswerService;



    @GetMapping("getAll")
    public List<QuestionAnswer> getAll() {
        return questionAnswerService.list();
    }
    @PostMapping("getList")
    public List<QuestionAnswer> getList(@RequestBody QuestionAnswer questionAnswer) {
        LambdaQueryWrapper<QuestionAnswer> wrapper = new LambdaQueryWrapper<>();
        // wrapper.eq(StringUtil.isNotBlank(questionAnswer.getSelectName()), QuestionAnswer::getSelectName, questionAnswer.getSelectName());

        return questionAnswerService.list(wrapper);
    }

    @GetMapping("getOne")
    public QuestionAnswer getOne(Integer id) {
        return questionAnswerService.getById(id);
    }



    @PostMapping("queryAll")
    public PageVo<QuestionAnswer> queryAll(@RequestParam Map<String, Object> params) {

        IPage<QuestionAnswer> page = questionAnswerService.page(new PageVo<QuestionAnswer>().getPage(params),
                new QueryWrapper<>());
        return new PageVo<>(page);
    }

    @PostMapping("queryList")
    public PageVo<QuestionAnswer> queryList(@RequestBody Condition<QuestionAnswer> condition) {



        LambdaQueryWrapper<QuestionAnswer> wrapper = new LambdaQueryWrapper<>();
        QuestionAnswer questionAnswer = condition.getPayload();
        // wrapper.eq(StringUtil.isNotBlank(questionAnswer.getSelectName()), QuestionAnswer::getSelectName, questionAnswer.getSelectName());
        IPage<QuestionAnswer> page = questionAnswerService.page(new PageVo<QuestionAnswer>().getPage(condition),
                wrapper);
        return new PageVo<>(page);
    }

    @PostMapping("add")
    public void add(@RequestBody QuestionAnswer questionAnswer) {
        questionAnswerService.save(questionAnswer);
    }

    @PostMapping("modify")
    public void modify(@RequestBody QuestionAnswer questionAnswer) {
        LambdaUpdateWrapper<QuestionAnswer> wrapper = new LambdaUpdateWrapper();
        // wrapper.eq(questionAnswer.getId() != null, QuestionAnswer::getId, questionAnswer.getId());
        // wrapper.set(StringUtil.isNotBlank(questionAnswer.getPinyin()), QuestionAnswer::getPinyin, questionAnswer.getPinyin());
        questionAnswerService.update(wrapper);
    }

    @PostMapping("remove")
    void remove(Integer id) {
        questionAnswerService.removeById(id);
    }



}
