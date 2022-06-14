package com.fanshr.step.engine.core.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author : LiuYJ
 * @version : v1.0
 * @date : Created at 2022/6/13 10:45
 * @date : Modified at 2022/6/13 10:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "TagDto 对象", description = "标签信息")
public class TagDto implements Serializable {
    private static final long serialVersionUID = -6308735601249421998L;
    private Integer id;
    @ApiModelProperty("标签名称")
    private String title;
    @ApiModelProperty("显示顺序")
    private BigDecimal display;
}
