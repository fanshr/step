package com.fanshr.step.api.question;

import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.common.dto.PageBean;
import com.fanshr.step.engine.common.dto.Result;
import com.fanshr.step.engine.question.entity.QuestionItem;
import com.fanshr.step.engine.common.enums.ErrorCode;
import com.fanshr.step.engine.common.enums.StateEnum;
import com.fanshr.step.engine.question.service.QuestionItemService;
import com.fanshr.step.engine.common.utils.ParamUtil;
import com.fanshr.step.engine.common.utils.ResultUtil;
import com.fanshr.step.engine.question.utils.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/1 17:04
 * @date : Modified at 2022/2/1 17:04
 */

@RestController
@RequestMapping("/question/item/")
public class QuestionItemController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionItemController.class);


    @Autowired
    private QuestionItemService questionItemService;

    @GetMapping("getAll")
    public Result<PageBean> get(String title, String description, Integer id) {
        PageBean pageBean = new PageBean();

        QuestionItem condition = new QuestionItem();
        // int categoryId = ParamUtil.getInt(request, "categoryId");
        // if (categoryId > 0) {
        //     condition.setCategoryId(categoryId);
        // }
        // String tags = ParamUtil.getString(request, "tags");
        // if (tags != null) {
        //     condition.setTags(tags);
        // }
        try {
            condition.setTitle(StringUtil.toCondition(title));
            condition.setDescription(StringUtil.toCondition(description));
            condition.setId(id);
            Execution execution = questionItemService.get(condition);
            if (execution.getState() == StateEnum.SUCCESS.getState()) {
                pageBean.setList(execution.getList());
                pageBean.setTotal(execution.getTotal());
                return ResultUtil.success(pageBean);
            } else {
                return ResultUtil.error(execution.getStateInfo());
            }
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }


    }

    @PostMapping("list")
    public Result<PageBean> list(@RequestBody QuestionItem condition,
                                 @RequestParam(required = true, defaultValue = "1") Integer current,
                                 @RequestParam(required = true, defaultValue = "10") Integer pageSize) {
        logger.info("关键参数-->{}--{}--{}", current, pageSize, condition);

        try {
            condition.setTitle(StringUtil.toCondition(condition.getTitle()));
            condition.setDescription(StringUtil.toCondition(condition.getDescription()));
            Execution execution = questionItemService.list(condition, current, pageSize);
            if (execution.getState() == StateEnum.SUCCESS.getState()) {
                return ResultUtil.success(new PageBean(execution.getList(), execution.getTotal()));
            } else {
                return ResultUtil.error(execution.getStateInfo());
            }
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }

    }


    @GetMapping("getOne")
    public Result getOne(HttpServletRequest request) {
        QuestionItem questionItem = null;
        int id = ParamUtil.getInt(request, "id");

        try {
            questionItem = questionItemService.get(id);
            return ResultUtil.success(questionItem);
        } catch (Exception e) {
            return ResultUtil.error(ErrorCode.INNER_ERROR);
        }

    }


    @PostMapping("add")
    public Result add(@RequestBody QuestionItem questionItem) {

        if (questionItem != null) {
            try {
                Execution execution =
                        questionItemService.add(questionItem);
                if (execution.getState() == StateEnum.SUCCESS.getState()) {
                    return ResultUtil.success();
                } else {
                    return ResultUtil.error(execution.getStateInfo());
                }

            } catch (Exception e) {
                return ResultUtil.error(e.toString());
            }
        } else {
            return ResultUtil.error(ErrorCode.DATA_IS_NULL);
        }
    }


    @PostMapping("modify")
    public Result modify(@RequestBody QuestionItem questionItem) {


        if (questionItem != null && questionItem.getId() != null) {
            try {
                // interviewItem.setTitle(interviewItem.getTitle() == null ? null :
                //         URLDecoder.decode(interviewItem.getTitle(), "UTF-8"));
                // interviewItem.setDescription(interviewItem.getDescription() == null ? null :
                //         URLDecoder.decode(interviewItem.getDescription(), "UTF-8"));
                // interviewItem.setRemark(interviewItem.getRemark() == null ? null :
                //         URLDecoder.decode(interviewItem.getRemark(), "UTF-8"));

                Execution execution =
                        questionItemService.modify(questionItem);
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
            Execution execution = questionItemService.remove(id);
            if (execution.getState() == StateEnum.SUCCESS.getState()) {
                return ResultUtil.success();
            } else {
                return ResultUtil.error(execution.getStateInfo());
            }
        } else {
            return ResultUtil.error(ErrorCode.DATA_IS_NULL);
        }
    }


    @PostMapping("multiRemove")
    public Result multiRemove(@RequestBody Integer[] idList) {


        List<Integer> interviewItemIdList = Arrays.asList(idList);

        if (interviewItemIdList != null && interviewItemIdList.size() > 0) {
            Execution execution =
                    questionItemService.multiRemove(interviewItemIdList);
            if (execution.getState() == StateEnum.SUCCESS.getState()) {
                return ResultUtil.success();
            } else {
                return ResultUtil.error(execution.getStateInfo());
            }

        } else {
            return ResultUtil.error(ErrorCode.EMPTY);
        }
    }
}
