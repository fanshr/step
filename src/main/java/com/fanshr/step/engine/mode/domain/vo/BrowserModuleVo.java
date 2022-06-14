package com.fanshr.step.engine.mode.domain.vo;

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
 * 浏览框模块表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("mode_browser_module")
@ApiModel(value = "BrowserModuleVo对象", description = "浏览框模块表")
public class BrowserModuleVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("浏览标识")
    @TableField("browser_id")
    private Integer browserId;

    @ApiModelProperty("模块标识")
    @TableField("module_code")
    private String moduleCode;


}