package com.fanshr.step.engine.question.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fanshr.step.engine.question.domain.dto.QuestionDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/6/13 09:11
 * @date : Modified at 2022/6/13 09:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "QuestionAnswerVo 对象", description = "答案简要信息")
public class QuestionAnswerVo implements Serializable {

    private static final long serialVersionUID = -4373595219462569213L;

    private Integer id;

    @ApiModelProperty("题目标识")
    private Integer mainId;

    @ApiModelProperty("回答内容")
    private String content;

    @ApiModelProperty("关联文档")
    private Integer fileId;

    @ApiModelProperty("回答所有者")
    private Integer ownerId;

    @ApiModelProperty("是否默认选中")
    private Integer checked;

    @ApiModelProperty("是否封存")
    private Integer canceled;

    @ApiModelProperty("拼音检索")
    private String pinyin;

    @ApiModelProperty("显示顺序")
    private BigDecimal display;


    @ApiModelProperty("uuid")
    private String uuid;

    @ApiModelProperty("创建人")
    private Integer creatorId;


    @ApiModelProperty("修改时刻")
    @TableField("modified")
    private Date modified;


    @ApiModelProperty("题目详情")
    private QuestionDto questionDto;
}
