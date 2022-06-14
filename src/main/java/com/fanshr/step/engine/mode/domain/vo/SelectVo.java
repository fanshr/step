package com.fanshr.step.engine.mode.domain.vo;

import com.fanshr.step.engine.mode.domain.dto.SelectOptionDto;
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
@ApiModel(value = "SelectVo对象", description = "公用选择框字段信息")
public class SelectVo  implements Serializable {
    private static final long serialVersionUID = 2337066261046437534L;
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("选择框条目详情")
    List<SelectOptionDto> selectOptionDtoList;
}
