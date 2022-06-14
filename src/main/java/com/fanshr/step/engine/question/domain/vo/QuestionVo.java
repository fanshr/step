package com.fanshr.step.engine.question.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fanshr.step.engine.question.domain.dto.QuestionAnswerDto;
import com.fanshr.step.engine.question.domain.dto.QuestionTitleDto;
import com.fanshr.step.engine.mode.domain.dto.SelectOptionDto;
import com.fanshr.step.engine.core.domain.dto.TagDto;
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
 * @date : Created at 2022/6/13 01:17
 * @date : Modified at 2022/6/13 01:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "QuestionVo 对象", description = "问题详情")
public class QuestionVo implements Serializable {

    private static final long serialVersionUID = -7041646855371493651L;

    private Integer id;

    @ApiModelProperty("标签体系类别")
    private Integer typeId;

    @ApiModelProperty("题目名称")
    private String title;

    @ApiModelProperty("题目类别")
    private Integer categoryId;

    @ApiModelProperty("标签")
    private String tags;

    @ApiModelProperty("热度")
    private BigDecimal frequency;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("是否封存")
    private Integer canceled;

    @ApiModelProperty("拼音检索")
    private String pinyin;

    @ApiModelProperty("显示顺序")
    @TableField("display")
    private BigDecimal display;

    @ApiModelProperty("创建人")
    @TableField("creator_id")
    private Integer creatorId;

    @ApiModelProperty("标签体系")
    private SelectOptionDto tagSelectOption;

    @ApiModelProperty("题目类别")
    private SelectOptionDto questionSelectOption;

    @ApiModelProperty("标签列表")
    private List<TagDto> tagDtoList;

    @ApiModelProperty("题目列表")
    private List<QuestionTitleDto> questionTitleDtoList;

    @ApiModelProperty("参考回答")
    private QuestionAnswerDto questionAnswerDto;

    @ApiModelProperty("回答列表")
    private List<QuestionAnswerDto> questionAnswerDtoList;




}
