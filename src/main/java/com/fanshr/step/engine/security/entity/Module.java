package com.fanshr.step.engine.security.entity;

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
 * 功能模块表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Getter
@Setter
@TableName("sys_module")
@ApiModel(value = "Module对象", description = "功能模块表")
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("模块名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("模块描述")
    @TableField("description")
    private String description;


}