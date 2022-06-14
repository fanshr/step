package com.fanshr.step.engine.core.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/6/12 23:45
 * @date : Modified at 2022/6/12 23:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "TagGroupDto 对象", description = "标签组信息")
public class TagGroupDto implements Serializable {

    private static final long serialVersionUID = -2983580744329003853L;

    private Integer id;

    @ApiModelProperty("标签体系类别")
    private Integer typeId;

    @ApiModelProperty("标签组名称")
    private String title;

    @ApiModelProperty("标签组标识")
    private String mark;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("显示顺序")
    private BigDecimal display;






}
