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
 * 权限组表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("security_right_group")
@ApiModel(value = "RightGroup对象", description = "权限组表")
public class RightGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("权限组名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("权限组标识")
    @TableField("mark")
    private String mark;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;


}
