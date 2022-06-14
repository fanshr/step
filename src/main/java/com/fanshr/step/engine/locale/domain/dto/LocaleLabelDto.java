package com.fanshr.step.engine.locale.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 标签国际化信息
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("locale_label")
@ApiModel(value = "LocaleLabelDto对象", description = "标签国际化信息")
public class LocaleLabelDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("index_id")
    private Integer indexId;

    @ApiModelProperty("语言标识")
    @TableField("language_id")
    private Integer languageId;

    @ApiModelProperty("标题")
    @TableField("title")
    private String title;


}