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
 * 浏览框一级分类
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("mode_browser")
@ApiModel(value = "Browser对象", description = "浏览框一级分类")
public class Browser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("标签标识")
    @TableField("label_id")
    private Integer labelId;

    @ApiModelProperty("是否启用")
    @TableField("enable")
    private Integer enable;

    @ApiModelProperty("是否可更改")
    @TableField("changeable")
    private Integer changeable;

    @ApiModelProperty("显示顺序")
    @TableField("display")
    private BigDecimal display;


}
