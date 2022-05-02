package com.fanshr.step.engine.security.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 语句显示信息
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Getter
@Setter
@TableName("sys_i18n_note")
@ApiModel(value = "I18nNote对象", description = "语句显示信息")
public class I18nNote implements Serializable {

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
