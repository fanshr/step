package com.fanshr.step.engine.core.domain.vo;

import com.fanshr.step.engine.question.domain.dto.QuestionDto;
import com.fanshr.step.engine.question.domain.entity.Question;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/6/12 23:45
 * @date : Modified at 2022/6/12 23:45
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "QuestionTagVo 对象", description = "标签信息")
public class QuestionTagVo implements Serializable {
    private static final long serialVersionUID = 900933239056207609L;
    private Integer id;
    @ApiModelProperty("标签名称")
    private String title;
    @ApiModelProperty("显示顺序")
    private BigDecimal display;

    List<QuestionDto> questionDtoList;
}
