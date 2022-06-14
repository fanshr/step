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
@TableName("map_role_user")
@ApiModel(value = "RoleUser对象", description = "权限与角色映射表")
public class RoleUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("角色")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty("用户")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("生效级别")
    @TableField("user_level")
    private Integer userLevel;


}
