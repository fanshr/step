package com.fanshr.step.engine.security.domain.vo;

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
 * 权限细项描述表
 * </p>
 *
 * @author LiuYJ
 * @since 2022-06-13
 */
@Getter
@Setter
@TableName("security_right_detail")
@ApiModel(value = "RightDetailVo对象", description = "权限细项描述表")
public class RightDetailVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("权限项")
    @TableField("right_id")
    private Integer rightId;

    @ApiModelProperty("细项名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("细项标识")
    @TableField("mark")
    private String mark;

    @ApiModelProperty("资源名称")
    @TableField("asset")
    private String asset;

    @ApiModelProperty("资源路径")
    @TableField("url")
    private String url;


}
