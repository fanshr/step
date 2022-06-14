package com.fanshr.step.engine.mode.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 浏览框配置表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("mode_browser_config")
@ApiModel(value = "BrowserConfig对象", description = "浏览框配置表")
public class BrowserConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("类型")
    @TableField("type")
    private String type;

    @ApiModelProperty("处理类")
    @TableField("clazz")
    private String clazz;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("链接")
    @TableField("link_url")
    private String linkUrl;


}
