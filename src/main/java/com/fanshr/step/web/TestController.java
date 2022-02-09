package com.fanshr.step.web;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.dto.Result;
import com.fanshr.step.entity.InterviewCategory;
import com.fanshr.step.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/2/4 23:10
 * @date : Modified at 2022/2/4 23:10
 */
@RestController
@RequestMapping("/sa/test/")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("get")
    private Result getData(){

        InterviewCategory category = new InterviewCategory();
        category.setTitle("2342");
        category.setDescription("dhfkdfakjhd");
        return ResultUtil.success(category);

    }



    // @RequestMapping(value = "saveByRequest", method = RequestMethod.POST)
    @PostMapping("saveByRequest")
    private Result save1(HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("参数Map"+ JSON.toJSONString(parameterMap));


        return ResultUtil.success();


    }




    // @RequestMapping(value = "/saveByJson", method = RequestMethod.POST)
    // @ResponseBody
    @PostMapping("/saveByJson")
    private Result save2(@RequestBody InterviewCategory interviewCategory) {
        System.out.println("参数"+JSON.toJSONString(interviewCategory));
        System.out.println("对象"+interviewCategory);
        logger.error("参数-->{}",JSON.toJSONString(interviewCategory));

        return ResultUtil.success();


    }
    // @RequestMapping(value = "/saveByParams", method = RequestMethod.POST)
    // @ResponseBody
    @PostMapping("saveByParams")
    private Result save3(String title, @RequestParam(value = "description",required = false) String desc, String remark, Double showOrder) {

        System.out.println("关键参数-->"+title+"--"+desc+"--"+remark+"--"+showOrder);
        logger.error("关键参数--->{}--{}--{}--{}",title,desc,remark,showOrder);



        return ResultUtil.success();


    }
    // @RequestMapping(value = "/saveByEntity", method = RequestMethod.POST)
    // @ResponseBody
    @PostMapping("saveByEntity")
    private Result save4(InterviewCategory interviewCategory) {


        System.out.println("参数"+JSON.toJSONString(interviewCategory));
        logger.error("参数-->{}",JSON.toJSONString(interviewCategory));

        return ResultUtil.success();
    }
}
