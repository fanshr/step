package com.fanshr.step.api.question;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fanshr.step.engine.common.dto.Condition;
import com.fanshr.step.engine.common.vo.PageVo;
import com.fanshr.step.engine.core.domain.vo.QuestionTagVo;
import com.fanshr.step.engine.question.domain.entity.Question;
import com.fanshr.step.engine.question.domain.vo.QuestionVo;
import com.fanshr.step.engine.question.service.QuestionService;
import com.fanshr.step.utils.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 题目详情表 前端控制器
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/question/question")
@ResponseResult
@Slf4j
public class QuestionController {


    @Autowired
    private QuestionService questionService;



    @GetMapping("getAll")
    public List<Question> getAll() {
        return questionService.list();
    }
    @PostMapping("getList")
    public List<Question> getList(@RequestBody Question question) {
        LambdaQueryWrapper<Question> wrapper = new LambdaQueryWrapper<>();
        // wrapper.eq(StringUtil.isNotBlank(question.getSelectName()), Question::getSelectName, question.getSelectName());

        return questionService.list(wrapper);
    }

    @GetMapping("getOne")
    public Question getOne(Integer id) {
        return questionService.getById(id);
    }



    @PostMapping("queryAll")
    public PageVo<Question> queryAll(@RequestParam Map<String, Object> params) {

        IPage<Question> page = questionService.page(new PageVo<Question>().getPage(params),
                new QueryWrapper<>());
        return new PageVo<>(page);
    }

    @PostMapping("queryList")
    public PageVo<Question> queryList(@RequestBody Condition<Question> condition) {



        LambdaQueryWrapper<Question> wrapper = new LambdaQueryWrapper<>();
        Question question = condition.getPayload();
        // wrapper.eq(StringUtil.isNotBlank(question.getSelectName()), Question::getSelectName, question.getSelectName());
        IPage<Question> page = questionService.page(new PageVo<Question>().getPage(condition),
                wrapper);
        return new PageVo<>(page);
    }

    @PostMapping("add")
    public void add(@RequestBody Question question) {
        questionService.save(question);
    }

    @PostMapping("modify")
    public void modify(@RequestBody Question question) {
        LambdaUpdateWrapper<Question> wrapper = new LambdaUpdateWrapper();
        // wrapper.eq(question.getId() != null, Question::getId, question.getId());
        // wrapper.set(StringUtil.isNotBlank(question.getPinyin()), Question::getPinyin, question.getPinyin());
        questionService.update(wrapper);
    }

    @PostMapping("remove")
    void remove(Integer id) {
        questionService.removeById(id);
    }


    @GetMapping("/list/{tagId}")
    public List<QuestionTagVo> listByTagId(@PathVariable("tagId") Integer tagId) {
        return questionService.listByTagId(tagId);

    }

    @GetMapping("info/{id}")
    public QuestionVo info(@PathVariable("id") Integer id) {
        return questionService.info(id);
    }
}
