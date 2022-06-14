package com.fanshr.step.engine.question.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanshr.step.engine.core.dao.TagMapper;
import com.fanshr.step.engine.core.domain.dto.TagDto;
import com.fanshr.step.engine.core.domain.entity.Tag;
import com.fanshr.step.engine.core.domain.enums.SelectEnum;
import com.fanshr.step.engine.core.domain.vo.QuestionTagVo;
import com.fanshr.step.engine.mode.dao.SelectOptionMapper;
import com.fanshr.step.engine.mode.domain.dto.SelectOptionDto;
import com.fanshr.step.engine.mode.domain.entity.SelectOption;
import com.fanshr.step.engine.question.dao.QuestionAnswerMapper;
import com.fanshr.step.engine.question.dao.QuestionMapper;
import com.fanshr.step.engine.question.dao.QuestionTitleMapper;
import com.fanshr.step.engine.question.dao.TagQuestionMapper;
import com.fanshr.step.engine.question.domain.dto.QuestionAnswerDto;
import com.fanshr.step.engine.question.domain.dto.QuestionDto;
import com.fanshr.step.engine.question.domain.dto.QuestionTitleDto;
import com.fanshr.step.engine.question.domain.entity.Question;
import com.fanshr.step.engine.question.domain.entity.QuestionAnswer;
import com.fanshr.step.engine.question.domain.entity.QuestionTitle;
import com.fanshr.step.engine.question.domain.entity.TagQuestion;
import com.fanshr.step.engine.question.domain.vo.QuestionVo;
import com.fanshr.step.engine.question.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 题目详情表 服务实现类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Autowired
    private QuestionTitleMapper questionTitleMapper;
    @Autowired
    private QuestionAnswerMapper questionAnswerMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private TagQuestionMapper tagQuestionMapper;
    @Autowired
    private SelectOptionMapper selectOptionMapper;


    @Override
    public List<QuestionTagVo> listByTagId(Integer tagId) {

        // Tag tag = tagMapper.selectById(tagId);
        // QuestionTagVo questionTagVo = new QuestionTagVo();
        // if (tag != null) {
        //     BeanUtils.copyProperties(tag, questionTagVo);
        //
        //     List<TagQuestion> tagQuestionList =
        //             tagQuestionMapper.selectList(new LambdaQueryWrapper<TagQuestion>().eq(TagQuestion::getTagId,
        //                     tagId));
        //     List<Integer> questionIdList =
        //             tagQuestionList.stream().map(TagQuestion::getQuestionId).collect(Collectors.toList());
        //     List<Question> questionList = baseMapper.selectBatchIds(questionIdList);
        //
        //     List<QuestionDto> questionDtoList = questionList.stream().map(item -> {
        //         QuestionDto questionDto = new QuestionDto();
        //         BeanUtils.copyProperties(item, questionDto);
        //         return questionDto;
        //     }).collect(Collectors.toList());
        //
        //     questionTagVo.setQuestionDtoList(questionDtoList);
        // }
        return null;
    }

    @Override
    public QuestionVo info(Integer id) {
        Question question = baseMapper.selectById(id);
        QuestionVo questionVo = new QuestionVo();
        if (question != null) {
            BeanUtils.copyProperties(question, questionVo);
            // 标签体系类别
            SelectOptionDto tagSelectOption = selectOptionMapper.findByMarkAndValue(SelectEnum.TAG.code(),
                    question.getTypeId());

            questionVo.setTagSelectOption(tagSelectOption);

            // 题目类别
            SelectOptionDto questionSelectOption = selectOptionMapper.findByMarkAndValue(SelectEnum.QUESTION.code(),
                    question.getCategoryId());

            questionVo.setQuestionSelectOption(questionSelectOption);

            // 标签集合
            List<TagQuestion> tagQuestionList =
                    tagQuestionMapper.selectList(new LambdaQueryWrapper<TagQuestion>().eq(TagQuestion::getQuestionId,
                            question.getId()));

            List<Integer> tagIdList = tagQuestionList.stream().map(TagQuestion::getTagId).collect(Collectors.toList());
            List<Tag> tagList = tagMapper.selectBatchIds(tagIdList);
            List<TagDto> tagDtoList = tagList.stream().map(item -> {
                TagDto tagDto = new TagDto();
                BeanUtils.copyProperties(item, tagDto);
                return tagDto;

            }).collect(Collectors.toList());

            questionVo.setTagDtoList(tagDtoList);

            // 其他题目描述
            List<QuestionTitle> questionTitleList =
                    questionTitleMapper.selectList(new LambdaQueryWrapper<QuestionTitle>().eq(QuestionTitle::getMainId,
                            question.getId()));

            List<QuestionTitleDto> questionTitleDtoList = questionTitleList.stream().map(item -> {
                QuestionTitleDto questionTitleDto = new QuestionTitleDto();
                BeanUtils.copyProperties(item, questionTitleDto);
                return questionTitleDto;
            }).collect(Collectors.toList());
            questionVo.setQuestionTitleDtoList(questionTitleDtoList);

            // 回答列表
            List<QuestionAnswer> questionAnswerList =
                    questionAnswerMapper.selectList(new LambdaQueryWrapper<QuestionAnswer>().eq(QuestionAnswer::getMainId, question.getId()));

            List<QuestionAnswerDto> questionAnswerDtoList = questionAnswerList.stream().map(item -> {
                QuestionAnswerDto questionAnswerDto = new QuestionAnswerDto();
                BeanUtils.copyProperties(item, questionAnswerDto);
                return questionAnswerDto;
            }).collect(Collectors.toList());

            questionVo.setQuestionAnswerDtoList(questionAnswerDtoList);

            // 参考回答
            questionVo.setQuestionAnswerDto(questionAnswerDtoList.get(0));
        }
        return questionVo;
    }
}
