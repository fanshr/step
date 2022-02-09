package com.fanshr.step.web;

import com.fanshr.step.dto.DataConstant;
import com.fanshr.step.dto.Execution;
import com.fanshr.step.dto.Payload;
import com.fanshr.step.dto.Result;
import com.fanshr.step.entity.InterviewItem;
import com.fanshr.step.enums.ErrorCode;
import com.fanshr.step.enums.StateEnum;
import com.fanshr.step.service.InterviewItemService;
import com.fanshr.step.utils.ParamUtil;
import com.fanshr.step.utils.ResultUtil;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/interview/item/")
public class InterviewItemController {
    private static final Logger logger = LoggerFactory.getLogger(InterviewItemController.class);


    @Autowired
    private InterviewItemService interviewItemService;

    @GetMapping("getAll")
    public Result<Payload> get(HttpServletRequest request) {
        Payload payload = new Payload();
        int pageIndex = ParamUtil.getInt(request, DataConstant.CURRENT);
        int pageSize = ParamUtil.getInt(request, DataConstant.PAGE_SIZE);
        if (pageIndex > 0 && pageSize > 0) {
            InterviewItem condition = new InterviewItem();
            // int categoryId = ParamUtil.getInt(request, "categoryId");
            // if (categoryId > 0) {
            //     condition.setCategoryId(categoryId);
            // }
            // String tags = ParamUtil.getString(request, "tags");
            // if (tags != null) {
            //     condition.setTags(tags);
            // }

            try {
                Execution execution = interviewItemService.get(condition, pageIndex, pageSize);
                if (execution.getState() == StateEnum.SUCCESS.getState()) {
                    payload.setList(execution.getList());
                    payload.setTotal(execution.getCount());
                    return ResultUtil.success(payload);
                } else {
                    return ResultUtil.error(execution.getStateInfo());
                }
            } catch (Exception e) {
                return ResultUtil.error(e.toString());
            }


        } else {
            return ResultUtil.error(ErrorCode.INDEX_IS_NULL);
        }

    }


    @GetMapping("getOne")
    public Result getOne(HttpServletRequest request) {
        InterviewItem interviewItem = null;
        int id = ParamUtil.getInt(request, "id");

        try {
            interviewItem = interviewItemService.get(id);
            return ResultUtil.success(interviewItem);
        } catch (Exception e) {
            return ResultUtil.error(ErrorCode.INNER_ERROR);
        }

    }


    @PostMapping("add")
    public Result add(@RequestBody InterviewItem interviewItem) {

        if (interviewItem != null) {
            try {
                Execution execution =
                        interviewItemService.add(interviewItem);
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
    public Result modify(@RequestBody InterviewItem interviewItem) {


        if (interviewItem != null && interviewItem.getId() != null) {
            try {
                // interviewItem.setTitle(interviewItem.getTitle() == null ? null :
                //         URLDecoder.decode(interviewItem.getTitle(), "UTF-8"));
                // interviewItem.setDescription(interviewItem.getDescription() == null ? null :
                //         URLDecoder.decode(interviewItem.getDescription(), "UTF-8"));
                // interviewItem.setRemark(interviewItem.getRemark() == null ? null :
                //         URLDecoder.decode(interviewItem.getRemark(), "UTF-8"));

                Execution execution =
                        interviewItemService.modify(interviewItem);
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
            Execution execution = interviewItemService.remove(id);
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
    public Result multiRemove(String interviewItemIdListStr) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Integer.class);

        List<Integer> interviewItemIdList = null;

        try {
            interviewItemIdList = mapper.readValue(interviewItemIdListStr, javaType);
        } catch (IOException e) {

            return ResultUtil.error(ErrorCode.INVALID_PARAM, e.toString());
        }

        if (interviewItemIdList != null && interviewItemIdList.size() > 0) {
            Execution execution =
                    interviewItemService.multiRemove(interviewItemIdList);
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
