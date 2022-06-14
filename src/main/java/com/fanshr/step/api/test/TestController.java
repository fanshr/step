package com.fanshr.step.api.test;

import com.alibaba.fastjson.JSON;
import com.fanshr.step.engine.common.dto.Result;
import com.fanshr.step.engine.question.domain.entity.Category;
import com.fanshr.step.engine.common.utils.ResultUtil;
import com.fanshr.step.engine.question.domain.entity.QuestionItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "测试类")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("get")
    @ApiOperation("get请求测试")
    private Result getData(){

        Category category = new Category();
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
    private Result save2(@RequestBody Category category) {
        System.out.println("参数"+JSON.toJSONString(category));
        System.out.println("对象"+ category);
        logger.error("参数-->{}",JSON.toJSONString(category));

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
    private Result save4(Category category) {


        System.out.println("参数"+JSON.toJSONString(category));
        logger.error("参数-->{}",JSON.toJSONString(category));

        return ResultUtil.success();
    }


    @PostMapping("testRequestBody")
    private Result testRequestBody(@RequestBody QuestionItem questionItem){
        logger.error("logger-进入测试方法...");
        System.out.println("sout-进入测试方法");
        System.out.println("item-->"+questionItem);

        return ResultUtil.success();
    }

    @GetMapping("testBean")
    private Result testBean(QuestionItem questionItem,Integer pageSize,Integer current){
        logger.error("logger-进入测试方法...");
        System.out.println("sout-进入测试方法");
        System.out.println("item-->"+questionItem);
        System.out.println("关键参数-->"+current+"--"+pageSize);

        return ResultUtil.success();
    }
}
