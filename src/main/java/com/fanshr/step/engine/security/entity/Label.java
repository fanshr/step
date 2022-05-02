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
 * 标签索引信息
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Getter
@Setter
@TableName("sys_label")
@ApiModel(value = "Label对象", description = "标签索引信息")
public class Label implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;


}
