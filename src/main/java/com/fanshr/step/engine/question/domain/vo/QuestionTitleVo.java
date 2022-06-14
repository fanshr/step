package com.fanshr.step.engine.question.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 题目明细表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "QuestionTitleVo 对象", description = "题目简要信息")
public class QuestionTitleVo implements Serializable {


    private static final long serialVersionUID = -3503112724593991648L;

    private Integer id;

    @ApiModelProperty("题目标识")
    private Integer mainId;

    @ApiModelProperty("题目内容")
    private String content;

    @ApiModelProperty("题目所有者")
    private Integer ownerId;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("是否默认选中")
    private Integer checked;

    @ApiModelProperty("是否封存")
    private Integer canceled;

    @ApiModelProperty("拼音检索")
    private String pinyin;

    @ApiModelProperty("显示顺序")
    private BigDecimal display;

    @ApiModelProperty("创建人")
    private Integer creatorId;




}
