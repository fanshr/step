package com.fanshr.step.engine.core.domain.dto;

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
 * 系统语言可选表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("core_language")
@ApiModel(value = "LanguageDto对象", description = "系统语言可选表")
public class LanguageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("语言")
    @TableField("language")
    private String language;

    @ApiModelProperty("语言编码")
    @TableField("encoding")
    private String encoding;

    @ApiModelProperty("是否启用")
    @TableField("enable")
    private Integer enable;


}
