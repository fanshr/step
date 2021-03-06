package com.fanshr.step.web;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.dto.Execution;
import com.fanshr.step.dto.Payload;
import com.fanshr.step.dto.Result;
import com.fanshr.step.entity.InterviewTag;
import com.fanshr.step.enums.ErrorCode;
import com.fanshr.step.enums.StateEnum;
import com.fanshr.step.service.InterviewTagService;
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
@RequestMapping("/interview/tag/")
public class InterviewTagController {
    private static final Logger logger = LoggerFactory.getLogger(InterviewTagController.class);


    @Autowired
    private InterviewTagService interviewTagService;

    @GetMapping("getAll")
    public Result<Payload> get() {
        Payload payload = new Payload();
        try {
            List<InterviewTag> interviewTagList = interviewTagService.get();
            payload.setList(interviewTagList);
            payload.setTotal(interviewTagList.size());
            return ResultUtil.success(payload);
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }




    @GetMapping("getOne")
    public Result getOne(HttpServletRequest request) {
        InterviewTag interviewTag = null;
        int id = ParamUtil.getInt(request, "id");

        try {
            interviewTag = interviewTagService.get(id);
            return ResultUtil.success(interviewTag);
        } catch (Exception e) {
            return ResultUtil.error(ErrorCode.INNER_ERROR);
        }

    }


    @PostMapping("add")
    public Result add(@RequestBody InterviewTag interviewTag) {

        if (interviewTag != null) {
            try {
                Execution execution =
                        interviewTagService.add(interviewTag);
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
    public Result modify(@RequestBody InterviewTag interviewTag) {


        if (interviewTag != null && interviewTag.getId() != null) {
            try {
                // interviewTag.setTitle(interviewTag.getTitle() == null ? null :
                //         URLDecoder.decode(interviewTag.getTitle(), "UTF-8"));
                // interviewTag.setDescription(interviewTag.getDescription() == null ? null :
                //         URLDecoder.decode(interviewTag.getDescription(), "UTF-8"));
                // interviewTag.setRemark(interviewTag.getRemark() == null ? null :
                //         URLDecoder.decode(interviewTag.getRemark(), "UTF-8"));

                Execution execution =
                        interviewTagService.modify(interviewTag);
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
            Execution execution = interviewTagService.remove(id);
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
    public Result multiRemove(String interviewTagIdListStr) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Integer.class);

        List<Integer> interviewTagIdList = null;

        try {
            interviewTagIdList = mapper.readValue(interviewTagIdListStr, javaType);
        } catch (IOException e) {

            return ResultUtil.error(ErrorCode.INVALID_PARAM, e.toString());
        }

        if (interviewTagIdList != null && interviewTagIdList.size() > 0) {
            Execution execution =
                    interviewTagService.multiRemove(interviewTagIdList);
            if (execution.getState() == StateEnum.SUCCESS.getState()) {
                return ResultUtil.success();
            } else {
                return ResultUtil.error(execution.getStateInfo());
            }

        } else {
            return ResultUtil.error(ErrorCode.EMPTY);
        }
    }

    @PostMapping("test1")
    public Result test1(Long id) {
        System.out.println("??????Long id-->" + id);
        return ResultUtil.success(id);

    }

    @PostMapping("test2")
    public Result test2(@RequestBody List<Long> idList) {
        System.out.println("??????Long id-->" + JSON.toJSONString(idList));
        return ResultUtil.success(idList);
    }
}
