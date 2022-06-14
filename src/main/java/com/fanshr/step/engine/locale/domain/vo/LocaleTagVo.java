package com.fanshr.step.engine.locale.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 标签多语言描述表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("locale_tag")
@ApiModel(value = "LocaleTagVo对象", description = "标签多语言描述表")
public class LocaleTagVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("index_id")
    private Integer indexId;

    @ApiModelProperty("语言标识")
    @TableField("language_id")
    private Integer languageId;

    @ApiModelProperty("标签名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("标签描述")
    @TableField("description")
    private String description;


}
