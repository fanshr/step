package com.fanshr.step.web;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.dto.Execution;
import com.fanshr.step.dto.Payload;
import com.fanshr.step.dto.Result;
import com.fanshr.step.entity.InterviewCategory;
import com.fanshr.step.enums.ErrorCode;
import com.fanshr.step.enums.StateEnum;
import com.fanshr.step.service.InterviewCategoryService;
import com.fanshr.step.utils.ParamUtil;
import com.fanshr.step.utils.ResultUtil;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/1 17:04
 * @date : Modified at 2022/2/1 17:04
 */

@Controller
@RequestMapping("/interview/category/")
public class InterviewCategoryController {
    private static final Logger logger = LoggerFactory.getLogger(InterviewCategoryController.class);


    @Autowired
    private InterviewCategoryService interviewCategoryService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Result<Payload> get() {
        Payload payload = new Payload();
        try {
            List<InterviewCategory> interviewCategoryList = interviewCategoryService.get2(null);

            payload.setList(interviewCategoryList);
            payload.setTotal(interviewCategoryList.size());
            return ResultUtil.success(payload);
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }


    @RequestMapping(value = "getOne", method = RequestMethod.GET)
    @ResponseBody
    public Result getOne(HttpServletRequest request) {
        InterviewCategory interviewCategory = null;
        int id = ParamUtil.getInt(request, "id");

        try {
            interviewCategory = interviewCategoryService.get(id);
            return ResultUtil.success(interviewCategory);
        } catch (Exception e) {
            return ResultUtil.error(ErrorCode.INNER_ERROR);
        }

    }

    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    @ResponseBody
    public Result get1() {
        List<InterviewCategory> list = new ArrayList<>();

        try {
            list = interviewCategoryService.get();
        } catch (Exception e) {
            return ResultUtil.error(ErrorCode.INNER_ERROR);
        }
        return ResultUtil.success(list);
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        InterviewCategory interviewCategory = null;

        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("参数Map"+ JSON.toJSONString(parameterMap));

        String interviewCategoryStr = ParamUtil.getString(request, "interviewCategoryStr");

        System.out.println("参数"+interviewCategoryStr);
        logger.info("参数-->{}",interviewCategoryStr);

        try {
            interviewCategory = mapper.readValue(interviewCategoryStr, InterviewCategory.class);
        } catch (Exception e) {
            logger.error("解析异常-->{}",e.toString());
            return ResultUtil.error(ErrorCode.INVALID_PARAM, e.toString());
        }

        if (interviewCategory != null) {
            try {
                interviewCategory.setTitle(interviewCategory.getTitle() == null ? null :
                        URLDecoder.decode(interviewCategory.getTitle(), "UTF-8"));
                interviewCategory.setDescription(interviewCategory.getDescription() == null ? null :
                        URLDecoder.decode(interviewCategory.getDescription(), "UTF-8"));
                interviewCategory.setRemark(interviewCategory.getRemark() == null ? null :
                        URLDecoder.decode(interviewCategory.getRemark(), "UTF-8"));
                Execution execution =
                        interviewCategoryService.add(interviewCategory);
                if (execution.getState() == StateEnum.SUCCESS.getState()) {
                    return ResultUtil.success();
                } else {
                    return ResultUtil.error(execution.getStateInfo());
                }

            } catch (UnsupportedEncodingException e) {
                return ResultUtil.error(e.toString());
            }
        } else {
            return ResultUtil.error(ErrorCode.DATA_IS_NULL);
        }
    }


    @RequestMapping(value = "modify", method = RequestMethod.POST)
    @ResponseBody
    public Result modify(HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        InterviewCategory interviewCategory = null;
        String interviewCategoryStr = ParamUtil.getString(request, "interviewCategoryStr");

        try {
            interviewCategory = mapper.readValue(interviewCategoryStr, InterviewCategory.class);
        } catch (Exception e) {
            return ResultUtil.error(ErrorCode.INVALID_PARAM, e.toString());
        }

        if (interviewCategory != null && interviewCategory.getId() != null) {
            try {
                interviewCategory.setTitle(interviewCategory.getTitle() == null ? null :
                        URLDecoder.decode(interviewCategory.getTitle(), "UTF-8"));
                interviewCategory.setDescription(interviewCategory.getDescription() == null ? null :
                        URLDecoder.decode(interviewCategory.getDescription(), "UTF-8"));
                interviewCategory.setRemark(interviewCategory.getRemark() == null ? null :
                        URLDecoder.decode(interviewCategory.getRemark(), "UTF-8"));

                Execution execution =
                        interviewCategoryService.modify(interviewCategory);
                if (execution.getState() == StateEnum.SUCCESS.getState()) {
                    return ResultUtil.success();
                } else {
                    return ResultUtil.error(execution.getStateInfo());
                }

            } catch (UnsupportedEncodingException e) {
                return ResultUtil.error(e.toString());
            }
        } else {
            return ResultUtil.error(ErrorCode.ID_IS_NULL);
        }
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    @ResponseBody
    public Result remove(Integer id) {
        if (id != null && id > 0) {
            Execution execution = interviewCategoryService.remove(id);
            if (execution.getState() == StateEnum.SUCCESS.getState()) {

                return ResultUtil.success();
            } else {
                return ResultUtil.error(execution.getStateInfo());
            }
        } else {
            return ResultUtil.error(ErrorCode.DATA_IS_NULL);
        }
    }


    @RequestMapping(value = "multiRemove", method = RequestMethod.POST)
    @ResponseBody
    public Result multiRemove(String interviewCategoryIdListStr) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Integer.class);

        List<Integer> interviewCategoryIdList = null;

        try {
            interviewCategoryIdList = mapper.readValue(interviewCategoryIdListStr, javaType);
        } catch (IOException e) {

            return ResultUtil.error(ErrorCode.INVALID_PARAM, e.toString());
        }

        if (interviewCategoryIdList != null && interviewCategoryIdList.size() > 0) {
            Execution execution =
                    interviewCategoryService.multiRemove(interviewCategoryIdList);
            if (execution.getState() == StateEnum.SUCCESS.getState()) {
                return ResultUtil.success();
            } else {
                return ResultUtil.error(execution.getStateInfo());
            }

        } else {
            return ResultUtil.error(ErrorCode.EMPTY);
        }
    }



    @RequestMapping(value = "/saveByRequest", method = RequestMethod.POST)
    @ResponseBody
    private Result save1(HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("参数Map"+ JSON.toJSONString(parameterMap));


        return ResultUtil.success();


    }




    @RequestMapping(value = "/saveByJson", method = RequestMethod.POST)
    @ResponseBody
    private Result save2(@RequestBody InterviewCategory interviewCategory) {
        System.out.println("参数"+JSON.toJSONString(interviewCategory));
        System.out.println("对象"+interviewCategory);
        logger.error("参数-->{}",JSON.toJSONString(interviewCategory));

        return ResultUtil.success();


    }
    @RequestMapping(value = "/saveByParams", method = RequestMethod.POST)
    @ResponseBody
    private Result save3(String title, @RequestParam(value = "description",required = false) String desc, String remark, Double showOrder) {

        System.out.println("关键参数-->"+title+"--"+desc+"--"+remark+"--"+showOrder);
        logger.error("关键参数--->{}--{}--{}--{}",title,desc,remark,showOrder);



        return ResultUtil.success();


    }
    @RequestMapping(value = "/saveByEntity", method = RequestMethod.POST)
    @ResponseBody
    private Result save4(InterviewCategory interviewCategory) {


        System.out.println("参数"+JSON.toJSONString(interviewCategory));
        logger.error("参数-->{}",JSON.toJSONString(interviewCategory));

        return ResultUtil.success();
    }

}
