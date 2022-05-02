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
 * 权限表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-05-02
 */
@Getter
@Setter
@TableName("sys_right")
@ApiModel(value = "Right对象", description = "权限表")
public class Right implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("权限描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("权限类别")
    @TableField("type_id")
    private Integer typeId;

    @ApiModelProperty("是否可拆卸")
    @TableField("detachable")
    private Integer detachable;


}