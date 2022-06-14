package com.fanshr.step.engine.question.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 题目关联表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("map_graph_question")
@ApiModel(value = "GraphQuestionDto对象", description = "题目关联表")
public class GraphQuestionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("主语标签")
    @TableField("left_question_id")
    private Integer leftQuestionId;

    @ApiModelProperty("宾语标签")
    @TableField("right_question_id")
    private Integer rightQuestionId;

    @ApiModelProperty("标签体系类别")
    @TableField("type_id")
    private Integer typeId;

    @ApiModelProperty("谓语关系标识")
    @TableField("relation_id")
    private Integer relationId;


}
