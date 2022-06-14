package com.fanshr.step.engine.mode.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 一级字段类型
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("mode_field_type")
@ApiModel(value = "FieldType对象", description = "一级字段类型")
public class FieldType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("类型名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("语言标识")
    @TableField("label_id")
    private Integer labelId;

    @ApiModelProperty("样式名称")
    @TableField("class_name")
    private String className;

    @ApiModelProperty("明细可用")
    @TableField("dt_use")
    private Integer dtUse;

    @ApiModelProperty("显示顺序")
    @TableField("display")
    private BigDecimal display;

    @ApiModelProperty("是否封存")
    @TableField("canceled")
    private Integer canceled;


}
