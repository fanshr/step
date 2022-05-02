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
 * 权限多语言描述表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Getter
@Setter
@TableName("sys_i18n_right")
@ApiModel(value = "I18nRight对象", description = "权限多语言描述表")
public class I18nRight implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("index_id")
    private Integer indexId;

    @ApiModelProperty("语言标识")
    @TableField("language_id")
    private Integer languageId;

    @ApiModelProperty("权限名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("权限描述")
    @TableField("description")
    private String description;


}
