package com.fanshr.step.api.question;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.engine.common.dto.Execution;
import com.fanshr.step.engine.common.dto.PageBean;
import com.fanshr.step.engine.common.dto.Result;
import com.fanshr.step.engine.question.entity.Category;
import com.fanshr.step.engine.common.enums.ErrorCode;
import com.fanshr.step.engine.common.enums.StateEnum;
import com.fanshr.step.engine.question.service.CategoryService;
import com.fanshr.step.engine.common.utils.ParamUtil;
import com.fanshr.step.engine.common.utils.ResultUtil;
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
@RequestMapping("/question/category/")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);


    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    @ResponseBody
    public Result<PageBean> getAll(String title, String description, Integer id, Integer parentId) {

        PageBean pageBean = new PageBean();
        try {
            Category condition = new Category();
            condition.setTitle(title);
            condition.setDescription(description);
            condition.setId(id);
            condition.setParentId(parentId);
            List<Category> categoryList = categoryService.get(condition);


            pageBean.setList(categoryList);
            pageBean.setTotal(categoryList.size());
            return ResultUtil.success(pageBean);
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }


    @RequestMapping(value = "getOne", method = RequestMethod.GET)
    @ResponseBody
    public Result getOne(HttpServletRequest request) {
        Category category = null;
        int id = ParamUtil.getInt(request, "id");

        try {
            category = categoryService.get(id);
            return ResultUtil.success(category);
        } catch (Exception e) {
            return ResultUtil.error(ErrorCode.INNER_ERROR);
        }

    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        Category category = null;

        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("参数Map"+ JSON.toJSONString(parameterMap));

        String interviewCategoryStr = ParamUtil.getString(request, "interviewCategoryStr");

        System.out.println("参数"+interviewCategoryStr);
        logger.info("参数-->{}",interviewCategoryStr);

        try {
            category = mapper.readValue(interviewCategoryStr, Category.class);
        } catch (Exception e) {
            logger.error("解析异常-->{}",e.toString());
            return ResultUtil.error(ErrorCode.INVALID_PARAM, e.toString());
        }

        if (category != null) {
            try {
                category.setTitle(category.getTitle() == null ? null :
                        URLDecoder.decode(category.getTitle(), "UTF-8"));
                category.setDescription(category.getDescription() == null ? null :
                        URLDecoder.decode(category.getDescription(), "UTF-8"));
                category.setRemark(category.getRemark() == null ? null :
                        URLDecoder.decode(category.getRemark(), "UTF-8"));
                Execution execution =
                        categoryService.add(category);
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
        Category category = null;
        String interviewCategoryStr = ParamUtil.getString(request, "interviewCategoryStr");

        try {
            category = mapper.readValue(interviewCategoryStr, Category.class);
        } catch (Exception e) {
            return ResultUtil.error(ErrorCode.INVALID_PARAM, e.toString());
        }

        if (category != null && category.getId() != null) {
            try {
                category.setTitle(category.getTitle() == null ? null :
                        URLDecoder.decode(category.getTitle(), "UTF-8"));
                category.setDescription(category.getDescription() == null ? null :
                        URLDecoder.decode(category.getDescription(), "UTF-8"));
                category.setRemark(category.getRemark() == null ? null :
                        URLDecoder.decode(category.getRemark(), "UTF-8"));

                Execution execution =
                        categoryService.modify(category);
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
            Execution execution = categoryService.remove(id);
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
                    categoryService.multiRemove(interviewCategoryIdList);
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
    private Result save2(@RequestBody Category category) {
        System.out.println("参数"+JSON.toJSONString(category));
        System.out.println("对象"+ category);
        logger.error("参数-->{}",JSON.toJSONString(category));

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
    private Result save4(Category category) {


        System.out.println("参数"+JSON.toJSONString(category));
        logger.error("参数-->{}",JSON.toJSONString(category));

        return ResultUtil.success();
    }

}
