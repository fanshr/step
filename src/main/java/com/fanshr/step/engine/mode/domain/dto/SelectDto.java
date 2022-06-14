package com.fanshr.step.engine.mode.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/6/12 22:59
 * @date : Modified at 2022/6/12 22:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SelectDto 对象", description = "公用选择框字段信息")
public class SelectDto implements Serializable {

    private static final long serialVersionUID = 6451941734064827386L;
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("描述")
    private String description;

}
