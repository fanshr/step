package com.fanshr.step.engine.security.domain.entity;

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
 * 权限与角色映射表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("map_role_right")
@ApiModel(value = "RoleRight对象", description = "权限与角色映射表")
public class RoleRight implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("角色")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty("权限")
    @TableField("right_id")
    private Integer rightId;

    @ApiModelProperty("权限级别")
    @TableField("right_level")
    private Integer rightLevel;


}
