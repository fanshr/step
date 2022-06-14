package com.fanshr.step.engine.security.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("security_right")
@ApiModel(value = "RightDto对象", description = "权限表")
public class RightDto implements Serializable {

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
