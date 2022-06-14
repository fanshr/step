package com.fanshr.step.api.question;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.common.dto.PageBean;
import com.fanshr.step.engine.common.dto.Result;
import com.fanshr.step.engine.common.enums.ErrorCode;
import com.fanshr.step.engine.common.enums.StateEnum;
import com.fanshr.step.engine.common.utils.ParamUtil;
import com.fanshr.step.engine.common.utils.ResultUtil;
import com.fanshr.step.engine.question.domain.entity.QuestionTag;
import com.fanshr.step.engine.question.service.QuestionTagService;
import com.fanshr.step.engine.question.utils.StringUtil;
import com.fanshr.step.utils.result.ResponseResult;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/1 17:04
 * @date : Modified at 2022/2/1 17:04
 */

@RestController
@RequestMapping("/question/tag/")
@Slf4j
public class QuestionTagController {


    @Autowired
    private QuestionTagService questionTagService;

    @GetMapping("getAll")
    public Result<PageBean> getAll(String title, String description,Integer id) {
        PageBean pageBean = new PageBean();
        try {
            QuestionTag condition = new QuestionTag();
            condition.setTitle(StringUtil.toCondition(title));
            condition.setDescription(StringUtil.toCondition(description));
            condition.setId(id);
            List<QuestionTag> questionTagList = questionTagService.get(condition);
            pageBean.setList(questionTagList);
            pageBean.setTotal(questionTagList.size());
            return ResultUtil.success(pageBean);
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }

    // @GetMapping("checkRepeat")
    // public Result checkRepeat(String title) {
    //
    // }




    @ResponseResult
    @GetMapping("getOne")
    public QuestionTag getOne(HttpServletRequest request) {
        QuestionTag questionTag = null;
        int id = ParamUtil.getInt(request, "id");

        return questionTagService.get(id);

        // try {
        //     tag =
        //     return ResultUtil.success(tag);
        // } catch (Exception e) {
        //     return ResultUtil.error(ErrorCode.INNER_ERROR);
        // }

    }


    @PostMapping("add")
    public Result add(@RequestBody QuestionTag questionTag) {

        if (questionTag != null) {
            try {
                Execution execution =
                        questionTagService.add(questionTag);
                if (execution.getState() == StateEnum.SUCCESS.getState()) {
                    return ResultUtil.success();
                } else {
                    return ResultUtil.error(execution.getStateInfo());
                }

            } catch (Exception e) {
                return ResultUtil.error(e.toString());
            }
        } else {
            return ResultUtil.error(ErrorCode.PARAM_IS_BLANK);
        }
    }


    @PostMapping("modify")
    public Result modify(@RequestBody QuestionTag questionTag) {


        if (questionTag != null && questionTag.getId() != null) {
            try {
                // interviewTag.setTitle(interviewTag.getTitle() == null ? null :
                //         URLDecoder.decode(interviewTag.getTitle(), "UTF-8"));
                // interviewTag.setDescription(interviewTag.getDescription() == null ? null :
                //         URLDecoder.decode(interviewTag.getDescription(), "UTF-8"));
                // interviewTag.setRemark(interviewTag.getRemark() == null ? null :
                //         URLDecoder.decode(interviewTag.getRemark(), "UTF-8"));

                Execution execution =
                        questionTagService.modify(questionTag);
                if (execution.getState() == StateEnum.SUCCESS.getState()) {
                    return ResultUtil.success();
                } else {
                    return ResultUtil.error(execution.getStateInfo());
                }

            } catch (Exception e) {
                return ResultUtil.error(e.toString());
            }
        } else {
            return ResultUtil.error(ErrorCode.ID_IS_NULL);
        }
    }

    @PostMapping("remove")
    public Result remove(Integer id) {
        if (id != null && id > 0) {
            Execution execution = questionTagService.remove(id);
            if (execution.getState() == StateEnum.SUCCESS.getState()) {
                return ResultUtil.success();
            } else {
                return ResultUtil.error(execution.getStateInfo());
            }
        } else {
            return ResultUtil.error(ErrorCode.PARAM_IS_BLANK);
        }
    }


    @PostMapping("multiRemove")
    public Result multiRemove(String interviewTagIdListStr) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Integer.class);

        List<Integer> interviewTagIdList = null;

        try {
            interviewTagIdList = mapper.readValue(interviewTagIdListStr, javaType);
        } catch (IOException e) {

            return ResultUtil.error(ErrorCode.PARAM_FORMAT_ERROR, e.toString());
        }

        if (interviewTagIdList != null && interviewTagIdList.size() > 0) {
            Execution execution =
                    questionTagService.multiRemove(interviewTagIdList);
            if (execution.getState() == StateEnum.SUCCESS.getState()) {
                return ResultUtil.success();
            } else {
                return ResultUtil.error(execution.getStateInfo());
            }

        } else {
            return ResultUtil.error(ErrorCode.PARAM_IS_EMPTY);
        }
    }

    @PostMapping("test1")
    public Result test1(Long id) {
        System.out.println("测试Long id-->" + id);
        return ResultUtil.success(id);

    }

    @PostMapping("test2")
    public Result test2(@RequestBody List<Long> idList) {
        System.out.println("测试Long id-->" + JSON.toJSONString(idList));
        return ResultUtil.success(idList);
    }
}
