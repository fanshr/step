package com.fanshr.step.api.question;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.common.dto.PageBean;
import com.fanshr.step.engine.common.dto.Result;
import com.fanshr.step.engine.question.entity.Tag;
import com.fanshr.step.engine.common.enums.ErrorCode;
import com.fanshr.step.engine.common.enums.StateEnum;
import com.fanshr.step.engine.question.service.TagService;
import com.fanshr.step.engine.common.utils.ParamUtil;
import com.fanshr.step.engine.common.utils.ResultUtil;
import com.fanshr.step.engine.question.utils.StringUtil;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/question/tag/")
@Slf4j
public class TagController {
    // private static final Logger log = LoggerFactory.getLogger(TagController.class);


    @Autowired
    private TagService tagService;

    @GetMapping("getAll")
    public Result<PageBean> getAll(String title, String description,Integer id) {
        PageBean pageBean = new PageBean();
        try {
            Tag condition = new Tag();
            condition.setTitle(StringUtil.toCondition(title));
            condition.setDescription(StringUtil.toCondition(description));
            condition.setId(id);
            List<Tag> tagList = tagService.get(condition);
            pageBean.setList(tagList);
            pageBean.setTotal(tagList.size());
            return ResultUtil.success(pageBean);
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }

    // @GetMapping("checkRepeat")
    // public Result checkRepeat(String title) {
    //
    // }




    @GetMapping("getOne")
    public Result getOne(HttpServletRequest request) {
        Tag tag = null;
        int id = ParamUtil.getInt(request, "id");

        try {
            tag = tagService.get(id);
            return ResultUtil.success(tag);
        } catch (Exception e) {
            return ResultUtil.error(ErrorCode.INNER_ERROR);
        }

    }


    @PostMapping("add")
    public Result add(@RequestBody Tag tag) {

        if (tag != null) {
            try {
                Execution execution =
                        tagService.add(tag);
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
    public Result modify(@RequestBody Tag tag) {


        if (tag != null && tag.getId() != null) {
            try {
                // interviewTag.setTitle(interviewTag.getTitle() == null ? null :
                //         URLDecoder.decode(interviewTag.getTitle(), "UTF-8"));
                // interviewTag.setDescription(interviewTag.getDescription() == null ? null :
                //         URLDecoder.decode(interviewTag.getDescription(), "UTF-8"));
                // interviewTag.setRemark(interviewTag.getRemark() == null ? null :
                //         URLDecoder.decode(interviewTag.getRemark(), "UTF-8"));

                Execution execution =
                        tagService.modify(tag);
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
            Execution execution = tagService.remove(id);
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
                    tagService.multiRemove(interviewTagIdList);
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
        System.out.println("测试Long id-->" + id);
        return ResultUtil.success(id);

    }

    @PostMapping("test2")
    public Result test2(@RequestBody List<Long> idList) {
        System.out.println("测试Long id-->" + JSON.toJSONString(idList));
        return ResultUtil.success(idList);
    }
}
